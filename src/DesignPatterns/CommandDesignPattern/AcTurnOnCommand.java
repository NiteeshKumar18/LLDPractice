package DesignPatterns.CommandDesignPattern;

import java.util.Stack;

public class AcTurnOnCommand implements ICommand {

    private AirConditioner airConditioner;
    private Stack<ICommand> commandStack = new Stack<>();


    public AcTurnOnCommand() {
        this.airConditioner = new AirConditioner();
    }

    @Override
    public void execute() {
        airConditioner.turnOnAc();
    }

    @Override
    public void undo() {
        airConditioner.turnOffAc();
    }
}
