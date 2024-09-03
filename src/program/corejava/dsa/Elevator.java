package program.corejava.dsa;

import java.util.PriorityQueue;

class Elevator {
    private int currentFloor;
    private PriorityQueue<Integer> requests;

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public PriorityQueue<Integer> getRequests() {
        return requests;
    }

    public void setRequests(PriorityQueue<Integer> requests) {
        this.requests = requests;
    }

    public Elevator() {
        this.currentFloor = 0;
        this.requests = new PriorityQueue<>();
    }

    public void requestFloor(int floor) {
        requests.add(floor);
    }

    public void move() {
        while (!requests.isEmpty()) {
            int targetFloor = requests.poll();
            System.out.println("Moving to floor: " + targetFloor);
            currentFloor = targetFloor;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.requestFloor(5);
        elevator.requestFloor(2);
        elevator.move();
    }
}
