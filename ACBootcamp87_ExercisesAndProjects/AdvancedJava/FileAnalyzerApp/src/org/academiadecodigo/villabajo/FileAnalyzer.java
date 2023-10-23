package org.academiadecodigo.villabajo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyzer {

    private final String ERROR_MESSAGE = "ERROR: File has 0 Words or FileNotFound";

    // Method to get an array of single words from a file
    private Optional<String[]> getWords(File file) {

        String[] toReturn = new String[0];

        try {

            BufferedReader bufferedReader = new BufferedReader( new FileReader(file) );

            // BufferedReader.lines() method : Returns a Stream<String>,
            // the elements of which are lines read from this BufferedReader
            Stream<String> stringStream = bufferedReader.lines();

            // strStream has 5 elements
            // strStream is a stream that has each full line of the document

            /*Object[] strArr = strStream.toArray();
            for( Object line : strArr ) {
                System.out.println("Line: " + line);
            }*/
            // String[] str = strStream.toArray( String[]::new );
            /*String[] str = strStream.toArray( line -> new String[line]);
            for( String s : str ) {
                System.out.println("Line: " + s);
            }*/
            
            String fullFile = stringStream.reduce( "", (acc, line) -> acc + line + " " ).trim();

            // [^\p{L}\p{Nd}]+
            // this matches all (Unicode) characters that are neither letters nor (decimal) digits.
            toReturn = fullFile.split("[^a-zA-Z0-9']+");
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
        return Optional.of(toReturn);
    }

    // Returns the number of words of a file
    // Returns -1 if file has no words or FileNotFound
    public int wordCount(File file) {

        Optional<String[]> words = getWords(file);

        if( !words.isPresent() ) {
            return -1;
        }

        return words.get().length;
    }

    // Returns the first word longer than n
    // Returns ERROR message if file has no words or FileNotFound
    public String firstLongerThan(File file, int n) {

        Optional<String[]> words = getWords(file);

        if( !words.isPresent() ) {
            return ERROR_MESSAGE;
        }

        String[] strArr = words.get();

        List<String> wordsLongerThan = Stream.of(strArr)
                .filter( word -> word.length() > n )
                .collect(Collectors.toList());


        String error = "ERROR: No word longer than " + n + " characters.";

        return wordsLongerThan.isEmpty() ? error : wordsLongerThan.get(0);
    }

    // Method to sort the words in ascending order
    private Optional<List<String>> sortAscending(File file) {

        Optional<String[]> words = getWords(file);

        if( !words.isPresent() ) {
            return Optional.empty();
        }

        String[] strArr = words.get();

        return Optional.of( Stream.of(strArr)
                .sorted( (word1, word2) -> word1.length() - word2.length() )
                .collect(Collectors.toList()) );
    }

    // Method to sort the words in descending order
    private Optional<List<String>> sortDescending(File file) {

        Optional<String[]> words = getWords(file);

        if( !words.isPresent() ) {
            return Optional.empty();
        }

        String[] strArr = words.get();

        return Optional.of( Stream.of(strArr)
                .sorted( (word1, word2) -> word2.length() - word1.length() )
                .collect(Collectors.toList()) );
    }

    // Returns the n longest words of a File
    public List<String> longestNWords(File file, int n) {

        if( !sortDescending(file).isPresent() ) {
            return new LinkedList<>();
        }

        return sortDescending(file).get().stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    // Returns the n smallest words of a File
    public List<String> smallestNWords(File file, int n) {

        if( !sortAscending(file).isPresent() ) {
            return new LinkedList<>();
        }

        return sortAscending(file).get().stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    // Returns a Set of the common words of File 1 in File 2
    public Set<String> commonWords(File file1, File file2) {

        Optional<String[]> words1 = getWords(file1);
        Optional<String[]> words2 = getWords(file2);

        if( !words1.isPresent() || !words2.isPresent() ) {
            return new HashSet<>();
        }

        String[] words1StrArr = words1.get();
        String[] words2StrArr = words2.get();

        Stream<String> w1Stream = Stream.of(words1StrArr);
        List<String> w2List = Stream.of(words2StrArr).collect(Collectors.toList());

        return w1Stream.filter(word -> w2List.contains(word) )
                .collect(Collectors.toSet());
    }

    // Returns number of repeated words of File 1 in File 2
    public int numOfRepeatedWords(File file1, File file2) {

        Set<String> setWords = commonWords(file1, file2);

        return setWords.size();
    }

    // Returns the longest word of a File
    // If sorted Optional is empty, return error message
    public String longestWord(File file) {

        if( !sortDescending(file).isPresent() ) {
            return ERROR_MESSAGE;
        }

        return sortDescending(file).get().get(0);
    }

    // Returns the smallest word of a File
    // If sorted Optional is empty, return error message
    public String smallestWord(File file) {

        if( !sortAscending(file).isPresent() ) {
            return ERROR_MESSAGE;
        }

        return sortAscending(file).get().get(0);
    }

    // Return long with the size in bytes of the file passed as argument
    // Return -1 if FileNotFound
    public long fileSizeInBytes(File file) {
        if( !file.exists() ) {
            return -1;
        }
        return file.length();
    }

    // Return double with the size in kilobytes of the file passed as argument
    // Return -1 if FileNotFound
    public double fileSizeInKB(File file) {
        if( !file.exists() ) {
            return -1;
        }
        return fileSizeInBytes(file) * 0.001;
    }

    // Return double with the size in megabytes of the file passed as argument
    // Return -1 if FileNotFound
    public double fileSizeInMB(File file) {
        if( !file.exists() ) {
            return -1;
        }
        return fileSizeInBytes(file) * 0.000001;
    }

}
