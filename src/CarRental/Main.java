package CarRental;

import TicTacToe.TicTacToe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("123","abc",130,"456",120,500, Vehicle.VEHICLE_TYPE.CAR);
        Vehicle vehicle2 = new Vehicle("1234","abc",130,"4567",120,500, Vehicle.VEHICLE_TYPE.CAR);
        Vehicle vehicle3 = new Vehicle("12345","abc",130,"45678",120,500, Vehicle.VEHICLE_TYPE.CAR);

        Store store = new Store("store1", new Location("location1", "address1","",""), List.of(vehicle1, vehicle2, vehicle3));
        User user1 = new User("1234","Niteesh","nkumar@clari.com","1234567890", new Location("location1", "address1","",""));
        var allVehiclesAvailableInStore1    = store.getListOfVehicles();

        store.confirmReservation(user1,allVehiclesAvailableInStore1.get(0));
        System.out.println("Vehicle is reserved for user1");

    }
}
