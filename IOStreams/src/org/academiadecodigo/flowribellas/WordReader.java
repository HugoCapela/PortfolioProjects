package org.academiadecodigo.flowribellas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private String line = "";

    public WordReader(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }


    @Override
    public Iterator<String> iterator() {

        return new Iterator() {
            @Override
            public boolean hasNext() {
                try {
                    if (bufferedReader.ready()) {
                        return true;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return false;
            }

            @Override
            public Object next() {
                if (hasNext()){
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return null;
            }
        };
    }
}
