package CarRental;

public class Vehicle {


    public enum VEHICLE_TYPE {
        CAR, BIKE
    }

    private final String id;
    private final String NAME;

    private final int KMS_DRIVE;

    private final String VEHICLE_NO;

    private final int HOURY_COST;

    private final int DAILY_COST;

    private final VEHICLE_TYPE type;


    public Vehicle(String id, String name, int kms, String vehicleNo, int hourlyCost, int dailyCost, VEHICLE_TYPE type) {
        this.id = id;
        this.NAME = name;
        this.KMS_DRIVE = kms;
        this.VEHICLE_NO = vehicleNo;
        this.HOURY_COST = hourlyCost;
        this.DAILY_COST = dailyCost;
        this.type = type;
    }


    public String getId(){
        return this.id;
    }


}
