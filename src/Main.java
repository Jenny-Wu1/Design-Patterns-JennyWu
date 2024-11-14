import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();
        data.add("hwgugh");
        data.add("eigwieg");
        data.add("igjwgjgijgr");
        textFile file = new textFile(data);

        int option = 0;
        switch (option) {
            case 0:
                file.printPlainText();
                break;
            case 1:
                file.printHTML();
                break;
            case 2:
                file.printMarkdown();
                break;
            default:
                file.printPlainText();
        }

    }
}
