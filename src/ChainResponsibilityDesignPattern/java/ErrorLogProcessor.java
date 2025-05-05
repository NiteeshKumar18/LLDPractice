package ChainResponsibilityDesignPattern.java;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void processLog(int logLevel, String message) {
        if (logLevel == LogProcessor.ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.processLog(logLevel, message);
        }
    }
}
