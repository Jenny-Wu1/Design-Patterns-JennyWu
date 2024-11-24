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
        System.out.println("Email update(s): " + message);
    }
}
