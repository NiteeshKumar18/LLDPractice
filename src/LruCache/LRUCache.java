package LruCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {

    private final int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private DoubleLinkedList doubleLinkedList;
    private final ReentrantLock lock;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        doubleLinkedList = new DoubleLinkedList(capacity);
        this.lock = new ReentrantLock();
    }


    public int get(String key) {
        try {
            lock.lock();
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            doubleLinkedList.moveToFront(node);
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
                doubleLinkedList.moveToFront(node);
            } else {
                if (map.size() >= capacity) {
                    Node node = doubleLinkedList.removeLast();
                    if (node != null) {
                        map.remove(node.getValue());
                    }
                }
                Node node = new Node(key, value);
                map.put(key, node);
                doubleLinkedList.addFirst(node);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
