package Reddit;

public class User {

    private final int userId;
    private final String emailId;
    private final String name;

    public User(int userId, String emailId, String name) {
        this.userId = userId;
        this.emailId = emailId;
        this.name = name;
    }


    public int getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }
}
