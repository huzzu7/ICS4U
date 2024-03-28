package Swing;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameZero extends JFrame{
	GamePanel game= new GamePanel();
		
    public GameZero() {
		super("Basic Game Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(game);
		pack();  // set the size of my Frame exactly big enough to hold the contents
		setVisible(true);
    }    
    public static void main(String[] arguments) {
		new GameZero();		
    }
}

// Main game logic
class GamePanel extends JPanel implements ActionListener, KeyListener{
    Timer timer;
    int boxx= 0;
    boolean []keys;
	public GamePanel(){
		setPreferredSize(new Dimension(800, 600));
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        keys = new boolean[1000];
    }

    public void move() {
        if (keys[KeyEvent.VK_A]){
            boxx-=5;
        }
        if (keys[KeyEvent.VK_D]){
            boxx+=5;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()]= true;
    }

    @Override

    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

	@Override
	public void paint(Graphics g){
		g.setColor(new Color(111,222,111));
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.RED);
		g.fillRect(boxx,200,40,40);
    }

    public void actionPerformed(ActionEvent e){
        move();
        repaint();
    }
}