package InventoryManagementSystem.Product;

public class Product {
    private String productId;

    private String name;

    public Product(String id, String name) {
        this.productId = id;
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
