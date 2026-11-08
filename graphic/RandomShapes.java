import javax.swing.*;
import java.awt.*;
import java.util.Random;

// === Абстрактная фигура ===
abstract class Shape {
    protected Color color;
    protected int x, y;
    protected int size;

    public Shape(Color color, int x, int y, int size) {
        this.color = color;
        this.x     = x;
        this.y     = y;
        this.size  = size;
    }

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    public Circle(Color c, int x, int y, int s) { super(c, x, y, s); }
    @Override public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}

class Square extends Shape {
    public Square(Color c, int x, int y, int s) { super(c, x, y, s); }
    @Override public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}

class Triangle extends Shape {
    public Triangle(Color c, int x, int y, int s) { super(c, x, y, s); }
    @Override public void draw(Graphics g) {
        g.setColor(color);
        int[] xs = {x + size / 2, x, x + size};
        int[] ys = {y, y + size, y + size};
        g.fillPolygon(xs, ys, 3);
    }
}

// === Окно ===
public class RandomShapes extends JPanel {
    private final Shape[] shapes = new Shape[20];

    public RandomShapes() {
        Random rnd = new Random();
        for (int i = 0; i < shapes.length; i++) {
            Color c = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            int x = rnd.nextInt(700);
            int y = rnd.nextInt(500);
            int s = 30 + rnd.nextInt(70);
            shapes[i] = switch (rnd.nextInt(3)) {
                case 0 -> new Circle(c, x, y, s);
                case 1 -> new Square(c, x, y, s);
                default -> new Triangle(c, x, y, s);
            };
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("20 случайных фигур");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomShapes());
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}