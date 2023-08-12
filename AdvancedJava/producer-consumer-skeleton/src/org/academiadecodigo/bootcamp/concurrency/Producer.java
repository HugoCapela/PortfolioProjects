package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        while (elementNum > 0) {

            synchronized (queue) {
                queue.offer(elementNum);
                if (queue.getSize() == queue.getLimit()) {
                    System.out.println("Queue is full!");
                }
            }

            try {
                Thread.sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            elementNum--;
        }
    }

}
