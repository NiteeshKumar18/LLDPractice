package LruCache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CleanerThread extends Thread {
    private final Map<Integer, Node> map;
    private final DoubleLinkedList dll;
    private final ReentrantLock lock;
    private final long intervalMillis;

    public CleanerThread(Map<Integer, Node> map,
                         DoubleLinkedList dll,
                         ReentrantLock lock,
                         long intervalMillis) {
        this.map = map;
        this.dll = dll;
        this.lock = lock;
        this.intervalMillis = intervalMillis;
        setDaemon(true); // Optional: will not block JVM exit
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(intervalMillis);
                cleanExpiredEntries();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // good practice
                break;
            }
        }
    }

    private void cleanExpiredEntries() {
        lock.lock();
        try {
            Iterator<Map.Entry<Integer, Node>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Node> entry = it.next();
                if (entry.getValue().isExpired()) {
                    dll.removeNode(entry.getValue());
                    it.remove();
                }
            }
        } finally {
            lock.unlock();
        }
    }


    /*
    If we get 100X traffic what will we do??
    1) Using distributed cache, i.e we will have L1 cache which is local and L2 cache (DIstributed redis cache)
    2) L2 cache with consistent hashing (Only 1/N% keys needed to be moved)
    3) Keep an eye on eviction strategies, are we having too many cache misses hence cauing too many cache reloads
    4)monitoring and logging, tracking p99, p90 etc

     */
}
