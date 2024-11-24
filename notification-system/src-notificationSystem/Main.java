import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Notification baseNotification = new basicNotification();
        List<String> preferences = notificationPreferences.getUserPreferences();
        Notification configuredNotification = notificationPreferences.configure(baseNotification, preferences);
        configuredNotification.send("System update scheduled for 1:00 AM.");
    }
}
