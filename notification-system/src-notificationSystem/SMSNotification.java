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
        System.out.println("SMS alert(s): " + message);
    }
}
