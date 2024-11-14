import java.util.ArrayList;
import java.util.Random;

public class MarkdownFormat implements IFormat{

    public void format(ArrayList<String> fileContent){
        String[] options = {"**", " ***", "~~", "__", "<sub>"};
        Random rng = new Random();
        System.out.println("#" + fileContent.get(0));
        for(int i = 1; i < fileContent.size(); i++){
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + fileContent.get(i) + option);
        }
    }

}
