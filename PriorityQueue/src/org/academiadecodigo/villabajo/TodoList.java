package org.academiadecodigo.villabajo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<Item> pq;
    //private TodoListComparator tdlc = new TodoListComparator();

    public TodoList() {
        pq = new PriorityQueue<>();
    }

    public void add(Importance imp, int priority, String name) {
        pq.add(new Item(name, priority, imp));
    }

    public boolean isEmpty() {
        return pq.size() == 0;
        //return pq.isEmpty();
    }

    public Item remove(){
        return pq.poll();
    }

    public enum Importance {
        LOW,
        MEDIUM,
        HIGH;
    }

    /*public class TodoListComparator implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
            return o1.compareTo(o2);
        }
    }*/

    public class Item implements Comparable<Item>{
        private String name;
        private int priority;
        private Importance importance;

        public Item(String name, int priority, Importance imp) {
            this.name = name;
            this.priority = priority;
            this.importance = imp;
        }

        public int compareTo(Item o) {
            switch (this.importance) {
                case HIGH:
                    if (this.importance == o.importance) {
                        return this.priority - o.priority;
                        /*if (this.priority < o.priority) { // first implementation
                            return -1;
                        }
                        if (this.priority > o.priority) {
                            return 1;
                        }
                        return 0;*/
                    }
                    return -1;

                case MEDIUM:
                    if (this.importance == o.importance) {
                        return  this.priority - o.priority;
                        /*if (this.priority < o.priority) {
                            return -1;
                        }
                        if (this.priority > o.priority) {
                            return 1;
                        }
                        return 0;*/
                    }
                    if (o.importance == Importance.HIGH){
                        return 1;
                    }
                    return -1;

                case LOW:
                    if (this.importance == o.importance) {
                        return this.priority - o.priority;
                        /*if (this.priority < o.priority) {
                            return -1;
                        }
                        if (this.priority > o.priority) {
                            return 1;
                        }
                        return 0;*/
            }
                    return 1;
            }
            return -10; // just in case it never enters the switch, default return
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    ", importance=" + importance +
                    '}';
        }
    }

}
