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
}
