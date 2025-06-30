package URLShortner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class URLRepository {

    private final ConcurrentHashMap<String, ShortUrl> shortUrls = new ConcurrentHashMap<>();

    public void save(ShortUrl shortUrl) {
        shortUrls.put(shortUrl.getShortURL(), shortUrl);
    }


    public ShortUrl get(String code) {
        return shortUrls.get(code);
    }

    public void delete(String code) {
        shortUrls.remove(code);
    }

    public ConcurrentHashMap<String, ShortUrl> getAll() {
        return shortUrls;
    }
}
