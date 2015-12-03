package net.Wilckens.AnimalRace;

import java.util.Random;

public class Cat implements Animal{

	private int position = 0;
	private String name;
	
	public Cat (String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void advance()
	{
		Random rand = new Random();
	    position += rand.nextInt(3);
	}
	
	public int getPosition()
	{
		return position;
	}
}
