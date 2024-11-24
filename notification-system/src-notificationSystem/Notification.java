import java.util.ArrayList;
import java.util.List;
public abstract class Notification {
    String description = "Basic Notification";

    public String getDescription() {
        return description;
    }

    public abstract void send(String message);

    public abstract void addToHistory(String log);

    public abstract List<String> getHistory();
}
