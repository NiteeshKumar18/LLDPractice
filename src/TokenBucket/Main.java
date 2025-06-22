package TokenBucket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(1, 1); // 5 tokens max, 2 tokens/sec

        for (int i = 0; i < 10; i++) {
            boolean allowed = bucket.allowRequest();
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Rejected"));
            Thread.sleep(300); // simulate request every 300ms
        }
    }
}
