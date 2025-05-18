package DesignPatterns.CommandDesignPattern;

import DesignPatterns.CommandDesignPattern.ICommand;

import java.util.Stack;

public class RemoteControl {
    private ICommand command;
    private Stack<ICommand> commandStack = new Stack<>();


    public RemoteControl(ICommand iCommand) {
        this.command = iCommand;
    }

    public void pressButton() {
        command.execute();
        commandStack.push(command);
    }

    public void undo() {
        if (!commandStack.empty()) {
            ICommand latestCommandLocal = commandStack.pop();
            latestCommandLocal.undo();
        }
    }
}
