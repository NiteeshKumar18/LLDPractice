package ChainResponsibilityDesignPattern.java;

public abstract class LogProcessor {

    private LogProcessor nextProcessor;
    public static int INFO =1;
    public static int DEBUG =2;

    public static int ERROR =3;


    public LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processLog(int logLevel, String message) {
        if(nextProcessor!= null){
            nextProcessor.processLog(logLevel, message);
        }
    }
}
