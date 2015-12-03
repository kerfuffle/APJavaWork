package net.Wilckens.Pong;

import java.awt.Color;
import java.awt.Graphics;

import static java.awt.event.KeyEvent.*;

public class Player {

	public int x, y, w, h, speed = 5;
	private int upKey, downKey, leftKey, rightKey;
	
	public boolean twoDimen = false;
	
	public Player(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void draw(Graphics g, Color c)
	{
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	
	public void checkMovement(KeyTracker keys)
	{
		if (keys.isKeyDown(upKey))
		{
			y -= speed;
		}
		if (keys.isKeyDown(downKey))
		{
			y += speed;
		}
		
		if (twoDimen)
		{
			if (keys.isKeyDown(leftKey))
			{
				x -= speed;
			}
			if (keys.isKeyDown(rightKey))
			{
				x += speed;
			}
		}
	}
	
	public void setKeys(int up, int down, int left, int right)
	{
		upKey = up;
		downKey = down;
		leftKey = left;
		rightKey = right;
	}
	
}
