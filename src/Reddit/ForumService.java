package Reddit;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ForumService {

    private final Map<Integer, User> userMap;
    private final Map<String, SubReddit> subRedditMap;
    private final Map<String, Post> postMap;


    public ForumService() {
        userMap = new HashMap<>();
        subRedditMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    public void addUser() {
        User user = new User(ThreadLocalRandom.current().nextInt(), "niteesh@strings.ai", "Niteesh");
        userMap.put(user.getUserId(), user);
    }

    public void addSubreddit(String name, int userId) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        SubReddit subReddit = new SubReddit(ThreadLocalRandom.current().nextInt(), String.valueOf(userMap.get(0).getUserId()), Instant.now());
        subRedditMap.put(subReddit.getUserId(), subReddit);
    }

    public void createPost(int subredditId, int userId) {
        SubReddit subReddit = subRedditMap.get(subredditId);
        if (subReddit == null) {
            throw new RuntimeException("Subreddit not found");
        }
        User user = userMap.get(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Post post = new Post(String.valueOf(ThreadLocalRandom.current().nextInt()), "hello123", "may i know you", String.valueOf(userId));
        postMap.put(post.getUserId(), post);
        subReddit.addPost(post.getId());
    }

    public List<Post> getPostsBySubredditSortedByTime(int subredditId) {
        SubReddit subReddit = subRedditMap.get(subredditId);
        if (subReddit == null) {
            throw new RuntimeException("Subreddit not found");
        }

        List<Post> posts = new ArrayList<>();

        for (String posId : subReddit.getPostIds()) {
            if (postMap.containsKey(posId)) {
                posts.add(postMap.get(posId));
            }
        }

        return posts.stream().sorted(Comparator.comparing(Post::getCreatedAt).reversed()).collect(Collectors.toList());
    }


    public List<Post> getPostsByVotes(int subredditId) {
        SubReddit subReddit = subRedditMap.get(subredditId);
        if (subReddit == null) {
            throw new RuntimeException("Subreddit not found");
        }
        List<Post> posts = new ArrayList<>();
        for (String posId : subReddit.getPostIds()) {
            if (postMap.containsKey(posId)) {
                posts.add(postMap.get(posId));
            }
        }
        return posts.stream().sorted(Comparator.comparing(Post::getScore).reversed()).collect(Collectors.toList());
    }


}
