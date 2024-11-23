import java.util.ArrayList;
import java.util.Random;

public class textFile {
    private ArrayList<String> fileContent;
    private IFormat format;

    public textFile(){
        fileContent = new ArrayList<>();
    }

    public void setFormat(IFormat format){
        this.format = format;
    }

    public textFile(ArrayList<String> data){
        fileContent = data;
    }

    public void printFormatted(){
        format.format(fileContent);
    }
}
