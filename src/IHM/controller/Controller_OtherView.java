package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.DefaultView;
import view.OtherView;

public class Controller_OtherView implements ActionListener, ListSelectionListener
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
		//we have click on "Convert" button
		if(e.getSource() == oView.getConvert())
			oView.getResult().setText("Result of conversion");
		
		//we have choose "Quit" in the menu
		else if(e.getSource() == oView.getMenu_quit())
			System.exit(0);
		
		//show the OtherView
		else if(e.getSource() == oView.getMenu_view2())
		{
			OtherView view = new OtherView();
			view.buildUI();						
			
			//close old window
			oView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == oView.getMenu_view1())
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
			oView.getConverter().dispose();
		}			
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
		JList l = (JList)arg0.getSource();
		
		//"from" list
		if(arg0.getSource() == oView.getFromList())
		{			
			oView.getResult().setText(l.getSelectedValue().toString());
		}
		//"to" list
		else
		{
			oView.getResult().setText(l.getSelectedValue().toString());
		}
		
	}	
}