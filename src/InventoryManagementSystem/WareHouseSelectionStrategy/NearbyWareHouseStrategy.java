package InventoryManagementSystem.WareHouseSelectionStrategy;

import InventoryManagementSystem.WareHouseManager.WareHouse;

import java.util.List;

public class NearbyWareHouseStrategy implements WareHouseSelectionStrategy {
    @Override
    public WareHouse getWareHouse(List<WareHouse> wareHouseList) {
        return wareHouseList.get(0);
    }
}
