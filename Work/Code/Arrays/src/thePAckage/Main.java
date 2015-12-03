package thePAckage;

/**
 * @author Ryan Davis
 * @period 8
 */

public class Main {

	public static void main(String args[])
	{
		int cards1[] = {1, 2, 3, 4, 5};
		System.out.println("cards1 has a pair?");
		if (hasPair(cards1))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
		int cards2[] = {13, 5, 2, 4, 2, 12, 5};
		System.out.println("cards2 has a pair?");
		if (hasPair(cards2))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
	
	static boolean hasPair(int pair[])
	{
		
		for (int i = 0; i < pair.length; i++)
		{
			for (int j = i+1; j < pair.length; j++)
			{
				if (pair[i] == pair[j])
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	static void printAll(int cards[])
	{
		for (int i = 0; i < cards.length; i++)
		{
			System.out.println(cards[i]);
		}
	}
	
	static boolean hasTwo(int cards[])
	{
		for (int i = 0; i < cards.length; i++)
		{
			if (cards[i] == 2)
			{
				return true;
			}
		}
		return false;
	}
	
	
}
