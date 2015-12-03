package net.wilckens.maze;

public class Coord {

	private int row, column;
	
	public boolean wasHere;
	public boolean isIntersection;
	public boolean deadEnd;
	
	boolean canDown, canRight, canUp, canLeft;
	
	public Coord(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return column;
	}
	
	public void checkIntersection(Board b)
	{
		if (b.isConnectedDown(row, column))
		{
			canDown = true;
		}
		if (b.isConnectedRight(row, column))
		{
			canRight = true;
		}
		if (b.isConnectedUp(row, column))
		{
			canUp = true;
		}
		if (b.isConnectedLeft(row, column))
		{
			canLeft = true;
		}
		
		int count = 0;
		if (canDown)
		{
			count++;
		}
		if (canRight)
		{
			count++;
		}
		if (canUp)
		{
			count++;
		}
		if (canLeft)
		{
			count ++;
		}
		
		if (count == 1)
		{
			deadEnd = true;
		}
		if (count > 2)
		{
			isIntersection = true;
		}
	}
	
}
