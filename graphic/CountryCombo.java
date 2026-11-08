import javax.swing.*;
import java.awt.*;

public class CountryCombo extends JFrame {
    private final JLabel info = new JLabel("Выберите страну", JLabel.CENTER);

    public CountryCombo() {
        super("Hello Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        String[] countries = {"Australia", "China", "England", "Russia"};
        JComboBox<String> combo = new JComboBox<>(countries);
        combo.addActionListener(e -> {
            String sel = (String) combo.getSelectedItem();
            info.setText(switch (sel) {
                case "Australia" -> "Столица: Канберра, континент: Австралия";
                case "China"     -> "Столица: Пекин, континент: Азия";
                case "England"   -> "Столица: Лондон, континент: Европа";
                case "Russia"    -> "Столица: Москва, континент: Евразия";
                default          -> "?";
            });
        });

        add(combo, BorderLayout.NORTH);
        add(info,  BorderLayout.CENTER);
        setSize(350, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryCombo().setVisible(true));
    }
}