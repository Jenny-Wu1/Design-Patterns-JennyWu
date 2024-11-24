import java.util.List;

public class slackNotification extends notificationDecorator {
    private Notification toBeDecorated;
    public slackNotification(Notification notification) {
        this.toBeDecorated = notification;
    }

    public String getDescription() {
        return toBeDecorated.getDescription() + " + Slack";
    }

    public void send(String message) {
        toBeDecorated.send(message);
        String log = "Slack notification(s): " + message;
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
