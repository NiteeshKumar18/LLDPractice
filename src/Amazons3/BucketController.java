package Amazons3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BucketController {

    private final Map<String, Bucket> buckets;

    public BucketController(Map<String, Bucket> buckets) {
        this.buckets = buckets;
    }

    public Bucket createBucket(String bucketName) {
        Bucket bucket = buckets.get(bucketName);
        if (bucket == null) {
            Bucket bucket1 = new Bucket(ThreadLocalRandom.current().nextInt(), 1234, "abc@gmail.com", bucketName);
            buckets.put(bucketName, bucket1);
            return bucket1;
        }
        return bucket;
    }

    public void putObjectMetaData(String bucket, ObjectMetaData objectMetaData) {
        Bucket bucket1 = buckets.get(bucket);
        bucket1.getKeyToMetaDataMap().computeIfAbsent(objectMetaData.getKey(), k -> new ArrayList<>()).add(objectMetaData);
    }

    public List<ObjectMetaData> getObjectVersions(String bucket, String key) {
        return buckets.get(bucket).getKeyToMetaDataMap().get(key);
    }

    public void deleteObject(String bucket, String key) {
        buckets.get(bucket).getKeyToMetaDataMap().remove(key);
    }

    public Bucket getBucket(String key) {
        Bucket bucket = buckets.getOrDefault(key, null);
        return bucket;
    }
}
