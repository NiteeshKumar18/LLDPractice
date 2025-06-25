package MeetingRoomBookingService;

import java.util.concurrent.ThreadLocalRandom;

public class User {

    private String name;
    private String emailId;
    private int userId;

    public User(String name, String emailId, String userid) {
        this.name = name;
        this.emailId = emailId;
        this.userId = ThreadLocalRandom.current().nextInt(0, 100);
    }

    // --- Getters ---

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getUserId() {
        return userId;
    }

    // --- Setters ---

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
