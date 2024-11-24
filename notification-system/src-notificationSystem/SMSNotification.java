import java.util.List;

public class SMSNotification extends notificationDecorator {
    private Notification toBeDecorated;

    public SMSNotification(Notification notification) {
        this.toBeDecorated = notification;
    }

    public String getDescription() {
        return toBeDecorated.getDescription() + " + SMS";
    }

    public void send(String message) {
        toBeDecorated.send(message);
        String log = "SMS alert(s): " + message;
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
