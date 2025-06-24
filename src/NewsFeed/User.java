package NewsFeed;

import java.util.LinkedList;
import java.util.List;

public class User {

    private final String id;
    private final List<String> followers;

    private final LinkedList<Post> posts;

    public User(String id) {
        this.id = id;
        this.followers = new LinkedList<>();
        this.posts = new LinkedList<>();
        addFollower(id);
    }


    public void addFollower(String follower) {
        followers.add(follower);
    }

    public void removeFollower(String follower) {
        followers.remove(follower);
    }

    public void addPost(Post post) {
        posts.addFirst(post);
    }

    public List<Post> getPosts(int count) {
        return posts.subList(0, Math.min(count, posts.size()));
    }

    public List<String> getFollowers() {
        return followers;
    }
}
