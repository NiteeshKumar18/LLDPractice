package InventoryManagementSystem.WareHouseManager;

import InventoryManagementSystem.WareHouseManager.WareHouse;
import InventoryManagementSystem.WareHouseSelectionStrategy.WareHouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class WareHouseController {

    private List<WareHouse> wareHouseList = new ArrayList<>();


    public void AddWareHouse(WareHouse wareHouse) {
        this.wareHouseList.add(wareHouse);
    }

    public List<WareHouse> getWareHouseList() {
        return this.wareHouseList;
    }

    public WareHouse selectWareHouse(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        return wareHouseSelectionStrategy.getWareHouse(this.wareHouseList);
    }


}
