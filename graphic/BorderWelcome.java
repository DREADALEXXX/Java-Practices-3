import javax.swing.*;
import java.awt.*;

public class BorderWelcome extends JFrame {

    public BorderWelcome() {
        super("BorderLayout — области");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        add(makeArea("CENTER", "ЦАО"),  BorderLayout.CENTER);
        add(makeArea("WEST",   "ЗАО"),  BorderLayout.WEST);
        add(makeArea("SOUTH",  "ЮАО"),  BorderLayout.SOUTH);
        add(makeArea("NORTH",  "САО"),  BorderLayout.NORTH);
        add(makeArea("EAST",   "ВАО"),  BorderLayout.EAST);

        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private JPanel makeArea(String name, String district) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(name));
        panel.setBackground(new Color(230, 240, 255));

        // Слушатель: мышь ВХОДИТ в область → показываем диалог
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                JOptionPane.showMessageDialog(
                        BorderWelcome.this,
                        "Добро пожаловать в " + district,
                        name,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BorderWelcome().setVisible(true));
    }
}