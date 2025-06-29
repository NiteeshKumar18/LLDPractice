package Logger;

public class LoggerConfig {

    private LogLevel level;
    private LogStrategy strategy;

    public LoggerConfig(LogLevel level, LogStrategy strategy) {
        this.level = level;
        this.strategy = strategy;
    }

    public LogLevel getLevel() {
        return level;
    }

    public LogStrategy getStrategy() {
        return strategy;
    }

}
