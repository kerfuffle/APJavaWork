package net.Wilckens.Pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;


class KeyTracker implements KeyListener 
{
	final private boolean[] keyPressed;
	final private boolean[] keyDown;

	KeyTracker(JComponent parent) 
	{
		keyDown = new boolean[256];
		keyPressed = new boolean[256];
		parent.addKeyListener(this);
		parent.setFocusable(true);
		parent.requestFocusInWindow();
	}

	@Override
	public void keyTyped(KeyEvent e) {  }

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keycode = e.getKeyCode();
		if (keycode >= 0 && keycode < 256) 
		{
			keyPressed[keycode] = true;
			keyDown[keycode] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keycode = e.getKeyCode();
		if (keycode >= 0 && keycode < 256)
			keyDown[keycode] = false;
	}
	public void resetKeys() {
		for (int i = 0; i < 256; i++)
			keyDown[i] = false;
	}
	public boolean isKeyDown(int keycode) {
		return (keycode >= 0 && keycode < 256) ? keyDown[keycode] : false;
	}
	
	public boolean checkKey(int i)
	{
		if (isKeyDown(i) != keyDown[i])
		{
			return keyDown[i] = !keyDown[i];
		}
		else
		{
			return false;
		}
	}
	
	public boolean wasKeyPressed(int keycode) {
		return (keycode >= 0 && keycode < 256) ? keyPressed[keycode] : false;        
	}
}


