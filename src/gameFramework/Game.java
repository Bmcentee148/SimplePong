package gameFramework;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.fillOval(0,0,30,30);
		g2d.drawOval(0,50,30,30);
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
		
	}
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Simple Pong");
		mainFrame.setSize(400,400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(new Game());
		mainFrame.setVisible(true);

	}

}
