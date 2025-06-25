package NotificationsSystem;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Notification implements Comparable<Notification> {

    public final int id;
    private User user;
    private final String content;
    private int priority;
    private NotificationsType type;


    public Notification(int id, User user, String content, int priority, NotificationsType type) {
        this.id = ThreadLocalRandom.current().nextInt(0, 100);
        this.user = user;
        this.content = content;
        this.priority = priority;
        this.type = type;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }

    // --- Setters ---
    // Only for non-final fields

    public void setUser(User user) {
        this.user = user;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public NotificationsType getType() {
        return type;
    }

    @Override
    public int compareTo(Notification o) {
        return Integer.compare(o.priority, this.priority);
    }
}
