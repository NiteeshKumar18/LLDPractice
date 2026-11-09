package CarRental;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleRentalSystem {
    private final Map<String, Store> stores = new ConcurrentHashMap<>();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public void addStore(Store store) {
        stores.put(store.getStoreId(), store);
    }

    public void removeStore(String storeId) {
        stores.remove(storeId);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }

    public User getUser(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User " + userId + " not found");
        }
        return user;
    }

    public List<Store> getStoresInCity(String city) {
        return stores.values().stream()
                .filter(store -> store.getLocation().getCity().equalsIgnoreCase(city))
                .toList();
    }
}
