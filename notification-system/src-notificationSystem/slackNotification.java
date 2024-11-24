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
        System.out.println("Slack notification(s): " + message);
    }
}
