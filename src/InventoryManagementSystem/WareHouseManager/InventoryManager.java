package InventoryManagementSystem.WareHouseManager;

import InventoryManagementSystem.Product.ProductInventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private String id;

    private List<ProductInventory> productCategoryList = new ArrayList<>();

    private String name;


    public InventoryManager(String id, String name, List<ProductInventory> productCategoryList) {
        this.id = id;
        this.name = name;
        this.productCategoryList = productCategoryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductInventory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductInventory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
