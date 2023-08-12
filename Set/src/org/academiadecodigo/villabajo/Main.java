package org.academiadecodigo.villabajo;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #5 - Java Collections
 *
 * Pair programming with João Batista
 */
public class Main {

    public static final String STRING = "rui rui rui campelo campelo campelo test abc abc";

    public static void main(String[] args) {

        UniqueWord wc = new UniqueWord(STRING);

        for( String word : wc ) {
            System.out.println(word);
        }

    }
}
