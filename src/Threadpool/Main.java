package Threadpool;

import Threadpool.ThreadPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            pool.submitTask(() -> {
                System.out.println("Running task " + taskId + " in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            });
        }

        Thread.sleep(5000);
        pool.shutdown();
        while (!pool.isTerminated()) {
            Thread.sleep(100); // wait for all threads to finish
        }

        System.out.println("All tasks completed. Pool terminated.");
    }
}
