import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

class Main extends JFrame {

    public CheckersBoard board = new CheckersBoard();

    public Main() {
        super("Checkers");
        setSize(500, 530);
        setDefaultCloseOperation(3);
        setVisible(true);
    }


    public void paint(Graphics g) {
        Color[] boxCol = new Color[]{Color.lightGray, new Color(113, 56, 0)};
        Color[] pieceCol = new Color[]{Color.black, Color.red};
        g.setColor(new Color(214, 145, 75));
        g.fillRect(0, 0, 500, 530);

        for(int x = 50; x <= 400; x += 50) {
            for(int y = 50; y <= 400; y += 50) {
                int gx = x / 50 - 1;
                int gy = y / 50 - 1;
                int boxNum = (gx + gy) % 2;
                g.setColor(boxCol[boxNum]);
                g.fillRect(x, y + 30, 50, 50);
                int pieceNum = this.board.get(gx, gy);
                if (pieceNum > 0) {
                    g.setColor(pieceCol[pieceNum - 1]);
                    g.fillOval(x + 5, y + 35, 40, 40);
                }
            }
        }

    }

	public static void delay(long len) {
        try {
            Thread.sleep(len);
        } catch (InterruptedException var3) {
            System.out.println(var3);
        }

    }

	public void move(int x1, int y1, int x2, int y2){
        delay(500L);
        board.move(x1, y1, x2, y2);
        repaint();
        board.display();
	}

    public static void main(String[] args) {
        Main frame = new Main();
        frame.move(2,2,3,3);
        frame.move(3,5,4,4);
        frame.move(4,4,3,3);
        frame.move(4,4,4,0);
        // frame.move(3, 5, 2, 4);
        // frame.move(1, 3, 3, 5);
    }
}