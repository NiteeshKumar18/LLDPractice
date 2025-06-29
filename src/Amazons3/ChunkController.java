package Amazons3;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChunkController {
    Map<String, Chunk> chunks;

    public ChunkController() {
        chunks = new HashMap<String, Chunk>();
    }

    public String storeChunk(byte[] data) {
        String id = UUID.randomUUID().toString();
        chunks.put(id, new Chunk(id, data));
        return id;
    }

    public byte[] getChunk(String id) {
        return chunks.get(id).getData();
    }

    public void deleteChunk(String id) {
        chunks.remove(id);
    }

}
