package Splitwise.User;

import Splitwise.User.User;

import java.util.List;

public class UserController {

    private List<User> allUsers;


    public void addUser(User user) {
        this.allUsers.add(user);
    }

    public List<User> getAllUsers() {
        return this.allUsers;
    }
}
