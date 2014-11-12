package gamePanelFramework;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Racquet {
	public static final int SPEED = 2;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	private int xPos = 0;
	private int yPos = 0;
	private int xInc = 0;
	
	
	public void paintComponent(Graphics g) {
		g.fillRect(xPos,yPos, 60, 10);
	}
	
	protected void move(int screenWidth, int screenHeight) {
		if(xPos + xInc > 0 && xPos + xInc < screenWidth - WIDTH) { 
			xPos += xInc;
		}
		yPos = screenHeight - HEIGHT; //place at bottom of screen
	}
	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xInc = -SPEED;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			xInc = SPEED;
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		xInc = 0;
	}
}
