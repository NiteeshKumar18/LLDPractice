package CarRental;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Location bangalore = new Location("Karnataka", "Bangalore Urban", "Bangalore", "560001");
        Store store = new Store("S1", bangalore, List.of(
                new Car("C1", "Swift", "KA01AB1234", 150, 1500, 12000),
                new Car("C2", "City", "KA01AB5678", 250, 2500, 8000),
                new Bike("B1", "Activa", "KA01XY1111", 50, 400, 3000)),
                new HourlyDailyPricingStrategy());

        VehicleRentalSystem system = new VehicleRentalSystem();
        system.addStore(store);
        User alice = new User("U1", "Alice", "alice@example.com", "9000000001");
        User bob = new User("U2", "Bob", "bob@example.com", "9000000002");
        system.addUser(alice);
        system.addUser(bob);

        LocalDateTime start = LocalDateTime.of(2026, 12, 1, 10, 0);
        LocalDateTime end = start.plusDays(1).plusHours(3);

        System.out.println("1. Search");
        Store bangaloreStore = system.getStoresInCity("Bangalore").get(0);
        System.out.println("   Available cars: " + bangaloreStore.searchVehicles(Vehicle.VehicleType.CAR, start, end));

        System.out.println("2. Reserve");
        Reservation aliceBooking = bangaloreStore.reserve(alice, "C1", start, end);
        System.out.println("   " + aliceBooking);

        System.out.println("3. Overlapping booking is rejected");
        try {
            bangaloreStore.reserve(bob, "C1", start.plusHours(5), end.plusHours(5));
        } catch (IllegalStateException e) {
            System.out.println("   Bob rejected: " + e.getMessage());
        }
        System.out.println("   Available cars now: " + bangaloreStore.searchVehicles(Vehicle.VehicleType.CAR, start, end));

        System.out.println("4. Non-overlapping booking on the same car works");
        Reservation bobBooking = bangaloreStore.reserve(bob, "C1", start.plusDays(3), start.plusDays(3).plusHours(4));
        System.out.println("   " + bobBooking);

        System.out.println("5. Pick up, return 2 hours late, pay");
        bangaloreStore.pickUp(aliceBooking.getReservationId());
        Bill bill = bangaloreStore.returnVehicle(aliceBooking.getReservationId(), end.plusHours(2), 180);
        bill.markPaid();
        System.out.println("   " + bill + ", status=" + aliceBooking.getStatus());

        System.out.println("6. Cancel, then invalid transition");
        bangaloreStore.cancel(bobBooking.getReservationId());
        System.out.println("   " + bobBooking);
        try {
            bangaloreStore.pickUp(bobBooking.getReservationId());
        } catch (IllegalStateException e) {
            System.out.println("   Rejected: " + e.getMessage());
        }

        System.out.println("7. Five users book C2 for the same slot at once");
        LocalDateTime slotStart = LocalDateTime.of(2026, 12, 10, 9, 0);
        AtomicInteger successful = new AtomicInteger();
        CountDownLatch startSignal = new CountDownLatch(1);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            User user = new User("P" + i, "Parallel" + i, "p" + i + "@example.com", "90000000" + i);
            pool.submit(() -> {
                startSignal.await();
                try {
                    bangaloreStore.reserve(user, "C2", slotStart, slotStart.plusHours(6));
                    successful.incrementAndGet();
                } catch (IllegalStateException ignored) {
                }
                return null;
            });
        }
        startSignal.countDown();
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("   Successful bookings: " + successful.get() + " of 5");
    }
}
