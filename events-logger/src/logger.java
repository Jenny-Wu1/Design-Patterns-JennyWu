import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
public class logger {
    private static logger uniqueInstance;
    private List<String> logHistory;
    private List<LogOutput> outputs;

    private logger () {
        logHistory = new ArrayList<>();
        outputs = new ArrayList<>();
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

        for (LogOutput output : outputs) {
            output.writeLog(logMessage);
        }
    }

    private String formatLogMessage(String level, String message) {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        return "[" + timestamp + "] [" + level + "] " + message;
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
            logHistory.clear();
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        }
    }

    public void addOutput (LogOutput output) {
        outputs.add(output);
    }

    public void removeOutput(LogOutput output) {
        outputs.remove(output);
    }

    public void closeAllOutputs() {
        for (LogOutput output : outputs) {
            try {
                output.close();
            } catch (IOException e) {
                System.out.println("Error closing log output: " + e.getMessage());
            }
        }
    }

}
