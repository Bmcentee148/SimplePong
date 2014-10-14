package gamePanelFramework;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	int x, y = 0;
	
	private void moveBall() {
		x = x + 1;
		y = y + 1;
	}
	
	public void paint(Graphics g) {
		super.paint(g); //cleans the panel
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x,y,30,30);
		
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
				gamePanel.moveBall();
				gamePanel.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
				System.exit(1);
			}
		}
		
	}

}
