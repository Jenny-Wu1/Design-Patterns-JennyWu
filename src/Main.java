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
            System.out.println("Select a formatting option or save the document in selected format:");
            System.out.println("1: Plain Text");
            System.out.println("2: HTML");
            System.out.println("3: Markdown");
            System.out.println("4: JSON");
            System.out.println("5: Save document");
            System.out.println("6: Exit");

            int option = scanner.nextInt();
            scanner.nextLine();
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
                    file.setFormat(new JSONFormat());
                    file.printFormatted();
                    break;
                case 5:
                    System.out.println("Enter the filename to save: ");
                    String filename = scanner.nextLine();
                    file.saveFormatted(filename);
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
        scanner.close();
    }
}
