import java.util.List;

public class emailNotification extends notificationDecorator {
    private Notification toBeDecorated;

    public emailNotification(Notification notification) {
        this.toBeDecorated = notification;
    }

    public String getDescription() {
        return toBeDecorated.getDescription() + " + Email";
    }

    public void send(String message) {
        toBeDecorated.send(message);
        String log = "Email update(s): " + message;
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
