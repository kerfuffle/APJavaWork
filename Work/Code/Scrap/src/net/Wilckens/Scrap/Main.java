/**
 * Ryan Davis
 * Period 8
 */


package net.Wilckens.Scrap;



public class Main {

	
	public static void main (String args[])
	{
		Game game = new Game();
		game.play();
		System.out.println(game.getScore());
	}
	
	static class Game
	{
		private int score;
		
		public void play()
		{
			score = (int) (Math.random()*10000);
		}
		
		public int getScore()
		{
			return score;
		}
	}
	
}
