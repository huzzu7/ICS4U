import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PointPlotter extends JPanel {

    private Point trees[] = new Point[10];

    public PointPlotter() {
        Random random = new Random();
        trees[0] = new Point (random.nextInt(30), random.nextInt(30));
        int counter = 1;

        while (counter < 10){
            Point pt = new Point (random.nextInt(30), random.nextInt(30));
            boolean valid = true; 
            for (Point location : trees) {
                if (location != null && pt.distance(location) < 3) {
                    valid = false; 
                    break;
                }
            }
            if (valid) {
                trees[counter] = pt;
                counter++;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);
        for (int i = 0; i <= 10; i++) {
            int x = 50 + i * (getWidth() - 100) / 10;
            g2d.drawLine(x, getHeight() - 50, x, getHeight() - 45);
            g2d.drawString(Integer.toString(i), x - 5, getHeight() - 30);
        }

        // Draw y-axis scale
        g2d.drawLine(50, 50, 50, getHeight() - 50);
        for (int i = 0; i <= 10; i++) {
            int y = getHeight() - 50 - i * (getHeight() - 100) / 10;
            g2d.drawLine(45, y, 50, y);
            g2d.drawString(Integer.toString(i), 20, y + 5);
        }
        // Draw points
        g2d.setColor(Color.RED);
        for (Point point : trees) {
            int x = (int) point.getX()*18+20;
            int y = (int) point.getY()*18-20;
            g2d.fillOval(x - 2, y - 2, 5, 5); // Adjust the size of the point as needed
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Point Plotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 620);
        frame.getContentPane().add(new PointPlotter());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
