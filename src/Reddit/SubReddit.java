package Reddit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SubReddit {

    private final int id;
    private final String userId;
    private final Instant createdAt;
    private final List<String> postIds;

    public SubReddit(int id, String userId, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.postIds = new ArrayList<>();
    }

    public void addPost(String postId) {
        this.postIds.add(postId);
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public List<String> getPostIds() {
        // Return the unmodifiable view of the list
        return postIds;
    }
}
