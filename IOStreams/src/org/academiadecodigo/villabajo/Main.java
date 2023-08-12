package org.academiadecodigo.villabajo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("/Users/codecadet/Documents/hugo-capela-repo/JavaExercises/IOStreams/test.txt");
        FileOutputStream outputStream = new FileOutputStream("/Users/codecadet/Documents/hugo-capela-repo/JavaExercises/IOStreams/copytest.txt");

        byte[] buffer = new byte[1024];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            System.out.println(bytesRead);
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();

    }
}
