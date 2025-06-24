package NewsFeed;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SocialNetwork sn = new SocialNetwork();

        sn.post("1");
        Thread.sleep(10);
        sn.post("1");
        Thread.sleep(10);
        sn.post("2");
        Thread.sleep(10);
        sn.post("2");
        Thread.sleep(10);
        sn.post("3");

        sn.followUser("1", "2"); // User 1 follows User 2
        sn.followUser("1", "3"); // User 1 follows User 3

        System.out.println("Feed for User 1:");
        for (Post post : sn.getPosts(5, "1")) {
            System.out.println(post);
        }

        sn.Unfollow("1", "2");
        System.out.println("\nAfter unfollowing User 2:");
        for (Post post : sn.getPosts(5, "1")) {
            System.out.println(post);
        }
    }
}
