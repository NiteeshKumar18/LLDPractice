package DSA;

import NewsFeed.Post;
import NewsFeed.SocialNetwork;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       PriorityQueueImpl priorityQueue = new PriorityQueueImpl();
       priorityQueue.add(10);
       priorityQueue.add(1);
       priorityQueue.add(-2);

       priorityQueue.printQueueContents();
    }
}
