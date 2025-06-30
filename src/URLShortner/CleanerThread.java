package URLShortner;

public class CleanerThread extends Thread {
    private final URLRepository repository;
    private boolean isRunning;

    public CleanerThread(URLRepository repository) {
        this.repository = repository;
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            for (String key : repository.getAll().keySet()) {
                ShortUrl shortUrl = repository.get(key);
                if (shortUrl.isExpired()) {
                    repository.delete(key);
                }
            }
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        isRunning = false;
        this.interrupt();
    }

}
