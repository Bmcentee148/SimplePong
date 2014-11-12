package gamePanelFramework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	
	public static final int SPEED = 3;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 10;
	
	private int xPos = 0;
	private int yPos = 0;
	private int xInc = 0;
	
	private GamePanel gamePanel;
	
	public Racquet(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void paintComponent(Graphics g) {
		
		g.fillRect(xPos,yPos, 60, 10);
	}
	
	protected void move() {
		
		if(xPos + xInc >= 0 && xPos + xInc <= gamePanel.getWidth() - WIDTH) { 
			xPos += xInc;
		}
		yPos = gamePanel.getHeight() - HEIGHT; //place at bottom of screen
	}
	
	public void KeyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) 
			xInc = -SPEED;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xInc = SPEED;
	}
	
	public void KeyReleased(KeyEvent e) {
		
		xInc = 0;
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(xPos,yPos,WIDTH,HEIGHT);
	}
	
	public int getTop() {
		
		return yPos;
	}
	
	@Override
	public String toString() {
		
		return "xPos:" + xPos + "\nyPos:" + yPos;
	}
}
