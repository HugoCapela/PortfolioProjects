package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private final int limit;
    private final Queue<T> queue;
    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {

        this.limit = limit;
        queue = new LinkedList<>();

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public void offer(T data)  {

        synchronized (this) {
            while (queue.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Added element " + data);
            notifyAll();
            queue.add(data);
        }


    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public T poll() {

        synchronized (this) {
            while (queue.size() <= 0) {
                //System.out.println("Queue is empty");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Removed element " + queue.element());
            notifyAll();
            return queue.remove();
        }

    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {
        synchronized (this) {
            return queue.size();
        }
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }

}
