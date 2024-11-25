import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
public class logger {
    private static logger uniqueInstance;
    private List<String> logHistory;
    private FileWriter fileWriter;
    private String outputDestination;

    private logger () {
        logHistory = new ArrayList<>();
        outputDestination = "all";
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
        String logMessage = formatLogMessage(level, message);
        logHistory.add(logMessage);

        if (outputDestination.equals("console") || outputDestination.equals("all")) {
            System.out.println(logMessage);
        }

        if (outputDestination.equals("file") || outputDestination.equals("all")) {
            try {
                fileWriter.write(logMessage + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                System.out.println("Error writing log file: " + e.getMessage());
            }
        }
    }

    private String formatLogMessage(String level, String message) {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        return "[" + timestamp + "] [" + level + "] " + message;
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

    public void archiveLogs() {
        String timestamp = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String archiveFileName = "logs_archive_" + timestamp;

        try (FileWriter archiveWriter = new FileWriter(archiveFileName)) {
            for (String log : logHistory) {
                archiveWriter.write(log + "\n");
            }
            System.out.println("Logs archived to: " + archiveFileName);
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        }
    }

    public void setOutputDestination(String destination) {
        if (!destination.equals("console") && !destination.equals("file") && !destination.equals("all")) {
            System.out.println("Invalid output destination, defaulting to 'all'...");
            this.outputDestination = "all";
        } else {
            this.outputDestination = destination;
        }
    }

}
