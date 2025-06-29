package Logger;

public interface LogStrategy {

    boolean publishLog(LogLevel level, String message);
}
