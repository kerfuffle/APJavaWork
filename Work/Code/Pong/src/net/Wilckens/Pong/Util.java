package net.Wilckens.Pong;

public class Util {

	public static boolean checkHit(Player b, Ball p)
	{
		if ((p.x > b.x && p.x < b.x + b.w) || (p.x + p.w > b.x && p.x + p.w < b.x + b.w))	//check X
		{
			if ((p.y > b.y && p.y < b.y + b.h) || (p.y + p.h > b.y && p.y + p.h < b.y + b.h))	//check Y
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean hitRight(Player p, Ball b)
	{
		if (b.x <= p.x+p.w && b.x >= p.x &&(b.y <= p.y+p.h && b.y+b.h >= p.y))
		{
			return true;
		}
		return false;
	}
	public static boolean hitLeft(Player p, Ball b)
	{
		if (b.x+b.w >= p.x && b.x+b.w <= p.x &&(b.y <= p.y+p.h && b.y+b.h >= p.y))
		{
			return true;
		}
		return false;
	}
	public static boolean hitUp(Player p, Ball b)
	{
		if (b.y+b.h >= p.y && b.y+b.h <= p.y && (b.x <= p.x+p.w && b.x >= p.x))
		{
			return true;
		}
		return false;
	}
	public static boolean hitDown(Player p, Ball b)
	{
		if (b.y <= p.y+p.h && b.y >= p.y &&((b.x <= p.x+p.w && b.x >= p.x)))
		{
			return true;
		}
		return false;
	}
}
