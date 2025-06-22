package Threadpool;

public class PoolWorker extends Thread{
    private final ThreadPool pool;
    private final TaskEnqueue queue;


    public PoolWorker(ThreadPool pool, TaskEnqueue queue) {
        this.pool = pool;
        this.queue = queue;
    }


    @Override
    public void run() {
        while (!pool.isStopped()) {
            Runnable task = queue.dequeue();
            if (task != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    System.out.println("Error running task: " + e.getMessage());
                }
            }
        }
    }
}
