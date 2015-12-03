package net.kerfuffle.Utilities;

import org.newdawn.slick.opengl.Texture;
import static net.kerfuffle.Utilities.Util.*;

public class Quad {

	private Coord c;
	private Size s;
	private RGB color;
	private Texture tex;
	
	public Quad(Coord c, Size s, RGB color)
	{
		this.c = c;
		this.s = s;
		this.color = color;
	}
	
	
	public void draw()
	{
		color(color);
		quad(c.getX(), c.getY(), s.getWidth(), s.getHeight());
	}
	
	
	public void setPos(Coord c)
	{
		this.c = c;
	}
	public void setSize(Size s)
	{
		if (s.getWidth() > 0 && s.getHeight() > 0)
		{
			this.s = s;
		}	
	}
	public void setColor(RGB color)
	{
		this.color = color;
	}
	public void setTexture(Texture tex)
	{
		this.tex = tex;
	}
	
	public Texture getTexture()
	{
		return tex;
	}
	public RGB getColor()
	{
		return color;
	}
	public Coord getPos()
	{
		return c;
	}
	public Size getSize()
	{
		return s;
	}
	
}
