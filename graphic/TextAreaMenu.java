import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaMenu extends JFrame {
    private final JTextArea area = new JTextArea(10, 30);

    public TextAreaMenu() {
        super("JTextArea + меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        // === Цвет ===
        JMenu colorMenu = new JMenu("Цвет");
        addColor(colorMenu, "Синий",    Color.BLUE);
        addColor(colorMenu, "Красный",  Color.RED);
        addColor(colorMenu, "Чёрный",   Color.BLACK);

        // === Шрифт ===
        JMenu fontMenu = new JMenu("Шрифт");
        addFont(fontMenu, "Times New Roman");
        addFont(fontMenu, "MS Sans Serif");
        addFont(fontMenu, "Courier New");

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        setJMenuBar(menuBar);

        add(new JScrollPane(area), BorderLayout.CENTER);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void addColor(JMenu menu, String name, Color color) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(e -> area.setForeground(color));
        menu.add(item);
    }

    private void addFont(JMenu menu, String fontName) {
        JMenuItem item = new JMenuItem(fontName);
        item.addActionListener(e -> {
            Font current = area.getFont();
            area.setFont(new Font(fontName, current.getStyle(), current.getSize()));
        });
        menu.add(item);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextAreaMenu().setVisible(true));
    }
}