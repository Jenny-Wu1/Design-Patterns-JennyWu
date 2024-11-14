import java.util.ArrayList;
public class plainTextFormat implements IFormat {
    public void format(ArrayList<String> fileContent){

            for(int i = 0; i < fileContent.size(); i++){
                System.out.println(fileContent.get(i));
            }
    }
}
