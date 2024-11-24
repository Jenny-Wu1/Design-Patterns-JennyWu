public class logger {
    private static logger uniqueInstance;

    private logger () {}

    public static logger getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of events logger");
            uniqueInstance = new logger();
        }
        System.out.println("Returning instance of events logger");
        return uniqueInstance;
    }

    public void log(String level, String message) {
        String logMessage = "[" + level + "] " + message;
        System.out.println(logMessage);
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

}
