package InventoryManagementSystem.Product;

import InventoryManagementSystem.Product.Product;

import java.util.List;

public class ProductInventory {
    private String inventoryId;

    private String inventoryName;

    private List<Product> productList;


    public ProductInventory(String id, String name, List<Product> productsList) {
        this.inventoryId = id;
        this.inventoryName = name;
        this.productList = productsList;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
