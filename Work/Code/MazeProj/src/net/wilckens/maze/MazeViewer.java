package net.wilckens.maze;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import javax.swing.Timer;

public class MazeViewer extends JComponent implements ActionListener {

	final int width = 800, height = 600;
	private int counter = 0;
	private Board board;

	Timer timer = new Timer(1000/2, this);
	private Blob blob;

	public MazeViewer(Board b) 
	{
		board = b;

		timer.setInitialDelay(2000);
		timer.start();

		blob = new Blob(0, 0, b.getRows(),b.getColumns());

	}
	public void openWindow() 
	{
		JFrame mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(width, height));
		mainWindow.add(this);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

	public void newMove()
	{
		Coord blobPos = blob.getPosition();
		blobPos.checkIntersection(board);
		
		if (blobPos.deadEnd)
		{
			
			for (int i = blob.getElement(blobPos); i < blob.getElement(blob.findNearestIntersection()); i--)
			{
				blob.setPosition(blob.coords.get(i));
			}
		}
		
		if (blob.wasHere(blobPos))
		{
			
		}
		
		blob.coords.add(blobPos);
		
		if (board.isConnectedDown(blob.getPosition().getRow(), blob.getPosition().getCol()) && blobPos.getRow() != board.getRows())
		{
			if (blobPos.canDown)
			{
				Coord newPos = new Coord(blobPos.getRow()+1, blobPos.getCol());
				blob.lastMove = "down";
				blob.coords.add(newPos);
				blob.setPosition(newPos);
			}
			
		}
		else if (board.isConnectedRight(blob.getPosition().getRow(), blob.getPosition().getCol()) && blobPos.getRow() != board.getColumns())
		{
			Coord newPos = new Coord(blobPos.getRow(), blobPos.getCol()+1);
			blob.lastMove = "right";
			blob.coords.add(newPos);
			blob.setPosition(newPos);
		}
		else if (board.isConnectedUp(blob.getPosition().getRow(), blob.getPosition().getCol()) && blobPos.getRow() != 0)
		{
			Coord newPos = new Coord(blobPos.getRow()-1, blobPos.getCol());
			blob.lastMove = "up";
			blob.coords.add(newPos);
			blob.setPosition(newPos);
		}
		else if (board.isConnectedLeft(blob.getPosition().getRow(), blob.getPosition().getCol()) && blobPos.getRow() != 0)
		{
			Coord newPos = new Coord(blobPos.getRow(), blobPos.getCol()-1);
			blob.lastMove = "left";
			blob.coords.add(newPos);
			blob.setPosition(newPos);
			System.out.println("yes");
		}
	}
	
