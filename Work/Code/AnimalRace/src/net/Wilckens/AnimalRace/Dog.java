package net.Wilckens.AnimalRace;

public class Dog implements Animal{

	private int position = 0;
	
	public String getName()
	{
		return "Generic Dog";
	}
	
	public void advance()
	{
		position++;
	}
	
	public int getPosition()
	{
		return position;
	}
	
}
