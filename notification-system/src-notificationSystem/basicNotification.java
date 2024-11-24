import java.util.ArrayList;
import java.util.List;

public class basicNotification extends Notification {
    private List<String> history = new ArrayList<>();
    public basicNotification() {
        this.description = "Basic notifications";
    }

    public void send(String message) {
        String log = "System update(s): " + message;
        System.out.println(log);
        addToHistory(log);
    }

    public void addToHistory(String log) {
        history.add(log);
    }

    public List<String> getHistory() {
        return history;
    }
}
