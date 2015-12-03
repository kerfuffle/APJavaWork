package net.wilckens.maze;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String args[])
	{
		/*Board board = new Board(5, 10);
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				board.mark(i, j, '.');
			}
		}
		
		board.mark(0, 1, 'X');
		board.mark(1, 2, 'X');
		board.mark(2, 3, 'X');
		board.mark(1, 4, 'X');
		board.mark(0, 5, 'X');
		board.mark(1, 6, 'Y');
		board.mark(2, 7, 'Y');
		board.mark(3, 8, 'Y');
		board.mark(2, 9, 'Y');
		
		char map[][] = generateRandomPath(10, 10);
		
		System.out.println(board.toString());*/
		
		//char map[][] = generateRandomPath(10, 10);
		
		//System.out.println(getMap(map, 10, 10));
		
		Board b = new Board(40, 40);
		
		for (int i = 0; i < 10; i++)
		{
			b.connect(0, i, 0, i+1);
		}
		for (int j = 0; j < 10; j++)
		{
			b.connect(j, 9, j+1, 9);
		}
		for (int j = 0; j < 10; j++)
		{
			b.connect(j, 14, j+1, 14);
		}
		for (int i = 10; i < 20; i++)
		{
			b.connect(10, i, 10, i+1);
		}
		
		//System.out.println(b.toString());
		
		//System.out.println(b.inFile("J:/Wilckens Java/AP Java/Maze-9-23-15.txt"));
		
		new MazeViewer(b).openWindow();
	}
	
	static public String getMap(char marks[][], int rows, int cols)
	{
		String ret = "";

		ArrayList <Character> str = new ArrayList<Character>();

		for (int i = 0 ; i < rows; i++)
		{
			for (int j = 0;  j < cols; j++)
			{
				str.add(marks[i][j]);
			}
			str.add('\n');
		}

		ret = charListToString(str);
		
		return ret;
	}
	
	static public String charListToString(ArrayList <Character> str)
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
	
	static public char[][] generateRandomPath(int rows, int cols)
	{
		char ret[][] = new char[rows][cols];
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				ret[i][j] = ' ';
			}
		}
		
		Random rand = new Random();
		int direction = rand.nextInt(4);		//0-up, 1-down, 2-left, 3-right
		
		int posX = 0, posY = 0, prevX = 0, prevY = 0;
		
		while (posX < cols-1 || posY < rows-1)
		{
			
			
			if (posX == 0 && direction == 2)
			{
				direction =  rand.nextInt(4);
				continue;
			}
			if (posY == 0 && direction == 1)
			{
				direction =  rand.nextInt(4);
				continue;
			}
			
			if (direction == 0)
			{
				prevX = posX;
				prevY = posY;
				
				if (posY < rows-1)
				{
					posY += 1;
				}
				
				System.out.println(posY + ", " + posX);
				ret[posY][posX] = 'X';
			}
			else if (direction == 1)
			{
				prevX = posX;
				prevY = posY;
				
				if (posY > 0)
				{
					posY -= 1;
				}

				ret[posY][posX] = 'X';
			}
			else if (direction == 2)
			{
				prevX = posX;
				prevY = posY;
				
				if (posX > 0)
				{
					posX -= 1;
				}
				
				ret[posY][posX] = 'X';
			}
			else if (direction == 3)
			{
				prevX = posX;
				prevY = posY;
				
				if (posX < cols-1)
				{
					posX += 1;
				}
				
				ret[posY][posX] = 'X';
			}
			
			/*if (posX == cols && direction == 3)	//finish maze
			{
				break;
			}
			if (posY == rows && direction == 1)
			{
				break;
			}*/
			
			direction =  rand.nextInt(4);
		}
		
		return ret;
	}
	
}
