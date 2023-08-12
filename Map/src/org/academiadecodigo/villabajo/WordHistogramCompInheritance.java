package org.academiadecodigo.villabajo;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramCompInheritance extends HashMap<String, Integer> implements Iterable<String> {

    public WordHistogramCompInheritance(String s) {
        super();
        for( String str : s.split(" ") ) {
            //this.put(str, 0);
            this.put(str, containsKey(str) ? get(str) +1 : 1);
        }

        /*for( String str : s.split(" ") ) {
            if( this.containsKey(str) ) {
                this.replace(str, (this.get(str) + 1) );
            }
        }*/
    }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }
}
