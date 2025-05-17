package InventoryManagementSystem.OrderManagement;

import InventoryManagementSystem.User.User;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private List<Order> orderList = new ArrayList<>();

    public Order processOrder(User user) {
        Order order1 = new Order(1234, user, "nandigama", "1234", "invoice", new Payment(), "1234");
        this.orderList.add(order1);
        return order1;
    }
}
