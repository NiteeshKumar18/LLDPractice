package LFUCache;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class SegmentedLFUCache {

    private static final int NUM_SEGMENTS = 16;
    private final Segment[] segments;
    private final int capacity;

    public SegmentedLFUCache(int capacity) {
        this.capacity = capacity;
        this.segments = new Segment[NUM_SEGMENTS];
        int segmentCapacity = Math.max(1, capacity / NUM_SEGMENTS);
        
        for (int i = 0; i < NUM_SEGMENTS; i++) {
            segments[i] = new Segment(segmentCapacity);
        }
    }

    private Segment getSegment(String key) {
        int hash = key.hashCode();
        return segments[Math.abs(hash) % NUM_SEGMENTS];
    }

    public int getValue(String key) {
        Segment segment = getSegment(key);
        return segment.getValue(key);
    }

    public void putValue(String key, int value) {
        Segment segment = getSegment(key);
        segment.putValue(key, value);
    }

    // Inner class representing a cache segment
    static class Segment {
        private final int capacity;
        private final ReentrantLock lock;
        private Map<String, Node> keyToNode;
        private Map<Integer, LinkedHashSet<Node>> freqMap;
        private int minFrequency;

        public Segment(int capacity) {
            this.capacity = capacity;
            this.lock = new ReentrantLock();
            this.keyToNode = new HashMap<>();
            this.freqMap = new HashMap<>();
            this.minFrequency = 0;
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

        private void evictLFU() {
            LinkedHashSet<Node> set = freqMap.get(minFrequency);
            if (set == null || set.isEmpty()) {
                return;
            }
            Iterator<Node> it = set.iterator();
            Node node = it.next();
            set.remove(node);

            if (set.isEmpty()) {
                freqMap.remove(minFrequency);
            }
            keyToNode.remove(node.getKey());
        }

        private void updateFreq(Node node) {
            LinkedHashSet<Node> set = freqMap.get(node.getFrequency());
            if (set != null) {
                set.remove(node);

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

        public int size() {
            lock.lock();
            try {
                return keyToNode.size();
            } finally {
                lock.unlock();
            }
        }
    }

    public int size() {
        int total = 0;
        for (Segment segment : segments) {
            total += segment.size();
        }
        return total;
    }

    public void printStats() {
        System.out.println("\n=== Segmented LFU Cache Stats ===");
        System.out.println("Total Segments: " + NUM_SEGMENTS);
        System.out.println("Total Capacity: " + capacity);
        System.out.println("Current Size: " + size());
        System.out.println("\nSegment Distribution:");
        for (int i = 0; i < NUM_SEGMENTS; i++) {
            System.out.println("  Segment " + i + ": " + segments[i].size() + " items");
        }
    }
}

