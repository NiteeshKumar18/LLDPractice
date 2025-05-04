package CarRental;

public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    public User(String id, String name, String email, String phoneNumber, Location location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
}
