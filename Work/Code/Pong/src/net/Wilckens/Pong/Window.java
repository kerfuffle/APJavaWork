package net.Wilckens.Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import static java.awt.event.KeyEvent.*;
import javax.swing.JFrame;

public class Window extends GameBase{

	static int WIDTH, HEIGHT;

	Player p1 = new Player(10, 100, 20, 100);
	Player p2 = new Player(WIDTH - 30, 100, 20, 100);
	Ball ball = new Ball((WIDTH/2) - (20), (HEIGHT/2) - 20, 3, 3);

	public Window(JFrame window)
	{
		super(window);


		//setLayout(new GridBagLayout());
		//setBackground(new Color(0, 0, 0, 0.01f));
		//setSize(width, height);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p1.setKeys(VK_W, VK_S, VK_A, VK_D);
		p2.setKeys(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT);
		

		start();
	}




	KeyTracker keys = new KeyTracker(this);

	public void update() 
	{
		if (keys.wasKeyPressed(VK_ESCAPE))
		{
			System.exit(0);
		}
		if (keys.isKeyDown(VK_2))
		{
			p1.twoDimen = !p1.twoDimen;
			p2.twoDimen = !p2.twoDimen;
			System.out.println("press");
		}
		
		p1.checkMovement(keys);
		p2.checkMovement(keys);
		
		ball.move();
		ball.checkLegalPos(p1, p2);
	}

	Rectangle rect = new Rectangle(400, 400, 100, 40);
	int i = 0;
	public void paintComponent(Graphics g)
	{
		p1.draw(g, Color.DARK_GRAY);
		p2.draw(g, Color.DARK_GRAY);
		ball.draw(g, Color.BLUE);
		
		g.fillOval(WIDTH/2, HEIGHT/2, 10, 10);
		g.drawLine(WIDTH/2, HEIGHT/2, rect.x, rect.y);
		
		Graphics2D g2d = (Graphics2D) g;
		
		//g2d.translate(WIDTH / 2, HEIGHT / 2);
		g2d.rotate(Math.toRadians(i), WIDTH/2, HEIGHT/2);
		//g2d.fillRect(x, y, w, h);
		g2d.fill(rect);
		i++;
	}



	public static void main(String[] args) 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = (int)screenSize.getWidth();
		HEIGHT = (int)screenSize.getHeight();

		JFrame mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		mainWindow.setUndecorated(true);
		mainWindow.setLocation(0, 0);
		mainWindow.setBackground(new Color(0, 0, 0, 0.01f));
		mainWindow.add(new Window(mainWindow));
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
