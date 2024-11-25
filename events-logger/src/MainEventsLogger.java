public class MainEventsLogger {
    public static void main(String[] args) {
        logger log = logger.getInstance();

        log.addOutput(new consoleLogOutput());
        log.info("Application started");

        log.addOutput(new fileLogOutput());
        log.debug("Debugging in progress...");

        log.addOutput(new rotatingFileLogOutput());
        log.error("An error occurred :(");
        log.info("No new updates to report");

        log.addOutput(new dateRotatingFileLogOutput());
        log.debug("Bug successfully fixed!");
        log.error("Critical error found..!!");

        System.out.println("Log History: ");
        for (String entry : log.getLogHistory()) {
            System.out.println(entry);
        }
        log.archiveLogs();
        log.closeAllOutputs();
    }
}
