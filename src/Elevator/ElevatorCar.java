package Elevator;

public class ElevatorCar {
    int id;
    int currentFloor;
    int targetFloor;
    Floor.Direction direction;

    InternalButtons internalButtons;

    ElevatorState.State elevatorState;

    ElevatorDoor elevatorDoor;

    ElevatorDisplay display;

    public int getId() {
        return id;
    }


    public ElevatorCar() {
        this.id =1;
        this.elevatorState = ElevatorState.State.IDLE;
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.direction = Floor.Direction.UP;
        this.internalButtons = new InternalButtons();
        this.elevatorDoor = new ElevatorDoor();
        this.display = new ElevatorDisplay();
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public Floor.Direction getDirection(){
        return this.direction;
    }

    public void setDirection(Floor.Direction dir){
        this.direction = dir;
    }

    public void pressButton(int destination) {
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, direction);
    }

    public void showDisplay() {
        display.showDisplay();
    }

    public void moveElevator(int destinationFloor, Floor.Direction dir){
        if(dir == Floor.Direction.UP){
            this.direction = Floor.Direction.UP;
            for(int i=currentFloor; i<=destinationFloor;i++){
                this.currentFloor =i;
                setDisplay();
                showDisplay();
            }
        }else {
            this.direction = Floor.Direction.DOWN;
            for(int i=currentFloor; i>=destinationFloor;i--){
                this.currentFloor =i;
                setDisplay();
                showDisplay();
            }
        }
        this.direction = Floor.Direction.IDLE;
    }

}
