package net.Wilckens.AnimalRace;

public class Horse implements Animal{

	private int position = 0;
	private String name;
	private int count = 1;
	
	
	public Horse(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void advance()
	{
		if (count < 3)
		{
			position += 3;
		}
		else
		{
			position -= 3;
			count = 0;
		}
		count++;
	}
	
	public int getPosition()
	{
		return position;
	}
	
}
