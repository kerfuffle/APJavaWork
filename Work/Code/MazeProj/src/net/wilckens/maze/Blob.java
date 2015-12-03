package net.wilckens.maze;

import java.util.ArrayList;

public class Blob {

	private int row, col;
	
	final private int boardRows, boardCols;
	
	ArrayList <Coord> coords = new ArrayList<Coord>();
	
	//Coord lastPos;
	Coord intersection;
	
	String lastMove;
	String shouldMove;
	
	public Blob(int startRow, int startCol, int boardRows, int boardCols)
	{
		row = startRow;
		col = startCol;
		
		this.boardRows = boardRows;
		this.boardCols = boardCols;
	}
	
	
	//if you follow the path in which you came, you will always end up back at an intersection
	/*public void goToPrevPos(Coord c, Board b)
	{
		Coord pos = new Coord(row, col);
		
		if (pos != c)
		{
			if (wasHere(c))
			{
				Coord down = new Coord(row + 1, col);
				Coord right = new Coord(row, col + 1);
				Coord up = new Coord(row - 1, col);
				Coord left = new Coord(row, col - 1);
				
				if (b.isConnectedDown(row, col) && lastPos != down)
				{
					lastPos = new Coord(row, col);
					setPosition(down);
				}
				else if (b.isConnectedRight(row, col) && lastPos != right)
				{
					lastPos = new Coord(row, col);
					setPosition(right);
				}
				else if (b.isConnectedUp(row, col) && lastPos != up)
				{
					lastPos = new Coord(row, col);
					setPosition(up);
				}
				else if (b.isConnectedLeft(row, col) && lastPos != left)
				{
					lastPos = new Coord(row, col);
					setPosition(left);
				}
			}
			else
			{
				setPosition(lastPos);
			}
			
		}
	}*/
	
	public Coord findNearestIntersection()
	{
		ArrayList <Coord> intersections = new ArrayList<Coord>();
		
		for (int i = 0; i < coords.size(); i++)
		{
			if (coords.get(i).isIntersection)
			{
				intersections.add(coords.get(i));
			}
		}
		
		if (intersections.size() > 0)
		{
			return intersections.get(intersections.size()-1);
		}
		return null;
	}
	
	
	
	public int getElement(Coord c)
	{
		for (int i = 0; i < coords.size(); i++)
		{
			if (coords.get(i) == c)
			{
				return i;
			}
		}
		return -1;
	}
	
	public boolean wasHere(Coord c)
	{
		for (int i = 0; i < coords.size(); i++)
		{
			if (c == coords.get(i))
			{
				return true;
			}
		}
		return false;
	}
	
	public Coord getPosition()
	{
		Coord ret = new Coord(row, col);
		return ret;
	}
	
	public void setPosition(Coord c)
	{
		row = c.getRow();
		col = c.getCol();
	}
	
	public Coord lastPos()
	{
		return coords.get(coords.size()-1);
	}
	
	public void left()
	{
		col--;
		setPosition(new Coord(row, col));
	}
	public void right()
	{
		col++;
		setPosition(new Coord(row, col));
	}
	public void up()
	{
		row--;
		setPosition(new Coord(row, col));
	}
	public void down()
	{
		row++;
		setPosition(new Coord(row, col));
	}
	
	
	
	void move(Connections c)
	{
		if (c.getRight())
		{
			
			right();
		}
		else if (c.getLeft())
		{
		
			left();
		}
		
		if (c.getDown())
		{
			
			down();
		}
		else if (c.getUp())
		{
			
			up();
		}
		
	}
}