	/*public void moveBlob()
	{
		Coord blobPos = blob.getPosition();
		
		/*Connections connections = board.getConnections(blobPos);
		
		blob.move(connections);
		
		Coord newBlobPosition = blob.getPosition();
		if (!board.isConnected(blobPos.getRow(), blobPos.getCol(), newBlobPosition.getRow(), newBlobPosition.getCol()))
		{
			blob.setPosition(blobPos);
			System.out.format("%d, %d\n", blobPos.getRow(), blobPos.getCol());
		}

		//blob.printNotes();

		/*if (!board.isConnected(blobPos.getRow(), blobPos.getCol(), newBlobPos.getRow(), newBlobPos.getCol()))
		{
			blob.setPosition(blobPos);
		}

		System.out.format("%d, %d\n", blobPos.getRow(), blobPos.getCol());
*/
		
		
		// Priority: down, right, up, left
			
		
		
		
		/*if (board.isConnectedDown(blobPos.getRow(), blobPos.getCol()))
		{
			if (!blob.getLastMove().equals("down"))
			{
				blob.addNote("canDown");
			}
		}
		if (board.isConnectedRight(blobPos.getRow(), blobPos.getCol()+1))
		{
			if (!blob.getLastMove().equals("right"))
			{
				blob.addNote("canRight");
			}
		}
		if (board.isConnectedUp(blobPos.getRow(), blobPos.getCol()))
		{
			if (!blob.getLastMove().equals("down"))
			{
				blob.addNote("canUp");
			}
		}
		if (board.isConnectedLeft(blobPos.getRow(), blobPos.getCol()))
		{
			if (!blob.getLastMove().equals("right"))
			{
				blob.addNote("canLeft");
			}
		}
		
		
		if (blob.wasHere(blobPos) || blob.hitWall(board))
		{
			
			
			Coord intersect = blob.findNearestIntersection();
			blob.goToPrevPos(intersect, board);
			

			
			/*int lastRow = blob.lastPos.getRow(), lastCol = blob.lastPos.getCol();
			int row = blobPos.getRow(), col = blobPos.getCol();
			
			final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
			int lastMove = -1;
			
			if (row == lastRow+1)
			{
				lastMove = DOWN;
			}
			if (row == lastRow-1)
			{
				lastMove = UP;
			}
			if (col == lastCol+1)
			{
				lastMove = RIGHT;
			}
			if (col == lastCol-1)
			{
				lastMove = LEFT;
			}
			
			switch(lastMove)
			{
			case UP:
				
				break;
			case DOWN:
				
				break;
			case LEFT:
				
				break;
			case RIGHT:
				
				break;
			}*//*
		}
		else
		{
			
			if (board.isConnectedDown(blobPos.getRow(), blobPos.getCol()))
			{
				Coord newPos = new Coord(blobPos.getRow()+1, blobPos.getCol());
				blob.setPosition(newPos);
			}
			else if (board.isConnectedRight(blobPos.getRow(), blobPos.getCol()+1))
			{
				Coord newPos = new Coord(blobPos.getRow(), blobPos.getCol()+1);
				blob.setPosition(newPos);
			}
			else if (board.isConnectedUp(blobPos.getRow(), blobPos.getCol()))
			{
				Coord newPos = new Coord(blobPos.getRow()-1, blobPos.getCol());
				blob.setPosition(newPos);
			}
			else if (board.isConnectedLeft(blobPos.getRow(), blobPos.getCol()))
			{
				Coord newPos = new Coord(blobPos.getRow(), blobPos.getCol()-1);
				blob.setPosition(newPos);
			}
			blob.coords.add(blob.lastPos);
		}

	}
*/
	public void actionPerformed(ActionEvent ae) {
		timerTick();
	}
	public void timerTick() {
		counter++;
		//moveBlob();
		newMove();
		
		
		repaint();
	}


	public void paintComponent(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 64));
		g.drawString("Counter:" + counter, 100, 100);

		Coord blobPos = blob.getPosition();
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		g.drawString("Row: " + blobPos.getRow() + ", Col: " + blobPos.getCol(), 20, 20);

		int cols = board.getColumns();
		int rows = board.getRows();
		int cellWidth = width / cols;
		int cellHeight = height/rows;

		g.setColor(Color.white);
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				// ...go figure it out...
				// ...use g.drawLine( x1, y1, x2, y2)...


				if (!board.getConnectedDown(row, col))
				{
					g.drawLine(col*cellWidth, (row*cellHeight)+cellHeight, (col*cellWidth)+cellWidth, (row*cellHeight)+cellHeight);
				}
				if (!board.getConnectedRight(row, col))
				{
					g.drawLine(col*cellWidth, (row*cellHeight)+cellHeight, col*cellWidth, ((row*cellHeight)+cellHeight) - cellHeight);
				}
			}
		}

		int blobX = blobPos.getCol()*cellWidth;
		int blobY = blobPos.getRow()*cellHeight;
		g.fillOval(blobX, blobY, cellWidth, cellHeight);
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < blob.coords.size(); i++)
		{
			g.fillOval(blob.coords.get(i).getCol()*cellWidth, blob.coords.get(i).getRow()*cellHeight, cellWidth, cellHeight);
		}

	}
}