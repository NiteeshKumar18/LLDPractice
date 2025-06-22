package Threadpool;

import java.util.LinkedList;
import java.util.Queue;

public class TaskEnqueue {

    private final Queue<Runnable> queue = new LinkedList<>();
    private boolean stopped = false;

    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public synchronized Runnable dequeue() {
        while (queue.isEmpty() && !stopped) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }


    public synchronized void enqueue(Runnable task) {
        queue.add(task);
        notify();
    }

    public synchronized void stop() {
        stopped = true;
        notifyAll();
    }
}
