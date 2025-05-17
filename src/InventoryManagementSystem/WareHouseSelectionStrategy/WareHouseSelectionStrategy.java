package InventoryManagementSystem.WareHouseSelectionStrategy;

import InventoryManagementSystem.WareHouseManager.WareHouse;

import java.util.List;

public interface WareHouseSelectionStrategy {

    WareHouse getWareHouse(List<WareHouse> wareHouseList);
}
