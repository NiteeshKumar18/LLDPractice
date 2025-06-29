package Amazons3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ObjectMetaData {

    private final int metaDatId;
    private final String key;
    private final long size;
    private final String contentType;
    private final String version;
    private List<String> chunkIds;
    private final Instant uploadedAt;

    public ObjectMetaData(int metaDatId, String key, long size, String contentType, String version) {
        this.metaDatId = metaDatId;
        this.key = key;
        this.size = size;
        this.contentType = contentType;
        this.version = version;
        this.uploadedAt = Instant.now();
        chunkIds = new ArrayList<>();
    }

    public int getMetaDatId() {
        return metaDatId;
    }

    public String getKey() {
        return key;
    }

    public long getSize() {
        return size;
    }

    public String getContentType() {
        return contentType;
    }

    public String getVersion() {
        return version;
    }

    public List<String> getChunkIds() {
        // Return an unmodifiable view to prevent external modification
        return chunkIds;
    }

    public Instant getUploadedAt() {
        return uploadedAt;
    }

    public void addChunkId(String chunkId) {
        chunkIds.add(chunkId);
    }

    public void addChunkIds(List<String> chunkId) {
        chunkIds.addAll(chunkIds);
    }

}
