import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private final JTextField display = new JTextField("0");
    private double current = 0;
    private String pendingOp = null;
    private boolean startNewNumber = true;

    public Calculator() {
        super("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : labels) {
            JButton btn = new JButton(label);
            btn.addActionListener(e -> onButton(label));
            buttons.add(btn);
        }

        add(buttons, BorderLayout.CENTER);
        setSize(300, 350);
        setLocationRelativeTo(null);
    }

    private void onButton(String label) {
        switch (label) {
            case "0","1","2","3","4","5","6","7","8","9","." -> {
                if (startNewNumber) {
                    display.setText(label.equals(".") ? "0." : label);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + label);
                }
            }
            case "+","-","*","/" -> {
                current = Double.parseDouble(display.getText());
                pendingOp = label;
                startNewNumber = true;
            }
            case "=" -> {
                double second = Double.parseDouble(display.getText());
                double result = switch (pendingOp == null ? "" : pendingOp) {
                    case "+" -> current + second;
                    case "-" -> current - second;
                    case "*" -> current * second;
                    case "/" -> second == 0 ? Double.NaN : current / second;
                    default  -> second;
                };
                display.setText(formatResult(result));
                pendingOp = null;
                startNewNumber = true;
            }
        }
    }

    private String formatResult(double r) {
        if (Double.isNaN(r)) return "Ошибка";
        if (r == (long) r)   return String.valueOf((long) r);
        return String.valueOf(r);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}