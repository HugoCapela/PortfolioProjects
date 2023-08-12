package org.academiadecodigo.flowribellas;

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


        WordReader wordReader = new WordReader("src/org/academiadecodigo/flowribellas/text.txt");

        while (wordReader.iterator().hasNext()){
            System.out.println(wordReader.getBufferedReader().readLine());
        }

        /*for (String s : wordReader) {
            System.out.println(s);
        }*/

        wordReader.getBufferedReader().close();
    }
}
