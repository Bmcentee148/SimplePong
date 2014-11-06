package gamePanelFramework;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Ball {
	private static final int SPEED = 2;
	private int x = 0;
	private int y = 0;
	private int xInc = SPEED, yInc = SPEED;
	
	public void paintComponent(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
	
	protected void move(int winWidth, int winHeight) {
		if(x + xInc < 0) {
			xInc = SPEED;
		}
		if(x + xInc > winWidth - 30) {
			xInc = -SPEED;
		}
		if(y + yInc < 0) {
			yInc = SPEED;
		}
		if(y + yInc > winHeight - 30) {
			yInc = -SPEED;
		}
		x = x + xInc;
		y = y + yInc;
	}
	
	public String toString() {
		return "X: " + x + "\nY: " + y;
	}
}
