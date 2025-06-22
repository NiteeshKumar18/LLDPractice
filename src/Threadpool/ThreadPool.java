package Threadpool;

import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private boolean isStopped = false;
    private TaskEnqueue taskEnqueue;
    private PoolWorker[] workers;
    private int MAX_SIZE = 10;


    public ThreadPool(int size) {
        this.taskEnqueue = new TaskEnqueue();
        workers = new PoolWorker[size];

        for (int i = 0; i < size; i++) {
            this.workers[i] = new PoolWorker(this, this.taskEnqueue);
            this.workers[i].start();
        }
    }

    public synchronized boolean enqueueWithTimeout(Runnable task, long timeoutMillis) throws InterruptedException {
        long start = System.currentTimeMillis();
        while (taskEnqueue.getQueueSize() >= MAX_SIZE && !isStopped) {
            long remaining = timeoutMillis - (System.currentTimeMillis() - start);
            if (remaining <= 0) return false;
            wait(remaining);
        }
        taskEnqueue.enqueue(task);
        notify();
        return true;
    }


    public void submitTask(Runnable task) {
        taskEnqueue.enqueue(task);
    }

    public void shutdown() {
        this.isStopped = true;
        taskEnqueue.stop();
    }

    public boolean isStopped() {
        return isStopped;
    }

    public void setIsStopped() {
        this.isStopped = true;
    }

    public boolean isTerminated() {
        for (PoolWorker worker : workers) {
            if (worker.isAlive()) return false;
        }
        return true;
    }
}
