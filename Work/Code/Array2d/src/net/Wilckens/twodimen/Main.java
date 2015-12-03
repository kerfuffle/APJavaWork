package net.Wilckens.twodimen;

import java.util.Scanner;

public class Main {

	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Gimmie a number: ");
		int num = in.nextInt();
		
		if (num == -1)
		{
			System.exit(0);
		}
		
		int ar[][] = new int[8][8];
		int my[][] = new int [20][30];
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				my[i][j] = i * j;
			}
		}
		
		findNum(my, num);
		
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				ar[i][j] = i + j;
				//System.out.print(ar[i][j] + " ");
			}
			//System.out.println();
		}
	}
	
	
	static void findNum(int array[][], int num)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				if (array[i][j] == num)
				{
					System.out.println("Found in Row: " + i + ", Column: " + j);
					return;
				}
			}
		}
		
		System.out.println("Not found.");
	}
	
}
