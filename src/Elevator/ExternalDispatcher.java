package Elevator;

import java.util.List;

public class ExternalDispatcher {

    private final List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllerList;


    public void submitNewRequest(Floor.Direction dir, int floor) {

        for (ElevatorController controller : elevatorControllers) {
            if (controller.getElevatorCar().getId() % 2 == 1 && floor % 2 == 1) {
                controller.submitNewRequest(floor, dir);
            } else if (controller.getElevatorCar().getId() % 2 == 0 && floor % 2 == 0) {
                controller.submitNewRequest(floor, dir);
            }
        }

    }
}
