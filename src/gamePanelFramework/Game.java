package gamePanelFramework;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel{
		
	Ball gameBall = new Ball();
	public void paint(Graphics g) {
		super.paint(g); //cleans the panel
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
		gameBall.paint(g2d);
		
	}
	
	public void updateBall() {
		gameBall.move(this.getWidth(), this.getHeight());
	}
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Simple Pong");
		mainFrame.setSize(400,400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game gamePanel = new Game();
		mainFrame.add(gamePanel);
		mainFrame.setVisible(true);
		
		while(true) {
			try {
				gamePanel.updateBall();
				gamePanel.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
				System.exit(1);
			}
		}
		
	}

}
