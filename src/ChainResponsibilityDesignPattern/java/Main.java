package ChainResponsibilityDesignPattern.java;

import Elevator.Floor;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));
        logProcessor.processLog(LogProcessor.ERROR, "This is an error message.");
        logProcessor.processLog(LogProcessor.INFO, "This is an info message.");
        logProcessor.processLog(LogProcessor.DEBUG, "This is a debug message.");
    }
}
