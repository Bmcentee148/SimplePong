package gamePanelFramework;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Ball {
	private static final int SPEED = 3;
	private static final int BALL_SIZE = 25;
	
	private int xPos = 0;
	private int yPos = 0;
	private int xInc = SPEED, yInc = SPEED;
	
	public void paintComponent(Graphics2D g) {
		g.fillOval(xPos, yPos, BALL_SIZE, BALL_SIZE);
	}
	
	protected void move(int winWidth, int winHeight) {
		if(xPos + xInc < 0) {
			xInc = SPEED;
		}
		if(xPos + xInc > winWidth - BALL_SIZE) {
			xInc = -SPEED;
		}
		if(yPos + yInc < 0) {
			yInc = SPEED;
		}
		if(yPos + yInc > winHeight - BALL_SIZE) {
			yInc = -SPEED;
		}
		xPos = xPos + xInc;
		yPos = yPos + yInc;
	}
	
	public String toString() {
		return "xPos: " + xPos + "\nY: " + yPos;
	}
}
