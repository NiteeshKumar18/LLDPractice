package URLShortner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        URLRepository urlRepository = new URLRepository();
        URLShortnerService urlShortnerService = new URLShortnerService(urlRepository);
        CleanerThread cleanerThread = new CleanerThread(urlRepository);
        cleanerThread.start();

        String code1 = urlShortnerService.shortenUrl("https://example.com", null, 10);
        System.out.println(code1);

        Thread.sleep(11_000);
        System.out.println(urlShortnerService.resolveShortUrl(code1));
    }
}
