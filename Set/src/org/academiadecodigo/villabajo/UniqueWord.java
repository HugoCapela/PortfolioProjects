package org.academiadecodigo.villabajo;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueWord implements Iterable<String>{

    //private String string;
    private String[] arrStr;
    private HashSet<String> hs;
    public UniqueWord(String s) {
        //this.string = s;
        this.arrStr = s.split(" ");

        hs = new HashSet<>();

        /*for( int i = 0; i < arrStr.length; i++ ) {
            hs.add(arrStr[i]);
        }*/

        for( String str : arrStr ) {
            hs.add(str);
        }
        //add();
    }
    /*private void add() {
        for( int i = 0; i < arrStr.length; i++ ) {
            hs.add(arrStr[i]);
        }
    }*/
    @Override
    public Iterator iterator() {
        return hs.iterator();
    }
}
