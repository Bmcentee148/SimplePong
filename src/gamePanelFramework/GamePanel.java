package gamePanelFramework;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	// game objects
	private Ball ball;
	private Racquet racquet;
	
	//only constructor
	public GamePanel() {
		
		ball = new Ball();
		racquet = new Racquet();
		
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				//DO NOTHING
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.KeyPressed(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.KeyReleased(e);
			}
		};
		
		this.addKeyListener(listener);
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // cleans the panel
		
		Graphics2D g2d = (Graphics2D)g.create();//create snapshot of Graphics obj
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON); //smooth graphics for ball
		
		ball.paintComponent(g2d); //paint ball on g2g
		
		racquet.paintComponent(g2d); //paint racquet on g2g
		
		g2d.dispose(); //dispose of currents Graphics obj

	}

	
	public void update() {
		ball.move(this.getWidth(), this.getHeight());
		racquet.move(this.getWidth(),this.getHeight()); 
	}
	
	//main Method
	public static void main(String[] args) { 
		//setup and add game panel
		JFrame mainFrame = new JFrame("Simple Pong");
		mainFrame.setSize(300, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gamePanel = new GamePanel();
		mainFrame.add(gamePanel);
		mainFrame.setVisible(true);
		
		//Continue to update status of the game until exit
		while (true) {
			try {
				gamePanel.update();
				gamePanel.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
				System.exit(1);
			}
		}//end while
	}//end main

}
