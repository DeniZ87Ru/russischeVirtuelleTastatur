import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualKeyboard {
    JFrame frame;
    JTextArea textField;
    String[] russianKeys = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

    public VirtualKeyboard() {
        frame = new JFrame("Russische Bildschirmtastatur");
        textField = new JTextArea(10, 20);
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4, 20));

        for (String key : russianKeys) {
            JButton button = new JButton(key);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + key);
                }
            });
            panel.add(button);
        }

        JButton copyButton = new JButton("Kopieren");
        copyButton.setBackground(Color.GREEN);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(textField.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
        panel.add(copyButton);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(800, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
