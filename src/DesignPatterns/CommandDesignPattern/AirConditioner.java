package DesignPatterns.CommandDesignPattern;

public class AirConditioner {
    private boolean isTurnedOn;

    private int temp;


    public void turnOnAc() {
        this.isTurnedOn = true;
    }

    public void turnOffAc() {
        this.isTurnedOn = false;
    }
}
