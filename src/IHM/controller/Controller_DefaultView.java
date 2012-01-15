package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import view.DefaultView;
import view.OtherView;

/**
*
* @author Jérémy Filhoulaud
*/
public class Controller_DefaultView implements ActionListener, ItemListener
{
	private final DefaultView dView;
	
	public Controller_DefaultView(DefaultView dv)
	{
		dView = dv;
	}
	
	//Method for ActionListener
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//we have click on "left2right" button
		if(e.getSource() == dView.getLeft2right())
		{
			if(dView.getTextLeft().getText().isEmpty())
			{
				//show error indications
				dView.getErrors().setText("Veuillez renseigner une valeur.");
				dView.getTextLeft().setBackground(Color.PINK);
			}
			
			else
			{
				//hide error indications
				dView.getErrors().setText("");
				dView.getTextLeft().setBackground(Color.WHITE);
				dView.getTextRight().setBackground(Color.WHITE);
				
				//conversion
			}
		}
			
		//we have click on "right2left" button
		else if(e.getSource() == dView.getRight2left())
		{
			if(dView.getTextRight().getText().isEmpty())
			{
				//show error indications
				dView.getErrors().setText("Veuillez renseigner une valeur.");
				dView.getTextRight().setBackground(Color.PINK);
			}
			else
			{
				//hide error indications
				dView.getErrors().setText("");
				dView.getTextRight().setBackground(Color.WHITE);
				dView.getTextLeft().setBackground(Color.WHITE);
				
				//conversion
			}
		}
		
		//we have choose "Quit" in the menu
		else if(e.getSource() == dView.getMenu_quit())
			System.exit(0);
		
		//show the OtherView
		else if(e.getSource() == dView.getMenu_view2())
		{
			OtherView view = new OtherView(true);
			
			//--- beginning modifications
			
			//--- end modifications
			
			view.buildUI();
			
			//close old window
			dView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == dView.getMenu_view1())
		{
			DefaultView view = new DefaultView(true);
			
			//--- beginning modifications
	        view.setTitleLeft(new JLabel("Meter"));
	        
	        Object[] units = new Object[]{"m","cm","mm","µm"};
	        JComboBox leftCombo = new JComboBox(units);
	        leftCombo.setPreferredSize(new Dimension(250, 25));
	        leftCombo.setMaximumSize(leftCombo.getPreferredSize());
	        view.setListLeft(leftCombo);
	        //--- end modifications
	        
			view.buildUI();
			
			//close old window
			dView.getConverter().dispose();
		}	
	}

	//Method for the JComboBox
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		if(arg0.getSource() == dView.getListLeft())						//Left JComboBox
		{
			dView.getTextLeft().setText(arg0.getItem().toString());
		}
		else
		{
			dView.getTextRight().setText(arg0.getItem().toString());	//Right JComboBox
		}
		
	}	
}