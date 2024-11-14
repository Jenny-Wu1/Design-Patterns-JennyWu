import java.util.ArrayList;

public class HTMLFormat implements IFormat {

    public void format(ArrayList<String> fileContent) {
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for(int i = 0; i < fileContent.size(); i++){
            System.out.println("<text=" + fileContent.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }
}
