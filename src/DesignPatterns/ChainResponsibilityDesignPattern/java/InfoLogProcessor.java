package ChainResponsibilityDesignPattern.java;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void processLog(int logLevel, String message) {
        if (logLevel == LogProcessor.INFO) {
            System.out.println("INFO: " + message);
        } else {
            super.processLog(logLevel, message);
        }
    }
}
