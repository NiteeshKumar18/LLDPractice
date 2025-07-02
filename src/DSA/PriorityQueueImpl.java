package DSA;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueImpl {

    /*
       -> PriorityQueue is not thread-safe
       ->  The elements of the priority queue are ordered according to the natural ordering, and elements must implement Comparable, or by a Comparator provided at queue construction time, depending on which constructor is used.
       -> It provides O(log(n)) time for add and poll methods.
     */

    public final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    public final PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.comparing(Integer::intValue)); //when polls gives in ascending order
    public final PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed()); // when polls gives in descending order
    public final PriorityQueue<Integer> priorityQueue4 = new PriorityQueue<>(List.of(1,2,3,4));  //Creates priority queue with the given collection items

    public void add(Integer score) {
        priorityQueue2.add(score);
    }

    public void printQueueContents() {
        while (!priorityQueue2.isEmpty()) {
            System.out.println(priorityQueue2.poll());
        }
    }

}
