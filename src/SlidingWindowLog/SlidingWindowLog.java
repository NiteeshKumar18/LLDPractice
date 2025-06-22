package SlidingWindowLog;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowLog {

    private final int maxRequests;
    private final long windowTimeInMillis;

    private Deque<Long> requestTimeStamps;


    public SlidingWindowLog(int maxRequests, int windowTimeInSecs) {
        this.maxRequests = maxRequests;
        this.windowTimeInMillis = windowTimeInSecs * 1000;
        requestTimeStamps = new LinkedList<>();
    }


    public synchronized boolean addRequest(long timeInMillis) {
        long now = System.currentTimeMillis();


        while (!requestTimeStamps.isEmpty() && now - windowTimeInMillis >= requestTimeStamps.peekLast()) {
            requestTimeStamps.removeFirst();
        }

        if (requestTimeStamps.size() < maxRequests) {
            requestTimeStamps.addLast(now);
            return true;
        }
        return false;
    }
}
