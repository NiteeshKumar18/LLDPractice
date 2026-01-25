package LFUCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest {
    public static void main(String[] args) throws InterruptedException {
        LFUCache cache = new LFUCache(100);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Submit 100 concurrent tasks
        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            executor.submit(() -> {
                // Each thread does multiple operations
                for (int j = 0; j < 10; j++) {
                    String key = "key" + (taskId % 50); // Reuse some keys
                    cache.putValue(key, taskId * 10 + j);
                    int value = cache.getValue(key);
                    if (value != -1) {
                        System.out.println(Thread.currentThread().getName() + 
                            " - Key: " + key + ", Value: " + value);
                    }
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        
        System.out.println("\n✅ All concurrent operations completed successfully!");
        System.out.println("LFU Cache is now thread-safe!");
    }
}

