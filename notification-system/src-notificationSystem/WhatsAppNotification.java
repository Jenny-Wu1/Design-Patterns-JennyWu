import java.util.List;

public class WhatsAppNotification extends notificationDecorator {
    private Notification toBeDecorated;

    public WhatsAppNotification(Notification notification) {
        this.toBeDecorated = notification;
    }

    public String getDescription() {
        return toBeDecorated.getDescription() + " WhatsApp";
    }

    public void send(String message) {
        toBeDecorated.send(message);
        String log = "WhatsApp alert(s): " + message;
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
