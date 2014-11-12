package gamePanelFramework;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.*;

public class Ball {
	
	private static final int SPEED = 3;
	private static final int DIAMETER = 25;
	
	private int xPos = 0;
	private int yPos = 0;
	private int xInc = SPEED;
	private	int yInc = SPEED;
	
	private GamePanel gamePanel;
	
	public Ball(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void paintComponent(Graphics2D g) {
		
		g.fillOval(xPos, yPos, DIAMETER, DIAMETER);
	}
	
	protected void move() {
		
		if(xPos + xInc < 0) {
			xInc = SPEED;
		}
		if(xPos + xInc > gamePanel.getWidth() - DIAMETER) {
			xInc = -SPEED;
		}
		if(yPos + yInc < 0) {
			yInc = SPEED;
		}
		if(yPos + yInc > gamePanel.getHeight() - DIAMETER) {
			gamePanel.gameOver();
		}
		if(collision()) {
			yInc = -SPEED;
			yPos = gamePanel.racquet.getTop() - DIAMETER;
		}
		
		xPos = xPos + xInc;
		yPos = yPos + yInc;
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(xPos, yPos, DIAMETER, DIAMETER);
	}
	
	public int getTop() {
		
		return yPos;
	}
	
	
	public boolean collision() {
		return this.gamePanel.ball.getBounds().intersects(this.gamePanel.racquet.getBounds());
	}
	public String toString() {
		
		return "xPos: " + xPos + "\nyPos: " + yPos;
	}
}
