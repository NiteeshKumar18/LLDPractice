package Logger;

public class Logger {


    private LoggerConfig loggerConfig;

    public Logger(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }


    public void log(String message, LogLevel level) {
        loggerConfig.getStrategy().publishLog(level, message);
    }
}
