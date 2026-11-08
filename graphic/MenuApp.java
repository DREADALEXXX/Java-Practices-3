import javax.swing.*;
import java.awt.*;

public class MenuApp extends JFrame {
    private final JTextArea area = new JTextArea(10, 30);

    public MenuApp() {
        super("Hello Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // === Меню ===
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выйти");
        exit.addActionListener(e -> System.exit(0));
        fileMenu.add(save);
        fileMenu.add(exit);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem copy  = new JMenuItem("Копировать");
        JMenuItem cut   = new JMenuItem("Вырезать");
        JMenuItem paste = new JMenuItem("Вставить");
        copy.addActionListener(e -> area.copy());
        cut.addActionListener(e  -> area.cut());
        paste.addActionListener(e -> area.paste());
        editMenu.add(copy);
        editMenu.add(cut);
        editMenu.add(paste);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("О программе");
        about.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Пример меню на Swing"));
        helpMenu.add(about);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // === Кнопки ===
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 2"));

        // === Компоновка ===
        setLayout(new BorderLayout(5, 5));
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuApp().setVisible(true));
    }
}