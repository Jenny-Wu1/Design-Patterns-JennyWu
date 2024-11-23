import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class textFileGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JComboBox<String> formatComboBox;
    private JButton saveButton;
    private textFile file;

    public textFileGUI() {
        ArrayList<String> fileContent = new ArrayList<>();
        fileContent.add("This is the text formatter system :)");
        fileContent.add("wooooo line 2");
        fileContent.add("line threeeeeee");
        fileContent.add("fourth line hooray");
        fileContent.add("yippeeeee");
        file = new textFile(fileContent);

        //GUI setup
        frame = new JFrame("Text Formatter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        //Layout setup
        frame.setLayout(new BorderLayout());

        //Text area for file content
        textArea = new JTextArea();
        textArea.setText(String.join("\n", fileContent));
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        //Combo box for format selection
        String[] formats = {"Plain Text", "HTML", "Markdown", "JSON"};
        formatComboBox = new JComboBox<>(formats);
        frame.add(formatComboBox, BorderLayout.NORTH);

        //Save Button
        saveButton = new JButton("Save File");
        frame.add(saveButton, BorderLayout.SOUTH);

        formatComboBox.addActionListener(new formatSelectionHandler());
        saveButton.addActionListener(new saveButtonHandler());

        frame.setVisible(true);
    }

    private class formatSelectionHandler implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String selectedFormat = (String) formatComboBox.getSelectedItem();
            switch (selectedFormat) {
                case "Plain Text":
                    file.setFormat(new plainTextFormat());
                    break;
                case "HTML":
                    file.setFormat(new HTMLFormat());
                    break;
                case "Markdown":
                    file.setFormat(new MarkdownFormat());
                    break;
                case "JSON":
                    file.setFormat(new JSONFormat());
                    break;
            }
            ArrayList<String> formattedContent = file.format.format(file.fileContent);
            textArea.setText(String.join("\n", formattedContent));
        }
    }

    private class saveButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getPath();
                file.saveFormatted(fileName);
                JOptionPane.showMessageDialog(frame, "File saved! :)");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(textFileGUI::new);
    }

}
