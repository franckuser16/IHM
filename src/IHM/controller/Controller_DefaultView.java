package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

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
		//we have click on "left2right" button
		if(e.getSource() == dView.getLeft2right())
			dView.getTextRight().setText("left to right");
		
		//we have click on "right2left" button
		else if(e.getSource() == dView.getRight2left())
			dView.getTextLeft().setText("right to left");
		
		//we have choose "Quit" in the menu
		else if(e.getSource() == dView.getMenu_quit())
			System.exit(0);
		
		//show the OtherView
		else if(e.getSource() == dView.getMenu_view2())
		{
			OtherView view = new OtherView();
			view.buildUI();
			
			//close old window
			dView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == dView.getMenu_view1())
		{
			DefaultView view = new DefaultView();
			/*
	         * here you can modify look and feel of all the elements 
	         */
	        view.setTitleLeft(new JLabel("Meter"));
	        
	        Object[] units = new Object[]{"m","cm","mm","µm"};
	        JComboBox leftCombo = new JComboBox(units);
	        leftCombo.setPreferredSize(new Dimension(250, 25));
	        leftCombo.setMaximumSize(leftCombo.getPreferredSize());
	        view.setListLeft(leftCombo);
	        /*
	         * 
	         */
			view.buildUI();
			
			//close old window
			dView.getConverter().dispose();
		}	
	}	
}