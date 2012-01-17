package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Converter;
import model.Unit;
import model.UnitFactory;
import view.DefaultView;
import view.OtherView;

public class Controller_OtherView implements ActionListener, ListSelectionListener
{
	private final OtherView oView;
	private Unit sysTo;
	private String unitTo;
	private Unit sysFrom;
	private String unitFrom;
	
	private UnitFactory uf;
	
	private static final HashMap<String, String[]> systemUnits = new UnitFactory().getUnitList();
	
	public Controller_OtherView(OtherView ov)
	{
		oView = ov;
		uf = new UnitFactory();
	}
	
	//Methods for ActionListener
	@Override
	public void actionPerformed(ActionEvent e){
		
		//we have click on "Convert" button
		if(e.getSource() == oView.getConvert())	
		{
			if(oView.getAmountText().getText().isEmpty())
			{
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
			else
			{
				//hide error indications
				oView.getErrors().setText("");
				oView.getAmountText().setBackground(Color.WHITE);
				
				//conversion
				try
				{
					Double qte = Double.parseDouble(oView.getAmountText().getText().toString());
					sysFrom.setQuantity(qte);
					sysFrom.setName(unitFrom);
					sysTo.setName(unitTo);
					
					Converter cvt = sysFrom.getConverterTo(sysTo);
					if(cvt == null)
					{
						oView.getErrors().setText("Les deux systèmes sont incompatibles");
					}
					else
					{
						sysTo = (Unit)cvt.convert();
						oView.getResult().setText(Double.toString(sysTo.getQuantity()));
					}
				}
				catch(NumberFormatException nfe)
				{
					oView.getErrors().setText("Veuillez renseigner un nombre (ex: 2.5)");
					oView.getAmountText().setText("");
				}
			}
		}
		
		//we have choose "Quit" in the menu
		else if(e.getSource() == oView.getMenu_quit())
			System.exit(0);
		
		//show the OtherView
		else if(e.getSource() == oView.getMenu_view2()){
			OtherView view = new OtherView(true);
			
			//--- beginning modifications
			Iterator<Map.Entry<String, String[]>> it = systemUnits.entrySet().iterator();
			while(it.hasNext())
			{
				@SuppressWarnings("rawtypes")
				Map.Entry pairs = (Map.Entry)it.next();
				view.getFromModelListSystem().addElement("--- " + pairs.getKey() + " ---");
				view.getToModelListSystem().addElement("--- " + pairs.getKey() + " ---");
				
				for(int i = 0; i < systemUnits.get(pairs.getKey()).length; i++)
				{
					view.getFromModelListSystem().addElement(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
					view.getToModelListSystem().addElement(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
				}
			}
			//--- end modifications
			
			view.buildUI();						
			
			//close old window
			oView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == oView.getMenu_view1()){
			DefaultView view = new DefaultView(true);
			
			//--- beginning modifications	        
			Iterator<Map.Entry<String, String[]>> it = systemUnits.entrySet().iterator();
			while(it.hasNext())
			{
				@SuppressWarnings("rawtypes")
				Map.Entry pairs = (Map.Entry)it.next();
				view.getSystemLeft().addItem("--- " + pairs.getKey() + " ---");
				view.getSystemRight().addItem("--- " + pairs.getKey() + " ---");
				
				for(int i = 0; i < systemUnits.get(pairs.getKey()).length; i++)
				{
					view.getSystemLeft().addItem(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
					view.getSystemRight().addItem(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
				}
			}
        	//--- end modifications
	        
			view.buildUI();
			
			//close old window
			oView.getConverter().dispose();
		}			
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0){
		JList l = (JList)arg0.getSource();
		String choice = l.getSelectedValue().toString();
		
		//"from" list System
		if(arg0.getSource() == oView.getFromListSystem())
		{	
			if(!choice.startsWith("---"))
			{
				Object[] tab;			
				this.sysFrom = uf.createUnit(choice);
				tab = this.sysFrom.getList();
				showUnitsFrom(tab);
			}
			else
				oView.getFromModelListUnits().removeAllElements();
		}
		//"to" list System
		else if(arg0.getSource() == oView.getToListSystem())
		{			
			if(!choice.startsWith("---"))
			{
				Object[] tab;			
				this.sysTo = uf.createUnit(choice);
				tab = this.sysTo.getList();
				showUnitsTo(tab);
			}
			else
				oView.getToModelListUnits().removeAllElements();
		}
		//"from" list Units
		else if(arg0.getSource() == oView.getFromListUnits())
		{			
			this.unitFrom = choice;
		}
		//"to" list Units
		else if(arg0.getSource() == oView.getToListUnits())
		{
			this.unitTo = choice;
		}
		
	}	
	
	/**
	 * 
	 * @param tab list of Unit (peta, zetta, centi...) for left Unit JComboBox
	 */
	private void showUnitsFrom(Object[] tab)
	{
		oView.getFromModelListUnits().removeAllElements();
		for(int i = 0; i < tab.length; i++)
			oView.getFromModelListUnits().addElement(tab[i]);
	}
	
	/**
	 * 
	 * @param tab list of Unit (peta, zetta, centi...) for right Unit JComboBox
	 */
	private void showUnitsTo(Object[] tab)
	{
		oView.getToModelListUnits().removeAllElements();
		for(int i = 0; i < tab.length; i++)
			oView.getToModelListUnits().addElement(tab[i]);
	}
}