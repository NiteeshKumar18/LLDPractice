package DesignPatterns.CommandDesignPattern;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        AcTurnOnCommand turnOnCommand = new AcTurnOnCommand();
        RemoteControl remoteControl = new RemoteControl(turnOnCommand);
        remoteControl.pressButton();
        remoteControl.undo();

    }

}
