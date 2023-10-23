package org.academiadecodigo.villabajo;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #7 - Java - Functional Programming
 *
 * --- File Analyzer App ---
 *
 * Main is used for testing and showing results of the FileAnalyzer class
 *
 */
public class Main {

    public static void main(String[] args) {

        File f1 = new File("src/Lightning1.txt");
        File f2 = new File("src/Lightning2.txt");
        FileAnalyzer fa = new FileAnalyzer();

        System.out.println( "File 1 Word Count: " + fa.wordCount(f1) );
        System.out.println( "File 2 Word Count: " + fa.wordCount(f2) );
        System.out.println("----------");

        System.out.println( "File 1 First Word Longer than: " + fa.firstLongerThan(f1, 5) );
        System.out.println( "File 2 First Word Longer than: " + fa.firstLongerThan(f2, 5) );
        System.out.println("----------");

        System.out.println("----------File1----------");
        List<String> longWordList1 = fa.longestNWords(f1, 5);
        System.out.println("File 1 Longest N Words:");
        for( String s : longWordList1 ) {
            System.out.println(s);
        }
        System.out.println("----------File2----------");
        List<String> longWordList2 = fa.longestNWords(f2, 5);
        System.out.println("File 2 Longest N Words:");
        for( String s : longWordList2 ) {
            System.out.println(s);
        }
        System.out.println("----------");

        Set<String> commonSet = fa.commonWords(f1,f2);
        System.out.println("Common words of File 1 with File 2:");
        for( String s : commonSet ) {
            System.out.println(s);
        }
        System.out.println("----------");

        System.out.println("Num of repeated words: " + fa.numOfRepeatedWords(f1,f2));
        System.out.println("----------");

        System.out.println("Longest word of File 1: " + fa.longestWord(f1));
        System.out.println("Longest word of File 2: " + fa.longestWord(f2));
        System.out.println("----------");

        System.out.println("----------File1----------");
        List<String> smallWordList1 = fa.smallestNWords(f1, 5);
        System.out.println("File 1 Smallest N Words:");
        for( String s : smallWordList1 ) {
            System.out.println(s);
        }
        System.out.println("----------File2----------");
        List<String> smallWordList2 = fa.smallestNWords(f2,5);
        System.out.println("File 2 Smallest N Words:");
        for (String s : smallWordList2) {
            System.out.println(s);
        }
        System.out.println("----------");

        System.out.println("Smallest word of File 1: " + fa.smallestWord(f1));
        System.out.println("Smallest word of File 2: " + fa.smallestWord(f2));
        System.out.println("----------");

        System.out.println("File 1 size in bytes: " + fa.fileSizeInBytes(f1));
        System.out.println("File 2 size in bytes: " + fa.fileSizeInBytes(f2));
        System.out.println("----------");

        System.out.println("File 1 size in KB: " + fa.fileSizeInKB(f1));
        System.out.println("File 2 size in KB: " + fa.fileSizeInKB(f2));
        System.out.println("----------");

        System.out.println("File 1 size in MB: " + fa.fileSizeInMB(f1));
        System.out.println("File 2 size in MB: " + fa.fileSizeInMB(f2));
        System.out.println("----------");

        System.out.println("File Not Found size in bytes: " + fa.fileSizeInBytes(new File("filenotfound")));
        System.out.println("----------");


    }
}
