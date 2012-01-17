package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
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
	public void actionPerformed(ActionEvent e){
		
		//we have click on "Convert" button
		if(e.getSource() == oView.getConvert())	{
			if(oView.getAmountText().getText().isEmpty()){
				//show error indications
				oView.getErrors().setText("Veuillez renseigner une valeur.");
				oView.getAmountText().setBackground(Color.PINK);
			}
			else if(oView.getFromListSystem().isSelectionEmpty())
			{
				oView.getErrors().setText("Veuillez sélectionner une valeur dans la liste \"From\" system");
			}
			else if(oView.getToListSystem().isSelectionEmpty())
			{
				oView.getErrors().setText("Veuillez sélectionner une valeur dans la liste \"To\" system");
			}
			else if(oView.getFromListUnits().isSelectionEmpty())
			{
				oView.getErrors().setText("Veuillez sélectionner une valeur dans la liste \"From\" units");
			}
			else if(oView.getToListUnits().isSelectionEmpty())
			{
				oView.getErrors().setText("Veuillez sélectionner une valeur dans la liste \"To\" units");
			}
			else{
				//hide error indications
				oView.getErrors().setText("");
				oView.getAmountText().setBackground(Color.WHITE);
				
				//conversion
			}
		}
		
		//we have choose "Quit" in the menu
		else if(e.getSource() == oView.getMenu_quit())
			System.exit(0);
		
		//show the OtherView
		else if(e.getSource() == oView.getMenu_view2()){
			OtherView view = new OtherView(true);
			
			//--- beginning modifications
			
			//--- end modifications
			
			view.buildUI();						
			
			//close old window
			oView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == oView.getMenu_view1()){
			DefaultView view = new DefaultView(true);
			
			//--- beginning modifications	        
//			JComboBox leftComboSystem = new JComboBox(systemUnits.keySet().toArray());
//	        view.setSystemLeft(leftComboSystem);
//	        JComboBox rightComboSystem = new JComboBox(systemUnits.keySet().toArray());
//	        view.setSystemRight(rightComboSystem);
        	//--- end modifications
	        
			view.buildUI();
			
			//close old window
			oView.getConverter().dispose();
		}			
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0){
		JList l = (JList)arg0.getSource();
		
		//"from" list System
		if(arg0.getSource() == oView.getFromListSystem())
		{			
//			oView.getResult().setText(l.getSelectedValue().toString());
		}
		//"to" list System
		else if(arg0.getSource() == oView.getToListSystem())
		{
//			oView.getResult().setText(l.getSelectedValue().toString());
		}
		//"from" list Units
		else if(arg0.getSource() == oView.getFromListUnits())
		{			
//			oView.getResult().setText(l.getSelectedValue().toString());
		}
		//"to" list Units
		else if(arg0.getSource() == oView.getToListUnits())
		{
//			oView.getResult().setText(l.getSelectedValue().toString());
		}
		
	}	
}