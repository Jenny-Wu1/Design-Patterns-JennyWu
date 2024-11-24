public class basicNotification extends Notification {
    public basicNotification() {
        this.description = "Basic notifications";
    }

    public void send(String message) {
        System.out.println("System updates: " + message);
    }
}
