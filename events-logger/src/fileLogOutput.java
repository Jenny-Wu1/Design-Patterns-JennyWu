import java.io.FileWriter;
import java.io.IOException;

public class fileLogOutput implements LogOutput {
    private FileWriter fileWriter;

    public fileLogOutput() {
        try {
            fileWriter = new FileWriter("log_files", true);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing file writer: " + e);
        }
    }

    public void writeLog(String logMessage) {
        try {
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing log file: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
