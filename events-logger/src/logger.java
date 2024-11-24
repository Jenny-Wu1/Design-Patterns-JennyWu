import java.util.ArrayList;
import java.util.List;

public class logger {
    private static logger uniqueInstance;
    private List<String> logHistory;

    private logger () {
        logHistory = new ArrayList<>();
    }

    public static logger getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of events logger");
            uniqueInstance = new logger();
        }
        System.out.println("Returning instance of events logger");
        return uniqueInstance;
    }

    public void log(String level, String message) {
        String logMessage = "[" + level + "] " + message;
        logHistory.add(logMessage);
        System.out.println(logMessage);
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }

}
