package net.Wilckens.Array2;

public class Main {

	public static void main(String args[])
	{
		ClientData clients[] = new ClientData[5];
		
		for (int i = 0; i < clients.length; i++)
		{
			clients[i] = new ClientData(i, "no name");
		}
		
		clients[0].setName("Bob");
		clients[1].setName("Billy");
		clients[2].setName("Bobbette");
		clients[3].setName("Bert");
		clients[4].setName("Wilckens");
		
		System.out.println("Client ID   Name");
		System.out.println("--------------------");
		
		for (int i = 0; i < clients.length; i++)
		{
			System.out.println(clients[i].getName() + "            " + clients[i].getId());
		}
		
	}
	
}
