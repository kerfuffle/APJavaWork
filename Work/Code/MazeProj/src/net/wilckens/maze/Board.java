package net.wilckens.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Board {

	private int rows = 0, columns = 0;

	private char marks[][]; 

	private char board[][];

	private boolean connectedRight[][], connectedDown[][];

	public Board(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;

		board = new char[rows][columns];
		
		connectedRight = new boolean[rows][columns];
		connectedDown = new boolean[rows][columns];

		marks = new char[rows][columns];
		clear();
		
		for (int i = 0; i < rows; i++)
		{
			connectedRight[i][columns-1] = true;
		}
		for (int j = 0; j < columns; j++)
		{
			connectedDown[rows-1][j] = true;
		}
		

	}

	public boolean connect(int row1, int col1, int row2, int col2)
	{
		if (col2 == (col1+1))
		{
			connectedRight[row1][col1] = true;
			return true;
		}
		else if (row2 == (row1+1))
		{
			connectedDown[row1][col1] = true;
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
	public boolean isIntersection(Coord c)
	{
		String temp[] = findConnections(c);
		int count = 0;
		for (int i = 0; i < temp.length; i++)
		{
			if (temp[i] != "no")
			{
				count++;
			}
		}
		
		if (count > 3)
		{
			return true;
		}
		
		return false;
	}
	
	public String[] findConnections(Coord c)
	{
		String temp[] = new String[4];
		
		if (isConnectedDown(c.getRow(), c.getCol()))
		{
			temp[0] = "down";
		}
		else
		{
			temp[0] = "no";
		}
		
		if (isConnectedRight(c.getRow(), c.getCol()))
		{
			temp[1] = "right";
		}
		else
		{
			temp[1] = "no";
		}
		
		if (isConnectedUp(c.getRow(), c.getCol()))
		{
			temp[2] = "up";
		}
		else
		{
			temp[2] = "no";
		}
		
		if (isConnectedLeft(c.getRow(), c.getCol()))
		{
			temp[3] = "left";
		}
		else
		{
			temp[3] = "no";
		}
		
		return temp;
	}
	
	public boolean isConnected(int row1, int col1, int row2, int col2)		//return true if both connected or just one?
	{

		if (connectedDown[row1][col1] && row2 == (row1+1))
		{
			return true;
		}
		if (connectedRight[row1][col1] && col2 == (col1+1))
		{
			return true;
		}

		return false;
	}

	public char[][] generateRandomPath(int rows, int cols)
	{
		char ret[][] = new char[rows][cols];

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				marks[i][j] = ' ';
			}
		}

		Random rand = new Random();
		int direction = rand.nextInt(4);		//0-up, 1-down, 2-left, 3-right

		int posX = 0, posY = 0, prevX = 0, prevY = 0;

		while(posX < cols || posY < rows)
		{
			if (posX == 0 && direction == 2)
			{
				direction =  rand.nextInt(4);
			}
			if (posY == 0 && direction == 0)
			{
				direction =  rand.nextInt(4);
			}

			if (direction == 0)
			{
				prevX = posX;
				prevY = posY;

				posY += 1;

				ret[posX][posY] = 'X';
			}
			if (direction == 1)
			{
				prevX = posX;
				prevY = posY;

				posY -= 1;

				ret[posX][posY] = 'X';
			}
			if (direction == 2)
			{
				prevX = posX;
				prevY = posY;

				posX -= 1;

				ret[posX][posY] = 'X';
			}
			if (direction == 3)
			{
				prevX = posX;
				prevY = posY;

				posX += 1;

				ret[posX][posY] = 'X';
			}

			/*if (posX == cols && direction == 3)	//finish maze
			{
				break;
			}
			if (posY == rows && direction == 1)
			{
				break;
			}*/
		}

		return ret;
	}

	private int getPlaceIn1DArray(int row, int col)
	{
		int ret = -1;

		ret = (rows*row*2) + (col*2);

		return ret;
	}

	private int getPlaceBelow(int pos)
	{
		int ret = -1;

		ret = pos + columns*2;

		return ret;
	}

	private String array2DtoString(char in[][])
	{	
		ArrayList <Character> ret = new ArrayList<Character>();
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				ret.add(in[i][j]);
				if (j == columns-1)
				{
					ret.add('\n');
				}
			}
		}

		return charListToString(ret);
	}

	private boolean isEven(int i)
	{
		if (i%2 == 0)
		{
			return true;
		}
		return false;
	}

	private String visualizeMap()
	{
		//ArrayList <Character> fin = new ArrayList<Character>();

		//char temp[][] = new char[rows][columns*2];
		char temp[][] = new char[rows][columns];

		for (int i = 0 ; i < rows; i++)
		{
			for (int j = 0 ; j < columns; j ++)
			{
				temp[i][j] = ' ';
			}
		}

		for (int k = 0 ; k < rows; k++)
		{
			for (int l = 0 ; l < columns; l++)
			{
				if (connectedDown[k][l])
				{
					temp[k][l] = ' ';
				}
				else
				{
					temp[k][l] = '_';		//¯
				}

			}
		}


		for (int m = 0; m < rows; m++)
		{
			for (int n = 0; n < columns; n++)
			{
				if (connectedRight[m][n])
				{
					temp[m][n] = ' ';
				}
				/*else
				{
					temp[m][(n*2) + 1] = '|';
				}*/


			}

		}




		/*for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				fin.add(' ');
				fin.add(' ');
			}
			fin.add('\n');
			for (int j = 0; j < columns; j++)
			{
				fin.add(' ');
				fin.add(' ');
			}
			fin.add('\n');
		}

		for (int y = 0; y < rows; y++)
		{
			for (int x = 0; x < columns; x++)
			{
				if (connectedDown[y][x])//TODO 
				{
					//System.out.println(getPlaceBelow(getPlaceIn1DArray(y, x)));
					fin.set(getPlaceBelow(getPlaceIn1DArray(y, x)), '_');
				}
				if (connectedRight[y][x])
				{
					fin.set(getPlaceIn1DArray(y, x) + 1, '|');  
				}
			}
		}*/

		return array2DtoString(temp);
	}

	public void outFile(String str, String name)
	{	
		PrintWriter out = null;
		try
		{
			out = new PrintWriter (new FileWriter(name));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == '\n')
			{
				out.println();
			}
			else
			{
				out.print(str.charAt(i));
			}
		}
		out.close();
	}

	private char[][] stringTo2DArray(String str)
	{
		String line[] = str.split("\n");

		char ret[][] = new char[line.length][line[0].length()];

		for (int i = 0; i < line.length; i++)
		{
			for (int j = 0; j < line[0].length(); i++)
			{
				ret[i][j] = line[i].charAt(j);
			}
		}

		return ret;
	}

	/*public boolean isConnectedDown(int row, int col)
	{
		if (row == rows-1)
		{
			return false;
		}
		if (board[row][col] == ' ' && board[row+1][col] == ' ')
		{
			return true;
		}
		return false;
	}*/
	
	public boolean isConnectedDown(int row, int col)
	{
		if (row == rows-1)
		{
			return false;
		}
		if (connectedDown[row][col])
		{
			return true;
		}
		return false;
	}
	
	/*private boolean isConnectedRight(int row, int col)
	{
		if (col == columns-1)
		{
			return false;
		}
		if (board[row][col] == ' ' && board[row][col+1] == ' ')
		{
			return true;
		}
		return false;
	}*/
	
	public boolean isConnectedRight(int row, int col)
	{
		if (col == columns-1)
		{
			return false;
		}
		if (connectedRight[row][col])
		{
			return true;
		}
		return false;
	}
	
	/*private boolean isConnectedLeft(int row, int col)
	{
		if (col == 0)
		{
			return false;
		}
		if (board[row][col] == ' ' && board[row][col-1] == ' ')
		{
			return true;
		}
		return false;
	}*/
	
	public boolean isConnectedLeft(int row, int col)
	{
		if (col == 0)
		{
			return false;
		}
		if (connectedRight[row][col-1])
		{
			return true;
		}
		return false;
	}
	
	/*private boolean isConnectedUp(int row, int col)
	{
		if (row == 0)
		{
			return false;
		}
		if (board[row][col] == ' ' && board[row+1][col] == ' ')
		{
			return true;
		}
		return false;
	}*/

	public boolean isConnectedUp(int row, int col)
	{
		if (row == 0)
		{
			return false;
		}
		if (connectedDown[row-1][col])
		{
			return true;
		}
		return false;
	}
	
	public boolean getConnectedRight(int row, int col)
	{
		if (connectedRight[row][col])
		{
			return true;
		}
		return false;
	}
	public boolean getConnectedDown(int row, int col)
	{
		if (connectedDown[row][col])
		{
			return true;
		}
		return false;
	}
	
	public Connections getConnections(Coord coords)
	{
		Connections ret = new Connections();
		
		if (isConnectedUp(coords.getRow(), coords.getCol()))
		{
			ret.setUp(true);
		}
		if (isConnectedDown(coords.getRow(), coords.getCol()))
		{
			ret.setDown(true);
		}
		if (isConnectedLeft(coords.getRow(), coords.getCol()))
		{
			ret.setLeft(true);
		}
		if (isConnectedRight(coords.getRow(), coords.getCol()))
		{
			ret.setRight(true);
		}
		
		return ret;
	}
	
	private void makeBoardFromFile(String name)
	{
		String temp = inFile(name);

		int rows, columns;

		String line[] = temp.split("\n");

		String spRows[] = line[0].split(": ");
		String sRows = spRows[1];
		rows = Integer.parseInt(sRows);
		String spColumns[] = line[1].split(": ");
		String sColumns = spColumns[1];
		columns = Integer.parseInt(sColumns);

		String toConvert = "";
		
		for (int c = 2; c < line.length; c++)
		{
			toConvert += line[c];
		}
		
		board = stringTo2DArray(toConvert);

		connectedDown = new boolean[rows][columns];
		connectedRight = new boolean[rows][columns];

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (isConnectedDown(i, j))
				{
					connectedDown[i][j] = true;
				}
				if (isConnectedRight(i, j))
				{
					connectedRight[i][j] = true;
				}
			}
		}

	}

	public String inFile(String name)
	{
		ArrayList<Character> c = new ArrayList<Character>();
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(name));
			int r;
			while((r = in.read()) != -1)
			{
				c.add((char) r);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		String ret = charListToString(c);
		//String fix[] = ret.split("null");

		return ret;//fix[1];
	}

	public String toString()
	{
		String ret = "columns: " + columns + " rows: " + rows + "\n";

		ret += visualizeMap();	//TODO

		return ret;
	}

	public String charListToString(ArrayList <Character> str)
	{
		String ret = "";

		//char temp[] = new char[str.size()];

		for (int i = 0 ; i < str.size(); i++)
		{
			ret += str.get(i);
			//temp[i] = str.get(i);
		}

		//ret = new String(temp);

		return ret;
	}

	public String getMap()
	{
		String ret = "";

		ArrayList <Character> str = new ArrayList<Character>();

		for (int i = 0 ; i < rows; i++)
		{
			for (int j = 0;  j < columns; j++)
			{
				str.add(marks[i][j]);
			}
			str.add('\n');
		}

		ret = charListToString(str);

		return ret;
	}

	public Coord chooseRandomUnmarkedSquare()
	{
		Random rand = new Random();

		ArrayList <Coord> unmarked = new ArrayList<Coord>();

		for (int i = 0; i < rows; i ++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (marks[i][j] == ' ')
				{
					Coord temp = new Coord(i, j);
					unmarked.add(temp);
				}
			}
		}

		int num = rand.nextInt(unmarked.size());

		return unmarked.get(num);
	}

	public int countEmptyCells()
	{
		int count = 0;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (marks[i][j] == ' ')
				{
					count++;
				}
			}
		}
		return count;
	}

	public char readMark(int row, int col)
	{
		return marks[row][col];
	}

	public void mark(int row, int col, char c)
	{
		marks[row][col] = c;
	}

	public int getRows()
	{
		return rows;
	}

	public int getColumns()
	{
		return columns;
	}

	public void clear()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				marks[i][j] = ' ';
			}
		}
	}

}
