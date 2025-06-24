package NewsFeed;

import java.util.*;
import java.util.stream.Collectors;

public class SocialNetwork {

    private Map<String, User> userIdToUserMap;
    private int postIdCounter = 0;


    public SocialNetwork() {
        this.userIdToUserMap = new HashMap<>();
    }

    public User createOrGetUser(String userId) {
        return userIdToUserMap.computeIfAbsent(userId, k -> new User(userId));
    }

    public void followUser(String followerId, String followeeId) {
        User follower = createOrGetUser(followerId);
        User followee = createOrGetUser(followeeId);
        follower.addFollower(followeeId);
    }

    public void Unfollow(String followerId, String followeeId) {
        User follower = createOrGetUser(followerId);
        User followee = createOrGetUser(followeeId);
        follower.removeFollower(followeeId);
    }

    public void post(String userId) {
        User user = createOrGetUser(userId);
        Post post = new Post(postIdCounter++, userId, System.currentTimeMillis());
        user.addPost(post);
    }

    public List<Post> getPosts(int count, String userId) {
        User user = createOrGetUser(userId);
        List<String> allFollowersIds = userIdToUserMap.get(userId).getFollowers();
        PriorityQueue<Post> maxHeap = new PriorityQueue<>();

        for (String followeeId : allFollowersIds) {
            List<Post> posts = createOrGetUser(followeeId).getPosts(10); // fetch last 10 from each
            maxHeap.addAll(posts);
        }

        List<Post> posts = new ArrayList<>();
        while (!maxHeap.isEmpty() && posts.size() < count) {
            Post post = maxHeap.poll();
            posts.add(post);
        }
        return posts;
    }
}
