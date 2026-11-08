import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Animation extends JPanel {
    private final List<Image> frames = new ArrayList<>();
    private int currentFrame = 0;

    public Animation(String[] paths) {
        for (String p : paths) {
            frames.add(new ImageIcon(p).getImage());
        }
        if (!frames.isEmpty()) {
            new Timer(100, e -> {            // 100 мс = 10 кадров/сек
                currentFrame = (currentFrame + 1) % frames.size();
                repaint();
            }).start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!frames.isEmpty()) {
            Image img = frames.get(currentFrame);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Пример: java Animation frame1.png frame2.png frame3.png
        JFrame frame = new JFrame("Анимация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Animation(args));
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}