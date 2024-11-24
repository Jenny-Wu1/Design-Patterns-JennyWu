import java.util.List;

public class pushNotification extends notificationDecorator {
    private Notification toBeDecorated;

    public pushNotification(Notification notification) {
        this.toBeDecorated = notification;
    }

    public String getDescription() {
        return toBeDecorated.getDescription() + " + Push";
    }

    public void send(String message) {
        toBeDecorated.send(message);
        String log = "Push notification(s): " + message;
        System.out.println(log);
        toBeDecorated.addToHistory(log);
    }

    public void addToHistory(String log) {
        toBeDecorated.addToHistory(log);
    }

    public List<String> getHistory() {
        return toBeDecorated.getHistory();
    }
}
