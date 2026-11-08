import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GuessGame extends JFrame {
    private final int secret = new Random().nextInt(21);   // 0..20
    private int attempts = 0;

    private final JTextField input = new JTextField(10);
    private final JButton guessBtn = new JButton("Угадать");
    private final JLabel hint = new JLabel("Введите число 0–20", JLabel.CENTER);

    public GuessGame() {
        super("Угадай число");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 5, 5));

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Число:"));
        inputPanel.add(input);
        inputPanel.add(guessBtn);

        guessBtn.addActionListener(e -> onGuess());

        add(inputPanel);
        add(hint);
        setSize(350, 180);
        setLocationRelativeTo(null);
    }

    private void onGuess() {
        try {
            int user = Integer.parseInt(input.getText().trim());
            if (user < 0 || user > 20) {
                hint.setText("Число должно быть от 0 до 20");
                return;
            }
            attempts++;

            if (user == secret) {
                JOptionPane.showMessageDialog(this, "Вы угадали! Попыток: " + attempts);
                System.exit(0);
            } else if (attempts >= 3) {
                JOptionPane.showMessageDialog(this,
                        "Не угадали. Было загадано: " + secret);
                System.exit(0);
            } else {
                hint.setText(user < secret ? "Загаданное число БОЛЬШЕ" : "Загаданное число МЕНЬШЕ");
            }
        } catch (NumberFormatException ex) {
            hint.setText("Введите корректное целое число");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessGame().setVisible(true));
    }
}