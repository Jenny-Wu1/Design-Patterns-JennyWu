import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MainNotification {
    public static void main (String[] args) {
        Notification baseNotification = new basicNotification();
        List<String> preferences = notificationPreferences.getUserPreferences();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the names any channels you want disabled (no notifications from)");
        System.out.println("Enter them (e.g., email, sms, slack, whatsapp, push). Type 'none' if no channels are disabled :)");
        String disabledInput = scanner.nextLine();
        List<String> disabledChannels = disabledInput.equalsIgnoreCase("none") ?
                Arrays.asList() : Arrays.asList(disabledInput.split(",\\s*"));

        Notification configuredNotification = notificationPreferences.configure(baseNotification, preferences, disabledChannels);
        configuredNotification.send("System update scheduled for 1:00 AM.");
        configuredNotification.send("System maintenance at midnight.");

        List<String> history = configuredNotification.getHistory();
        System.out.println("\nNotification History:");
        for (String log : history) {
            System.out.println(log);
        }
    }
}
