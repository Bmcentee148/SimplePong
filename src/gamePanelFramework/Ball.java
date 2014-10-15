package gamePanelFramework;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Ball {
	private int x = 0, y = 0;
	private int xInc = 1, yInc = 1;
	
	public void paint(Graphics2D g) {
		g.fillOval(x,y,30,30);
	}
	
	protected void move(int winWidth, int winHeight) {
		if(x + xInc < 0) {
			xInc = 1;
		}
		if(x + xInc > winWidth - 30) {
			xInc = -1;
		}
		if(y + yInc < 0) {
			yInc = 1;
		}
		if(y + yInc > winHeight - 30) {
			yInc = -1;
		}
		x = x + xInc;
		y = y + yInc;
	}
}
