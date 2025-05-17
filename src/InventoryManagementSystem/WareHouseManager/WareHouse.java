package InventoryManagementSystem.WareHouseManager;

import InventoryManagementSystem.WareHouseManager.InventoryManager;

public class WareHouse {
    private String wareHouseId;

    private String wareHouseName;

    private String wareHouseLocation;

    private InventoryManager inventoryManager;

    public WareHouse(String id, String name, String location, InventoryManager manager) {
        this.inventoryManager = manager;
        this.wareHouseId = id;
        this.wareHouseLocation = location;
        this.wareHouseName = name;
    }


    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getWareHouseLocation() {
        return wareHouseLocation;
    }

    public void setWareHouseLocation(String wareHouseLocation) {
        this.wareHouseLocation = wareHouseLocation;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

}
