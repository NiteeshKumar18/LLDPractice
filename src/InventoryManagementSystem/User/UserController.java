package InventoryManagementSystem.User;

import InventoryManagementSystem.User.User;
import InventoryManagementSystem.WareHouseManager.WareHouse;
import InventoryManagementSystem.WareHouseSelectionStrategy.WareHouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        this.userList.add(user);
    }

    public User getUser(String id) {
        return userList.get(0);
    }


}
