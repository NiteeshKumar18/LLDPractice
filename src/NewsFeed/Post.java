package NewsFeed;

public class Post implements Comparable<Post> {

    private final int postId;
    private final String userId;
    private final long timestamp;

    public Post(int postId, String userId, long timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Post o) {
        return Long.compare(o.timestamp, this.timestamp);
    }
}
