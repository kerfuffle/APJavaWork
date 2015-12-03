package net.Wilckens.AnimalRace;

public class Turtle implements Animal{

	private int position = 0;
	private boolean justAdvanced = false;
	private String name;
	
	public Turtle(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void advance()
	{
		if (!justAdvanced)
		{
			position++;
		}
		justAdvanced = !justAdvanced;
	}
	
	public int getPosition()
	{
		return position;
	}
	
}
