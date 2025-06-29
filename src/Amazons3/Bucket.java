package Amazons3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bucket {

    private final int bucketId;
    private final int userId;
    private final String userEmailId;
    private final String bucketName;
    private Map<String, List<ObjectMetaData>> keyToMetaDataMap;

    public Bucket(int bucketId, int userId, String userEmailId, String bucketName) {
        this.bucketId = bucketId;
        this.userId = userId;
        this.userEmailId = userEmailId;
        this.bucketName = bucketName;
        keyToMetaDataMap = new LinkedHashMap<>();
    }


    public int getBucketId() {
        return bucketId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public String getBucketName() {
        return bucketName;
    }

    public Map<String, List<ObjectMetaData>> getKeyToMetaDataMap() {
        return keyToMetaDataMap;
    }



    // --- Setters ---
    // Only for non-final fields


}
