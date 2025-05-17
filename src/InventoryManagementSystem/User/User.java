package InventoryManagementSystem.User;

import InventoryManagementSystem.OrderManagement.Cart;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;

    private String emailId;

    private String address;

    private Cart cart;

    private List<String> orderIds = new ArrayList<>();


    public User(String id, String name, String emailId, String address) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.address = address;
        this.cart = new Cart();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public void addOrderIdToOrdersList(String id) {
        this.orderIds.add(id);
    }


}
