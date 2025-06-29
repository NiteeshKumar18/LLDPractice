package Amazons3;

public class Chunk {
    private final String chunkId;
    private final byte[] data;

    public Chunk(String chunkId, byte[] data) {
        this.chunkId = chunkId;
        this.data = data;
    }

    public String getChunkId() {
        return chunkId;
    }

    public byte[] getData() {
        return data;
    }
}
