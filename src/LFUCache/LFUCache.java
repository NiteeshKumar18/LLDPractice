package LFUCache;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class LFUCache {

    private final int capacity;

    private Map<String, Node> keyToNode;
    private Map<Integer, LinkedHashSet<Node>> freqMap;
    private int minFrequency;
    private final ReentrantLock lock;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        freqMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }


    public int getValue(String key) {
        lock.lock();
        try {
            if (!keyToNode.containsKey(key)) {
                return -1;
            }
            Node node = keyToNode.get(key);
            updateFreq(node);
            return node.getValue();
        } finally {
            lock.unlock();
        }
    }


    public void putValue(String key, int value) {
        lock.lock();
        try {
            if (keyToNode.containsKey(key)) {
                Node node = keyToNode.get(key);
                node.setValue(value);
                updateFreq(node);
            } else {
                if (keyToNode.size() >= capacity) {
                    evictLFU();
                }
                Node node = new Node(key, value);
                keyToNode.put(key, node);
                freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
                minFrequency = 1;
            }
        } finally {
            lock.unlock();
        }
    }

    public void evictLFU() {
        LinkedHashSet<Node> set = freqMap.get(minFrequency);
        Iterator<Node> it = set.iterator();
        Node node = it.next();
        set.remove(node);

        if (set.size() == 0) {
            freqMap.remove(minFrequency);
        }
        keyToNode.remove(node.getKey());
    }

    public void updateFreq(Node node) {
        LinkedHashSet<Node> set = freqMap.get(node.getFrequency());
        if (set != null) {
            set.remove(node);

            // set.remove(node);
            if (set.isEmpty()) {
                freqMap.remove(node.getFrequency());
                if (node.getFrequency() == minFrequency) {
                    minFrequency++;
                }
            }
        }

        node.setFrequency(node.getFrequency() + 1);
        freqMap.computeIfAbsent(node.getFrequency(), k -> new LinkedHashSet<>()).add(node);
    }
}
