package LFUCache;

public class Main {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.putValue("1", 1);
        cache.putValue("2", 2);
        System.out.println(cache.getValue("1")); // returns 1
        cache.putValue("3", 3); // evicts key 2
        System.out.println(cache.getValue("2")); // returns -1
        System.out.println(cache.getValue("3")); // returns 3
        cache.putValue("4", 4); // evicts key 1
        System.out.println(cache.getValue("1")); // returns -1
        System.out.println(cache.getValue("3")); // returns 3
        System.out.println(cache.getValue("4")); // returns 4
    }
}
