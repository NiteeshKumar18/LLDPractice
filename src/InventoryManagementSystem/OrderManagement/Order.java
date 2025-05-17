package InventoryManagementSystem.OrderManagement;

import InventoryManagementSystem.User.User;

public class Order {

    private int orderId;

    private User user;

    private String address;

    private String wareHouseId;

    private String invoice;

    private DeliveryStatus deliveryStatus;

    private Payment payment;

    private String courierId;


    public Order(int id, User user, String address, String wareHouseId, String invoice, Payment payment, String courierId) {
        this.orderId = id;
        this.user = user;
        this.address = address;
        this.wareHouseId = wareHouseId;
        this.invoice = invoice;
        this.payment = payment;
        this.courierId = courierId;
        this.deliveryStatus = DeliveryStatus.ORDERED;
    }


    public void checkOut() {
        /*
          remove item form warehouse
          wait for payment
          if fails add items back in ware house inventory;
         */
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

}
