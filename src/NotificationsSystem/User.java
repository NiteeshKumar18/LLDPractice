package NotificationsSystem;

import java.util.concurrent.ThreadLocalRandom;

public class User {

    private final int id;
    private final String name;
    private final String email;

    public User( String name, String email) {
        this.id = ThreadLocalRandom.current().nextInt();
        this.name = name;
        this.email = email;
    }

    public void receiveNotification(Notification notification) {
        System.out.println(notification);
    }
}
