package SlidingWindowLog;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLog limiter = new SlidingWindowLog(5, 10); // 5 requests per 10 seconds

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.addRequest(System.currentTimeMillis());
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Rejected"));
            Thread.sleep(1000); // 1 request per second
        }
    }
}
