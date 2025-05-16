package ChainResponsibilityDesignPattern.java;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void processLog(int logLevel, String message) {
        if (logLevel == LogProcessor.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.processLog(logLevel, message);
        }
    }
}
