import java.io.IOException;

public class consoleLogOutput implements LogOutput {
    public void writeLog(String logMessage) {
        System.out.println(logMessage);
    }

    @Override
    public void close() {}
}
