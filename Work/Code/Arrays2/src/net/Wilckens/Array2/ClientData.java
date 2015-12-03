package net.Wilckens.Array2;

public class ClientData {

	private int id;
	private String name;
	
	public ClientData(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	
}
