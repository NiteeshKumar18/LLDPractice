package LruCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {

    private final int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private DoubleLinkedList doubleLinkedList;
    private final ReentrantLock lock;
    private final AtomicInteger hits = new AtomicInteger(0);
    private final AtomicInteger misses = new AtomicInteger(0);

    private final long cleanerIntervalMillis = 5000; // Clean every 5 seconds


    public LRUCache(int capacity) {
        this.capacity = capacity;
        doubleLinkedList = new DoubleLinkedList(capacity);
        this.lock = new ReentrantLock();
        CleanerThread cleanerThread = new CleanerThread(map, doubleLinkedList, lock, cleanerIntervalMillis);
        cleanerThread.start();
    }


    public int get(String key) {
        try {
            lock.lock();
            if (!map.containsKey(key)) {
                misses.incrementAndGet();
                return -1;
            }
            Node node = map.get(key);
            doubleLinkedList.moveToFront(node);
            hits.incrementAndGet();
            return node.getValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        try {
            lock.lock();
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.updateValue(value);
                hits.incrementAndGet();
                doubleLinkedList.moveToFront(node);
            } else {
                if (map.size() >= capacity) {
                    Node node = doubleLinkedList.removeLast();
                    if (node != null) {
                        map.remove(node.getValue());
                    }
                }
                long expiryTime = System.currentTimeMillis() + cleanerIntervalMillis;
                Node node = new Node(key, value, expiryTime);
                map.put(key, node);
                doubleLinkedList.addFirst(node);
                misses.incrementAndGet();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
