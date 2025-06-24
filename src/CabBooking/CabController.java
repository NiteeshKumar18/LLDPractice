package CabBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class CabController {

    private Map<String, Cab> cabIdToCabMap;

    public CabController() {
        cabIdToCabMap = new HashMap<String, Cab>();
    }


    public void addCab() {
        Location location = new Location(1234, 5678);
        CabRider rider = new CabRider("Rider 1", "Rider1");
        Cab cab = new Cab(ThreadLocalRandom.current().nextInt(), "123", "abc", location, rider);
    }

    public void updateLocationForCab(Location location, String cabId) {
        if (cabIdToCabMap.containsKey(cabId)) {
            Cab cab = cabIdToCabMap.get(cabId);
            cab.setLocation(location);
        }
    }

    public void updateCabAvailability(String cabId, boolean isAvailable) {
        if (cabIdToCabMap.containsKey(cabId)) {
            Cab cab = cabIdToCabMap.get(cabId);
            cab.setAvailable(isAvailable);
        }
    }

    public List<Cab> getAllCabs(Location location, int maxDistance) {
        List<Cab> cabList = new ArrayList<>();
        for (Cab cab : cabIdToCabMap.values()) {
            if (cab.isAvailable() && cab.getLocation().distanceTo(location) <= maxDistance) {
                cabList.add(cab);
            }
        }
        return cabList;
    }
}
