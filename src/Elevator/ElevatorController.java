package Elevator;

import java.util.PriorityQueue;

public class ElevatorController {


    private final ElevatorCar elevatorCar;

    PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    PriorityQueue<Integer> downQueue = new PriorityQueue<>((a, b) -> b - a);

    PriorityQueue<Integer> deferredUpQueue = new PriorityQueue<>();

    PriorityQueue<Integer> deferredDownQueue = new PriorityQueue<>((a, b) -> b - a);

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }


    public void submitNewRequest(int floor, Floor.Direction direction) {
        if (direction == Floor.Direction.UP) {
            if (elevatorCar.getDirection() == Floor.Direction.UP && floor >= elevatorCar.currentFloor) {
                upQueue.offer(floor);
            } else {
                deferredUpQueue.offer(floor);
            }
        } else {
            if (elevatorCar.getDirection() == Floor.Direction.DOWN && floor <= elevatorCar.currentFloor) {
                downQueue.offer(floor);
            } else {
                deferredDownQueue.offer(floor);
            }
        }
    }

    public void StartElevator() {
        while (true) {

            if (elevatorCar.getDirection() == Floor.Direction.UP || elevatorCar.getDirection() == Floor.Direction.IDLE) {
                while (!upQueue.isEmpty()) {
                    int floor = upQueue.poll();
                    elevatorCar.moveElevator(floor, Floor.Direction.UP);
                }

                if (!downQueue.isEmpty()) {
                    elevatorCar.setDirection(Floor.Direction.DOWN);
                } else {
                    elevatorCar.setDirection(Floor.Direction.IDLE);
                }
            }

            if (elevatorCar.getDirection() == Floor.Direction.DOWN || elevatorCar.getDirection() == Floor.Direction.IDLE) {
                while (!downQueue.isEmpty()) {
                    int floor = downQueue.poll();
                    elevatorCar.moveElevator(floor, Floor.Direction.DOWN);
                }

                if (!deferredUpQueue.isEmpty()) {
                    elevatorCar.setDirection(Floor.Direction.UP);
                } else {
                    elevatorCar.setDirection(Floor.Direction.IDLE);
                }
            }


            if (!deferredUpQueue.isEmpty()) {
                upQueue.addAll(deferredUpQueue);
                deferredUpQueue.clear();
                elevatorCar.setDirection(Floor.Direction.UP);
            } else if (!deferredDownQueue.isEmpty()) {
                downQueue.addAll(deferredDownQueue);
                deferredDownQueue.clear();
                elevatorCar.setDirection(Floor.Direction.DOWN);
            }


        }
    }

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {
        if (elevatorCar.getCurrentFloor() < floor) {
            upQueue.add(floor);
        } else {
            downQueue.add(floor);
        }
        // submit request to elevator
    }
}
