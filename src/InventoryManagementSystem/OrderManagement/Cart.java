package InventoryManagementSystem.OrderManagement;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, Integer> productIdToCountMap = new HashMap<>();


    public void incCountOfProduct(int id, int count) {
        var currentCount = productIdToCountMap.getOrDefault(id, 0);
        productIdToCountMap.put(id, currentCount + count);
    }

    public Map<Integer, Integer> getProductIdToCountMap() {
        return productIdToCountMap;
    }

    public void addItemToCart(int id, int count) {
        var existingCount = productIdToCountMap.getOrDefault(id, count);
        productIdToCountMap.put(id, existingCount + count);
    }
}
