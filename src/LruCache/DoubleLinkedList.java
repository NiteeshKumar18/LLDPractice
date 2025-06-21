package LruCache;

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int size;
    private final int capacity;

    public DoubleLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void addNode(int key, int value) {
        Node node = new Node(key, value, tail, null);
        if (tail != null) {
            tail.updateNext(node);
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    public void addFirst(int key, int value) {
        Node node = new Node(key, value, null, head);
        if (head != null) {
            head.updatePrev(node);
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    public void addFirst(Node node) {
        node.updatePrev(null);
        node.updateNext(head);
        if (head != null) {
            head.updatePrev(node);
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    public void removeNode(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();

        if (prev != null) {
            prev.updateNext(next);
        } else {
            head = next;
        }

        if (next != null) {
            next.updatePrev(prev);
        } else {
            tail = prev;
        }

        node.updatePrev(null);
        node.updateNext(null);
        size--;
    }

    public void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    public Node removeLast() {
        if (tail == null) return null;
        Node last = tail;
        removeNode(last);
        return last;
    }

    public int getSize() {
        return size;
    }
}
