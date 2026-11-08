import javax.swing.*;
import java.awt.*;

public class MilanRealMadrid extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";

    private final JLabel resultLabel  = new JLabel("Result: 0 X 0", JLabel.CENTER);
    private final JLabel scorerLabel  = new JLabel("Last Scorer: N/A", JLabel.CENTER);
    private final JLabel winnerLabel  = new JLabel("Winner: DRAW", JLabel.CENTER);

    public MilanRealMadrid() {
        super("AC Milan vs Real Madrid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 5, 5));

        JButton milanBtn  = new JButton("AC Milan");
        JButton madridBtn = new JButton("Real Madrid");

        milanBtn.addActionListener(e -> {
            milanScore++;
            lastScorer = "AC Milan";
            updateLabels();
        });
        madridBtn.addActionListener(e -> {
            madridScore++;
            lastScorer = "Real Madrid";
            updateLabels();
        });

        add(milanBtn);
        add(madridBtn);
        add(resultLabel);
        add(scorerLabel);
        add(winnerLabel);

        setSize(300, 250);
        setLocationRelativeTo(null);
    }

    private void updateLabels() {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        scorerLabel.setText("Last Scorer: " + lastScorer);
        if (milanScore > madridScore)      winnerLabel.setText("Winner: AC Milan");
        else if (madridScore > milanScore) winnerLabel.setText("Winner: Real Madrid");
        else                               winnerLabel.setText("Winner: DRAW");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MilanRealMadrid().setVisible(true));
    }
}