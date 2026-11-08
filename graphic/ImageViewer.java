import javax.swing.*;
import java.awt.*;
public class ImageViewer extends JPanel {
    private final Image image;

    public ImageViewer(String path) {
        this.image = new ImageIcon(path).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите путь к картинке: java ImageViewer <путь>");
            return;
        }
        JFrame frame = new JFrame("Просмотр: " + args[0]);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ImageViewer(args[0]));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}