package DSA;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeueImpl {
    /*
         Queue Interface <- Dequeue implements Linkedlist, arrayDequeue
      -> Dequeue is nth but double ended queue, we can add and remove elements from both ends of the queue
      -> Thread-Safe Alternatives: Use ConcurrentLinkedDeque
      -> Since Deque is an interface, objects cannot be created of the type deque. We always need a class that extends this list in order to create an object i.e linkedList
      -> Iterator also can be created from both sides, dq.iterator() and dq.descendingIterator(); (from back side)
      ->
     */

    public Deque<Integer> queue = new LinkedList<>();


    public void addElementFirst(int value) {
        queue.add(value);
    }

    public void addElementLast(int value) {
        queue.add(value);
    }

    public void removeElementFist() {
        queue.removeFirst();
    }

    public void removeLast() {
        queue.removeLast();
    }
}
