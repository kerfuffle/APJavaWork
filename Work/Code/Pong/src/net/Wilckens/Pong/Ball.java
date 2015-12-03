package net.Wilckens.Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public int x, y, xVel, yVel, w = 20, h = 20;
	
	public Ball(int x, int y, int xVel, int yVel)
	{
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void move()
	{
		x += xVel;
		y += yVel;
	}
	
	public void checkLegalPos(Player p1, Player p2)
	{
		if (x <= 0)
		{
			xVel *= -1;
		}
		if (x >= Window.WIDTH - w)
		{
			xVel *= -1;
		}
		if (y <= 0)
		{
			yVel *= -1;
		}
		if (y >= Window.HEIGHT - h)
		{
			yVel *= -1;
		}
		
		if (Util.hitLeft(p1, this))
		{
			xVel *= -1;
		}
		else if (Util.hitRight(p1, this))
		{
			xVel *= -1;
		}
		else if (Util.hitUp(p1, this))
		{
			yVel *= -1;
		}
		else if (Util.hitDown(p1, this))
		{
			yVel *= -1;
		}
		
		if (Util.hitLeft(p2, this))
		{
			xVel *= -1;
		}
		else if (Util.hitRight(p2, this))
		{
			xVel *= -1;
		}
		else if (Util.hitUp(p2, this))
		{
			yVel *= -1;
		}
		else if (Util.hitDown(p2, this))
		{
			yVel *= -1;
		}
	}
	
	public void draw(Graphics g, Color c)
	{
		g.setColor(c);
		g.fillOval(x, y, w, h);
	}
	
}
