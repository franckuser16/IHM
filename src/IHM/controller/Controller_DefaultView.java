package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.DefaultView;

public class Controller_DefaultView implements ActionListener, KeyListener
{
	private final DefaultView mView;
	
	public Controller_DefaultView(DefaultView dv)
	{
		mView = dv;
	}
	
	//Methods for ActionListener
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == mView.getLeft2right())
			mView.getTextRight().setText("left to right");
		
		else if(e.getSource() == mView.getRight2left())
			mView.getTextLeft().setText("right to left");
		
		else if(e.getSource() == mView.getMenu_quit())
			System.exit(0);

	}

	//Methods for KeyListener
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
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