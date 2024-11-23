public abstract class notification {
    String description = "Basic Notification";

    public String getDescription() {
        return description;
    }

    public abstract void send(String message);
}
