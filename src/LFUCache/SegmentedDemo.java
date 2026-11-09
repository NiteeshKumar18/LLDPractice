package LFUCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SegmentedDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Segmented LFU Cache Demo ===\n");
        
        // Create cache with capacity 100
        SegmentedLFUCache cache = new SegmentedLFUCache(100);
        
        System.out.println("1. Basic Operations:");
        cache.putValue("user:1", 100);
        cache.putValue("user:2", 200);
        cache.putValue("user:3", 300);
        
        System.out.println("   get('user:1') = " + cache.getValue("user:1"));
        System.out.println("   get('user:2') = " + cache.getValue("user:2"));
        System.out.println("   get('user:3') = " + cache.getValue("user:3"));
        System.out.println("   get('user:999') = " + cache.getValue("user:999")); // -1
        
        System.out.println("\n2. Concurrent Access Test:");
        System.out.println("   Launching 10 threads to access cache concurrently...\n");
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 5; j++) {
                    String key = "thread" + threadId + ":key" + j;
                    cache.putValue(key, threadId * 100 + j);
                    int value = cache.getValue(key);
                    System.out.println("   " + Thread.currentThread().getName() + 
                        " -> " + key + " = " + value);
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("\n3. Cache Statistics:");
        cache.printStats();
        
        System.out.println("\n✅ Demo completed!");
        System.out.println("\n💡 Key Benefits of Segmented LFU:");
        System.out.println("   • Multiple threads can access different segments simultaneously");
        System.out.println("   • Reduces lock contention compared to single-lock version");
        System.out.println("   • Scales better with increasing number of threads");
        System.out.println("   • Each segment has its own lock (16 segments = 16x potential concurrency)");
    }
}

