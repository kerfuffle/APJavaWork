package net.wilckens.maze;

public class Connections {

	private boolean up, down, left, right;
	
	public boolean getUp()
	{
		if (up)
		{
			return true;
		}
		return false;
	}
	public boolean getDown()
	{
		if (down)
		{
			return true;
		}
		return false;
	}
	public boolean getLeft()
	{
		if (left)
		{
			return true;
		}
		return false;
	}
	public boolean getRight()
	{
		if (right)
		{
			return true;
		}
		return false;
	}
	
	public void setUp(boolean b)
	{
		up = b;
	}
	public void setDown(boolean b)
	{
		down = b;
	}
	public void setLeft(boolean b)
	{
		left = b;
	}
	public void setRight(boolean b)
	{
		right = b;
	}
	
}
