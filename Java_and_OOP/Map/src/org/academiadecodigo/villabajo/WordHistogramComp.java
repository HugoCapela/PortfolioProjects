package org.academiadecodigo.villabajo;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp implements Iterable<String> {

    private HashMap<String, Integer> word = new HashMap<>();

    public WordHistogramComp(String s) {

        for( String str : s.split(" ")) {
            //word.put(str, 0);
            word.put(str, word.containsKey(str) ? word.get(str)+1 : 1);
        }

        /*for( String str : s.split(" ") ) {
            if( word.containsKey(str) ) {
                Integer i = get(str);
                i++;
                word.replace(str,i);
            }
        }*/
    }

    public int size() {
        return word.size();
    }

    public Integer get(String key) {
        return word.get(key);
    }

    @Override
    public Iterator<String> iterator() {
        return word.keySet().iterator();
    }
}
