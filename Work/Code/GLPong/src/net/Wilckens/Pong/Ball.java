package net.Wilckens.Pong;

import net.kerfuffle.Utilities.*;

public class Ball {

	private float xVel, yVel;
	private Quad box;
	
	public Ball(float x, float y, float xVel, float yVel)
	{
		box.x = x;
		box.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void updatePos()
	{
		if (x <= 0)
		{
			xVel *= -1;
			yVel *= -1;
		}
		if (x >= Main.WIDTH)
		{
			xVel *= -1;
			yVel *= -1;
		}
		if (y <= 0)
		{
			xVel *= -1;
			yVel *= -1;
		}
		if (y >= Main.HEIGHT)
		{
			xVel *= -1;
			yVel *= -1;
		}
		
		x += xVel;
		y += yVel;
	}
	
	
	
}
