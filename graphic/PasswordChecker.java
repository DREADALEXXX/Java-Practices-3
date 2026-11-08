import javax.swing.*;
import java.awt.*;

public class PasswordChecker extends JFrame {

    public PasswordChecker() {
        super("Password application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Service:"));
        add(new JTextField(20));

        add(new JLabel("User name:"));
        add(new JTextField(20));

        add(new JLabel("Password:"));
        add(new JPasswordField(20));

        setSize(400, 160);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordChecker().setVisible(true));
    }
}