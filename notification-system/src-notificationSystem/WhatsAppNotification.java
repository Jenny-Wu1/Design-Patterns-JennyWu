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
        System.out.println("WhatsApp alert(s): " + message);
    }
}
