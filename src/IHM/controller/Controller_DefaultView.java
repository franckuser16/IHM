package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DefaultView;
import view.OtherView;

public class Controller_DefaultView implements ActionListener
{
	private final DefaultView dView;
	
	public Controller_DefaultView(DefaultView dv)
	{
		dView = dv;
	}
	
	//Methods for ActionListener
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == dView.getLeft2right())
			dView.getTextRight().setText("left to right");
		
		else if(e.getSource() == dView.getRight2left())
			dView.getTextLeft().setText("right to left");
		
		else if(e.getSource() == dView.getMenu_quit())
			System.exit(0);
		
		else if(e.getSource() == dView.getMenu_view2())
		{
			OtherView view = new OtherView();
			view.buildUI();
		}			
		
		else if(e.getSource() == dView.getMenu_view1())
		{
			DefaultView view = new DefaultView();
			view.buildUI();
		}			
	}	
}