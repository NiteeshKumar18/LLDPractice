package Amazons3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ObjectStoreService {

    private BucketController bucketController;
    private ChunkController chunkController;


    public ObjectStoreService(BucketController bucketController, ChunkController chunkController) {
        this.bucketController = bucketController;
        this.chunkController = chunkController;
    }


    public void uploadObject(String bucketName, String objectName, byte[] objectData) {
        Bucket bucket = bucketController.getBucket(bucketName);
        if (bucket == null) {
            bucket = bucketController.createBucket(bucketName);
        }

        int chunkSIze = 5 * 1024 * 1024;
        List<String> chunkIds = new ArrayList<String>(chunkSIze);
        for (int i = 0; i < objectData.length; i += chunkSIze) {
            int end = Math.min(i + chunkSIze, objectData.length);
            byte[] chunk = Arrays.copyOfRange(objectData, i, end);
            String chunkId = chunkController.storeChunk(chunk);
            chunkIds.add(chunkId);
        }


        ObjectMetaData objectMetaData = new ObjectMetaData(ThreadLocalRandom.current().nextInt(), objectName, objectData.length, "bytes", "1");
        objectMetaData.addChunkIds(chunkIds);
        bucketController.putObjectMetaData(bucketName, objectMetaData);

    }

    public byte[] download(String bucket, String key) {
        Bucket bucket1 = bucketController.getBucket(bucket);
        if (bucket1 == null) {
            return null;
        }
        List<ObjectMetaData> objectMetaDataList = bucketController.getObjectVersions(bucket, key);
        if (objectMetaDataList.isEmpty()) {
            return null;
        }

        ObjectMetaData objectMetaData = objectMetaDataList.get(objectMetaDataList.size() - 1); //versioning
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (String chunkId : objectMetaData.getChunkIds()) {
            try {
                out.write(chunkController.getChunk(chunkId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out.toByteArray();

    }

}
