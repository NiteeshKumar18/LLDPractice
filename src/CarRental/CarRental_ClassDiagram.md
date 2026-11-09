# Car Rental – Class Diagram

## Legend
| Arrow | Meaning | Example |
|---|---|---|
| `<\|--` | **Is-a** (extends) | `Car` is a `Vehicle` |
| `<\|..` | **Is-a** (implements) | `HourlyDailyPricingStrategy` is a `PricingStrategy` |
| `*--` | **Has-a, composition**: the part is created and owned by the whole | `Store` creates its `VehicleInventoryManager` |
| `o--` | **Has-a, aggregation**: the part exists on its own | `VehicleRentalSystem` holds `Store`s |
| `-->` | **Uses / refers to** | `Reservation` refers to a `User` |

## Diagram
```mermaid
classDiagram
    class VehicleRentalSystem {
        -Map~String, Store~ stores
        -Map~String, User~ users
        +addStore(Store)
        +addUser(User)
        +getUser(userId) User
        +getStoresInCity(city) List~Store~
    }
    class Store {
        -String storeId
        -Location location
        -VehicleInventoryManager vehicleInventoryManager
        -PricingStrategy pricingStrategy
        -Map~String, Reservation~ reservations
        +searchVehicles(type, start, end) List~Vehicle~
        +reserve(user, vehicleId, start, end) Reservation
        +pickUp(reservationId)
        +returnVehicle(reservationId, returnTime, kms) Bill
        +cancel(reservationId)
    }
    class VehicleInventoryManager {
        -Map~String, Vehicle~ vehicles
        -Map~String, List~Reservation~~ reservationsByVehicle
        +searchAvailable(type, start, end) List~Vehicle~
        +addReservation(Reservation)
        +addVehicle(Vehicle)
        +removeVehicle(vehicleId)
    }
    class Vehicle {
        <<abstract>>
        -String id
        -String vehicleNo
        -VehicleType type
        -int hourlyCost
        -int dailyCost
        -int kmsDriven
        +addKms(kms)
    }
    class Car
    class Bike
    class VehicleType {
        <<enumeration>>
        CAR
        BIKE
    }
    class Reservation {
        -String reservationId
        -LocalDateTime startTime
        -LocalDateTime endTime
        -Status status
        +overlaps(start, end) boolean
        +pickUp()
        +cancel()
        +complete(Bill)
    }
    class Status {
        <<enumeration>>
        BOOKED
        IN_PROGRESS
        COMPLETED
        CANCELLED
    }
    class Bill {
        -String billId
        -long amount
        -boolean paid
        +markPaid()
    }
    class PricingStrategy {
        <<interface>>
        +calculate(vehicle, start, end) long
    }
    class HourlyDailyPricingStrategy
    class User {
        -String id
        -String name
        -String email
    }
    class Location {
        -String city
        -String state
        -String pinCode
    }

    %% Is-a
    Vehicle <|-- Car
    Vehicle <|-- Bike
    PricingStrategy <|.. HourlyDailyPricingStrategy

    %% Has-a
    VehicleRentalSystem "1" o-- "*" Store
    VehicleRentalSystem "1" o-- "*" User
    Store "1" *-- "1" VehicleInventoryManager
    Store "1" o-- "1" PricingStrategy
    Store "1" *-- "*" Reservation
    Store "1" --> "1" Location
    VehicleInventoryManager "1" o-- "*" Vehicle
    Reservation "1" *-- "0..1" Bill

    %% Uses
    Reservation --> User
    Reservation --> Vehicle
    Reservation --> Status
    Vehicle --> VehicleType
```

## Relationships in plain words
**Is-a**
- `Car` and `Bike` are `Vehicle`s. `Vehicle` is abstract, so only concrete types are created.
- `HourlyDailyPricingStrategy` is a `PricingStrategy`. New pricing rules are added as new implementations.

**Has-a**
- `VehicleRentalSystem` has many `Store`s and `User`s. They are created outside and registered, so this is aggregation.
- `Store` creates and owns its `VehicleInventoryManager` and its `Reservation`s (composition).
- `Store` has a `PricingStrategy` passed in through the constructor (aggregation, dependency injection).
- `VehicleInventoryManager` has many `Vehicle`s, which can be added or removed.
- A `Reservation` gets one `Bill` when the vehicle is returned (0 or 1).

**Uses**
- A `Reservation` refers to a `User` and a `Vehicle` that exist independently of it.

