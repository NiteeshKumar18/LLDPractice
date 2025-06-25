package NotificationsSystem;

import java.util.PriorityQueue;

public class NotificationsQueue {

    private PriorityQueue<Notification> queue;

    public NotificationsQueue() {
        queue = new PriorityQueue<>();
    }


    public synchronized void add(Notification notification) {
        queue.add(notification);
        notify();
    }

    public synchronized Notification remove() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
