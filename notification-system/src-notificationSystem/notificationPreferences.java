import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class notificationPreferences {
    public static Notification configure(Notification baseNotif, List<String> preferences) {
        Notification notification = baseNotif;

        for (String preference : preferences) {
            switch (preference.toLowerCase()) {
                case "email":
                    notification = new emailNotification(notification);
                    break;
                case "sms":
                    notification = new SMSNotification(notification);
                    break;
                case "slack":
                    notification = new slackNotification(notification);
                    break;
                case "whatsapp":
                    notification = new WhatsAppNotification(notification);
                    break;
                case "push":
                    notification = new pushNotification(notification);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported notification channel, please try again :( - " + preference);
            }
        }
        return notification;
    }

    public static List<String> getUserPreferences() {
        Scanner scanner = new Scanner(System.in);
        List<String> preferences = new ArrayList<>();

        System.out.println("Enter the names of the channels you'd like to receive notifications from (e.g., email, sms, slack, whatsapp, push).");
        System.out.println("Please type the name and press enter after each one if you're selecting multiple, then type 'done' to finish. :)");

        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) {
                break;
            } else if (input.equals("email") || input.equals("sms") || input.equals("slack") ||
                        input.equals("whatsapp") || input.equals("push")) {
                preferences.add(input);
            } else {
                System.out.println("Invalid channel, please try again :(");
            }
        }
        return preferences;
    }
}
