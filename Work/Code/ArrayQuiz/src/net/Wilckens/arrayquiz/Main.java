package net.Wilckens.arrayquiz;

/**
 * @author Ryan Davis
 * @period 8
 */


public class Main {

	public static void main(String args[])
	{
		int[][] sodukuBoard1 = {{ 3, 8, 1, 6, 5, 4, 7, 2, 9 },
								{ 5, 7, 5, 6, 3, 2, 8, 1, 8 },
								{ 2, 5, 6, 4, 5, 2, 5, 2, 5 },
								{ 2, 9, 3, 2, 1, 8, 1, 9, 1 },
								{ 9, 6, 9, 9, 6, 2, 6, 8, 1 },
								{ 8, 1, 5, 5, 3, 4, 5, 3, 5 },
								{ 6, 8, 4, 4, 1, 2, 7, 6, 7 },
								{ 4, 4, 3, 5, 3, 3, 8, 5, 7 },
								{ 9, 2, 8, 7, 4, 6, 2, 7, 1 }};
		
		
		for (int a = 0; a < 9; a++)
		{
			System.out.format("Row: %d, %b \n", a, checkRow(sodukuBoard1, a));
			System.out.format("Column: %d, %b \n", a, checkCol(sodukuBoard1, a));
			System.out.format("Block: %d, %b \n", a, checkBlock(sodukuBoard1, a));
			System.out.println();
		}
	}
	
	public static boolean checkBlock(int[][] board, int block)
	{
		int startRow = -1, endRow = -1, startCol = -1, endCol = -1;
		
		/**There is probably an easier way to do this...*/
	switch(block)
	{
	case 0:
		startRow = 0;
		endRow = 2;
		startCol = 0;
		endCol = 2;
		break;
	case 1:
		startRow = 3;
		endRow = 5;
		startCol = 0;
		endCol = 2;
		break;
	case 2:
		startRow = 6;
		endRow = 8;
		startCol = 0;
		endCol = 2;
		break;
	case 3:
		startRow = 0;
		endRow = 2;
		startCol = 3;
		endCol = 5;
		break;
	case 4:
		startRow = 3;
		endRow = 5;
		startCol = 3;
		endCol = 5;
		break;
	case 5:
		startRow = 6;
		endRow = 8;
		startCol = 3;
		endCol = 5;
		break;
	case 6:
		startRow = 0;
		endRow = 2;
		startCol = 6;
		endCol = 8;
		break;
	case 7:
		startRow = 3;
		endRow = 5;
		startCol = 6;
		endCol = 8;
		break;
	case 8:
		startRow = 6;
		endRow = 8;
		startCol = 6;
		endCol = 8;
		break;
	}
		
		boolean has[] = new boolean[9];
		for (int i = startRow; i <= endRow; i++)
		{
			for (int j = startCol; j <= endCol; j++)
			{
				for (int a = 1; a <= 9; a++)
				{
					if (board[i][j] == a)
					{
						has[a-1] = true;
					}
				}
			}
		}
		int count = 0;
		for (int h = 0; h < 9; h++)
		{
			if(has[h])
			{
				count++;
			}
		}
		if (count == 9)
		{
			return true;
		}
		return false;
	}
	
	public static boolean checkCol(int[][] board, int colIndex)
	{
		boolean has[] = new boolean[9];
		for (int i = 0; i < 9; i++)
		{
			for (int a = 1; a <= 9; a++)
			{
				if (board[i][colIndex] == a)
				{
					has[a-1] = true;
				}
			}
		}
		
		int count = 0;
		for (int h = 0; h < 9; h++)
		{
			if (has[h])
			{
				count++;
			}
		}
		
		if (count == 9)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean checkRow(int[][] board, int rowIndex)
	{
		boolean has[] = new boolean[9];
		for (int j = 0; j < 9; j++)
		{
			for (int i = 1; i <= 9; i++)
			{
				if (board[rowIndex][j] == i)
				{
					has[i-1] = true;
				}
			}
		}
		
		int count = 0;
		for (int h = 0; h < 9; h++)
		{
			if (has[h])
			{
				count++;
			}
		}
		
		if (count == 9)
		{
			return true;
		}
		
		return false;
	}
	
}
