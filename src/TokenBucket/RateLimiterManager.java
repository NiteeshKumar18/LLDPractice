package TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterManager {
    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public void registerUser(String userId, int capacity, double ratePerSecond) {
        buckets.put(userId, new TokenBucket(capacity, ratePerSecond));
    }

    public boolean allowRequest(String userId) {
        TokenBucket bucket = buckets.get(userId);
        return bucket != null && bucket.allowRequest();
    }
}
