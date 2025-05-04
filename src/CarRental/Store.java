package CarRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {

    private final String storeId;
    private final Location location;

    private  VehicleInventoryManager vehicleInventoryManager;

    private List<Reservation> allReservations= new ArrayList<>();



    public Store(String storeId, Location location, List<Vehicle> vehicles) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager(vehicles);
    }

    public void confirmReservation(User user, Vehicle vehicle){
        Reservation reservation = new Reservation("1234",this.storeId,vehicle,user,this.location,new Date(),this.location,new Date());
        Bill bill = new Bill(reservation);
        System.out.println("Bill generated for reservation"+ bill);
        allReservations.add(reservation);
    }

    public List<Vehicle> getListOfVehicles(){
        return this.vehicleInventoryManager.getVehicles();
    }



}
