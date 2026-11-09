package LFUCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class PerformanceComparison {
    
    private static final int CACHE_CAPACITY = 1000;
    private static final int NUM_THREADS = 20;
    private static final int OPERATIONS_PER_THREAD = 10000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== LFU Cache Performance Comparison ===\n");
        System.out.println("Configuration:");
        System.out.println("  Cache Capacity: " + CACHE_CAPACITY);
        System.out.println("  Number of Threads: " + NUM_THREADS);
        System.out.println("  Operations per Thread: " + OPERATIONS_PER_THREAD);
        System.out.println("  Total Operations: " + (NUM_THREADS * OPERATIONS_PER_THREAD));
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Single Lock LFU Cache
        System.out.println("Testing Single Lock LFU Cache...");
        long singleLockTime = testSingleLockCache();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test Segmented LFU Cache
        System.out.println("Testing Segmented LFU Cache...");
        long segmentedTime = testSegmentedCache();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Print comparison
        printComparison(singleLockTime, segmentedTime);
    }

    private static long testSingleLockCache() throws InterruptedException {
        LFUCache cache = new LFUCache(CACHE_CAPACITY);
        AtomicLong operations = new AtomicLong(0);
        
        long startTime = System.currentTimeMillis();
        
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    String key = "key" + ((threadId * OPERATIONS_PER_THREAD + j) % 500);
                    
                    // Mix of reads and writes (70% reads, 30% writes)
                    if (j % 10 < 7) {
                        cache.getValue(key);
                    } else {
                        cache.putValue(key, threadId * 1000 + j);
                    }
                    operations.incrementAndGet();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        System.out.println("✅ Completed in: " + duration + " ms");
        System.out.println("   Operations: " + operations.get());
        System.out.println("   Throughput: " + (operations.get() * 1000 / duration) + " ops/sec");
        
        return duration;
    }

    private static long testSegmentedCache() throws InterruptedException {
        SegmentedLFUCache cache = new SegmentedLFUCache(CACHE_CAPACITY);
        AtomicLong operations = new AtomicLong(0);
        
        long startTime = System.currentTimeMillis();
        
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    String key = "key" + ((threadId * OPERATIONS_PER_THREAD + j) % 500);
                    
                    // Mix of reads and writes (70% reads, 30% writes)
                    if (j % 10 < 7) {
                        cache.getValue(key);
                    } else {
                        cache.putValue(key, threadId * 1000 + j);
                    }
                    operations.incrementAndGet();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        System.out.println("✅ Completed in: " + duration + " ms");
        System.out.println("   Operations: " + operations.get());
        System.out.println("   Throughput: " + (operations.get() * 1000 / duration) + " ops/sec");
        
        cache.printStats();
        
        return duration;
    }

    private static void printComparison(long singleLockTime, long segmentedTime) {
        System.out.println("📊 PERFORMANCE COMPARISON");
        System.out.println("=".repeat(50));
        System.out.println(String.format("%-25s: %6d ms", "Single Lock LFU", singleLockTime));
        System.out.println(String.format("%-25s: %6d ms", "Segmented LFU", segmentedTime));
        System.out.println("-".repeat(50));
        
        double improvement = ((double)(singleLockTime - segmentedTime) / singleLockTime) * 100;
        double speedup = (double)singleLockTime / segmentedTime;
        
        if (segmentedTime < singleLockTime) {
            System.out.println(String.format("🚀 Segmented is %.1f%% FASTER", improvement));
            System.out.println(String.format("   Speedup: %.2fx", speedup));
        } else {
            System.out.println(String.format("⚠️  Single Lock is %.1f%% faster", -improvement));
            System.out.println(String.format("   (Segmented overhead: %.2fx slower)", 1/speedup));
        }
        
        System.out.println("\n💡 Key Takeaway:");
        System.out.println("   Segmented locking shines with high concurrency!");
        System.out.println("   More threads = better segmented performance");
    }
}

