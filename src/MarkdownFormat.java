import java.util.ArrayList;
import java.util.Random;

public class MarkdownFormat implements IFormat{

    public ArrayList<String> format(ArrayList<String> fileContent){
        ArrayList<String> formattedContent = new ArrayList<>();
        String[] options = {"**", " ***", "~~", "__", "<sub>"};
        Random rng = new Random();
        formattedContent.add("#" + fileContent.get(0));
        for(int i = 1; i < fileContent.size(); i++){
            int number = rng.nextInt(options.length);
            String option = options[number];
            formattedContent.add(option + fileContent.get(i) + option);
        }
        return formattedContent;
    }

}
