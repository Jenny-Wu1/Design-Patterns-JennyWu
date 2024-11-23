import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();
        fileContent.add("This is the text formatter system :)");
        fileContent.add("wooooo line 2");
        fileContent.add("line threeeeeee");
        fileContent.add("fourth line hooray");
        fileContent.add("yippeeeee");
        textFile file = new textFile(fileContent);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Select a formatting option:");
            System.out.println("1: Plain Text");
            System.out.println("2: HTML");
            System.out.println("3: Markdown");
            System.out.println("4: Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    file.setFormat(new plainTextFormat());
                    file.printFormatted();
                    break;
                case 2:
                    file.setFormat(new HTMLFormat());
                    file.printFormatted();
                    break;
                case 3:
                    file.setFormat(new MarkdownFormat());
                    file.printFormatted();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }
}
