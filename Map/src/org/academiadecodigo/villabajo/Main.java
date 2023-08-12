package org.academiadecodigo.villabajo;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #5 - Java Collections
 */
public class Main {

    //public static final String STRING = "test word words test 1 10 1";
    public static final String STRING = "lá na rua onde eu moro conheci uma vizinha separada do marido está morando sozinha além dela ser bonita é um poço de bondade vendo meu carro na chuva ofereceu sua garagem ela disse ninguém usa desde que ele me deixou dentro da minha garagem teias de aranha juntou põe teu carro aqui dentro se não vai enferrujar a garagem é usada mas teu carro vai gostar ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha só que o meu possante carro tem um bonito atrelado que eu uso pra vender cocos e ganhar mais um trocado a garagem é pequena o que é que eu faço agora o meu carro fica dentro os cocos ficam de fora a minha vizinha é boa da garagem vou cuidar na porta mato cresceu dei um jeito de cortar a bondade da vizinha é coisa de outro mundo quando não uso a da frente uso a garagem do fundo ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha ponho o carro tiro o carro à hora que eu quiser que garagem apertadinha que doçura de mulher tiro cedo e ponho à noite e às vezes à tardinha estava até mudando o óleo na garagem da vizinha";
    public static void main(String[] args) {

        WordHistogramComp wordHistogram = new WordHistogramComp(STRING);
        System.out.println("MAP has " + wordHistogram.size() + " distinct words");

        for( String word : wordHistogram ) {

            System.out.println(word + " " + wordHistogram.get(word));

        }

        System.out.println("--------------------");

        /*WordHistogramCompInheritance wordHist = new WordHistogramCompInheritance(STRING);
        System.out.println("MAP has " + wordHist.size() + " distinct words");
        for( String word : wordHist ) {
            System.out.println(word + " " + wordHist.get(word));
        }*/
    }
}
