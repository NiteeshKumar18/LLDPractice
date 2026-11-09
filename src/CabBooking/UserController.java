package CabBooking;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> userMap;

    public UserController() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }
}
