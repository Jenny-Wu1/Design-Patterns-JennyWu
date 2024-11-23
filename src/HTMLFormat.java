import java.util.ArrayList;

public class HTMLFormat implements IFormat {

    public ArrayList<String> format(ArrayList<String> fileContent) {
        ArrayList<String> formattedContent = new ArrayList<>();
        formattedContent.add("<html dir=\"ltr\" lang=\"en\">");
        formattedContent.add("<head>");
        for (String line : fileContent) {
            formattedContent.add("<text=" + line + ">");
        }
        formattedContent.add("</head>");
        formattedContent.add("</html>");
        return formattedContent;
    }
}
