package Elevator;

public class Floor {
    private final int floorNumber;

    private ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher();
    }


    public enum Direction {
        UP,
        DOWN,
        IDLE
    }

    public void submitNewRequestToDispatcher(Direction direction){
        externalDispatcher.submitNewRequest(direction,floorNumber);
    }
}
