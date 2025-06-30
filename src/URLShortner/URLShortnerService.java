package URLShortner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class URLShortnerService {

    private URLRepository repository;

    private final int codeLength = 6;
    private final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public URLShortnerService(URLRepository repository) {
        this.repository = repository;
    }

    public String generateCode() {
        String code = "";

        for (int i = 0; i < codeLength; i++) {
            code = code + BASE62.charAt(ThreadLocalRandom.current().nextInt(0, BASE62.length()));
        }
        return code;
    }

    public String shortenUrl(String longURL, String customAlias, int timeToLiveSeconds) {
        String code = customAlias != null ? customAlias : generateCode();
        Instant ttl = timeToLiveSeconds > 0 ? Instant.now().plus(timeToLiveSeconds, ChronoUnit.SECONDS) : null;

        ShortUrl shortUrl = new ShortUrl(code, longURL, "niteesh@gmail.com", Instant.now(), ttl);
        repository.save(shortUrl);
        return code;
    }

    public String resolveShortUrl(String code) {
        ShortUrl shortUrl = repository.get(code);
        if (shortUrl == null || shortUrl.isExpired()) {
            return null;
        }

        shortUrl.incrementHits();
        return shortUrl.getLongURL();
    }
}
