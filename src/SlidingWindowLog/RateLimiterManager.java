package SlidingWindowLog;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterManager {
    private Map<String, SlidingWindowLog> slidingWindowLogMap = new ConcurrentHashMap<String, SlidingWindowLog>();


    public synchronized void registerUser(String userId) {
        slidingWindowLogMap.put(userId, new SlidingWindowLog(5, 10));
    }


    public synchronized boolean allowRequest(String userId) {
        SlidingWindowLog log = slidingWindowLogMap.getOrDefault(userId, new SlidingWindowLog(5, 10));
        return log.addRequest(System.currentTimeMillis());
    }
}
