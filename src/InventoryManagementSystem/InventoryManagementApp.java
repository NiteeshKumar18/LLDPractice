package InventoryManagementSystem;

import InventoryManagementSystem.OrderManagement.Cart;
import InventoryManagementSystem.OrderManagement.Order;
import InventoryManagementSystem.OrderManagement.OrderController;
import InventoryManagementSystem.Product.ProductInventory;
import InventoryManagementSystem.User.User;
import InventoryManagementSystem.User.UserController;
import InventoryManagementSystem.WareHouseManager.InventoryManager;
import InventoryManagementSystem.WareHouseManager.WareHouse;
import InventoryManagementSystem.WareHouseManager.WareHouseController;
import InventoryManagementSystem.WareHouseSelectionStrategy.WareHouseSelectionStrategy;

public class InventoryManagementApp {

    private WareHouseController wareHouseController;

    private UserController userController;

    private OrderController orderController;


    public InventoryManagementApp(WareHouseController wareHouseController, OrderController orderController, UserController userController) {
        this.orderController = orderController;
        this.wareHouseController = wareHouseController;
        this.userController = userController;
    }


    public WareHouse getWareHouse(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        return wareHouseController.selectWareHouse(wareHouseSelectionStrategy);
    }

    public User getUser(String userId) {
        return userController.getUser(userId);
    }


    public InventoryManager getInventory(WareHouse house) {
        return house.getInventoryManager();
    }


    public void addProductToCart(User user, ProductInventory productInventory, int count) {
        Cart cart = user.getCart();
        cart.addItemToCart(1234, count);
    }

    public Order placeOrder(User user) {
        return orderController.processOrder(user);
    }

}
