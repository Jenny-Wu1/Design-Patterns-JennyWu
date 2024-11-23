import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
        if (format != null) {
            ArrayList<String> formattedContent = format.format(fileContent);
            for (String line : formattedContent) {
                System.out.println(line);
            }
        } else {
            System.out.println("No format selected");
        }
    }

    public void saveFormatted(String filename) {
        if (format == null) {
            System.out.println("No format selected, saving as plain text");
        }
        ArrayList<String> formattedContent = (format != null) ? format.format(fileContent) : fileContent;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : formattedContent) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File saved! :)");
        } catch (IOException e) {
            System.out.println("There was an error saving the file :( - " + e.getMessage());
        }

    }
}
