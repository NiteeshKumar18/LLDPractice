package Elevator;

public class ElevatorDisplay {
    int floor;
    Floor.Direction direction;

    public void setDisplay(int floor, Floor.Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay(){
        System.out.println(floor);
        System.out.println(direction);
    }
}
