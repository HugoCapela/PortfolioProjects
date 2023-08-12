package org.academiadecodigo.villabajo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #5 - Java I/O
 *
 * Pair programming with João Batista
 */
public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("test.txt");
        FileOutputStream outputStream = new FileOutputStream("copytest.txt");

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
