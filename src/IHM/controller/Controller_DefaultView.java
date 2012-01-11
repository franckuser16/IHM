package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.DefaultView;

public class Controller_DefaultView extends DefaultView implements KeyListener 
{
	@Override
	public void keyPressed(KeyEvent e)
	{
		this.getTextLeft().setText("conversion left 2 right");
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'l')
		{
			this.getTextLeft().setText("conversion left 2 right");
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}	

	
}