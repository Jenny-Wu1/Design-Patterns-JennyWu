import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class logger {
    private static logger uniqueInstance;
    private List<String> logHistory;
    private FileWriter fileWriter;

    private logger () {
        logHistory = new ArrayList<>();
        try {
            fileWriter = new FileWriter("log.history", true);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing file writer: ", e);
        }
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

        try {
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing log file: " + e.getMessage());
        }
    }

    public void closeFileWriter() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error closing the file writer: " + e.getMessage());
        }
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
