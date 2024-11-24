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
        System.out.println("Push notification(s): " + message);
    }
}
