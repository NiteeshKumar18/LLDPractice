package Logger;

public class ConsoleLogger implements LogStrategy {
    @Override
    public boolean publishLog(LogLevel level, String message) {
        System.out.println(message + " level is " + level);
        return true;
    }
}
