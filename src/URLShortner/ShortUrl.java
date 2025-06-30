package URLShortner;

import java.time.Instant;

public class ShortUrl {

    private final String shortURL;
    private final String longURL;
    private final String createdBy;
    private final Instant createdDate;
    private final Instant expiryDate;
    private int hits;

    public ShortUrl(String shortURL, String longURL, String createdBy, Instant createdDate, Instant expiryDate) {
        this.shortURL = shortURL;
        this.longURL = longURL;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.expiryDate = expiryDate;
        this.hits = 0;
    }

    public boolean isExpired() {
        return Instant.now().isAfter(expiryDate);
    }

    public void incrementHits() {
        this.hits++;
    }


    public String getShortURL() {
        return shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public int getHits() {
        return hits;
    }

}
