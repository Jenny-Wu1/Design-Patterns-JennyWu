import java.util.ArrayList;
public class JSONFormat implements IFormat {

    public ArrayList<String> format(ArrayList<String> fileContent) {
        ArrayList<String> formattedContent = new ArrayList<>();
        formattedContent.add("{");
        for (int i = 0; i < fileContent.size(); i++) {
            formattedContent.add("\"line" + (i + 1) + "\": \"" + fileContent.get(i) + "\"" + ",");
        }
        formattedContent.add("}");
        return formattedContent;
    }
}
