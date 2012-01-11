package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DefaultView;
import view.OtherView;

public class Controller_OtherView implements ActionListener
{
	private final OtherView oView;
	
	public Controller_OtherView(OtherView ov)
	{
		oView = ov;
	}
	
	//Methods for ActionListener
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == oView.getLeft2right())
			oView.getTextRight().setText("left to right");
		
		else if(e.getSource() == oView.getRight2left())
			oView.getTextLeft().setText("right to left");
		
		else if(e.getSource() == oView.getMenu_quit())
			System.exit(0);
		
		else if(e.getSource() == oView.getMenu_view2())
		{
			OtherView view = new OtherView();
			view.buildUI();
		}			
		
		else if(e.getSource() == oView.getMenu_view1())
		{
			DefaultView view = new DefaultView();
			view.buildUI();
		}			
	}	
}