package LruCache;

public class Node {
    private final int key;
    private int value;
    private Node prev;
    private Node next;


    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


    public void updateValue(int value) {
        this.value = value;
    }

    public void updateNext(Node next) {
        this.next = next;
    }

    public void updatePrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public int getKey() {
        return this.key;
    }

}
