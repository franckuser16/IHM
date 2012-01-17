package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.Converter;
import model.Unit;
import model.UnitFactory;
import view.DefaultView;
import view.OtherView;

/**
*
* @author Jérémy Filhoulaud
*/
public class Controller_DefaultView implements ActionListener, ItemListener
{
	private final DefaultView dView;
	private Unit sysLeft;
	private String unitLeft;
	private Unit sysRight;
	private String unitRight;
	
	private static final HashMap<String, String[]> systemUnits = UnitFactory.getUnitList();
	
	public Controller_DefaultView(DefaultView dv)
	{
		dView = dv;
	}
	
	/**
	 * Listeners for buttons, menu items
	 */
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
			
			//TODO tester si on a bien un double
			else
			{
				//hide error indications
				dView.getErrors().setText("");
				dView.getTextLeft().setBackground(Color.WHITE);
				dView.getTextRight().setBackground(Color.WHITE);
				
				//conversion
				try
				{
					Double qte = Double.parseDouble(dView.getTextLeft().getText().toString());
					sysLeft.setQuantity(qte);
					sysLeft.setReference(unitLeft);
					sysRight.setReference(unitRight);
					
					Converter cvt = sysLeft.getConverterTo(sysRight);
					if(cvt == null)
					{
						dView.getErrors().setText("Les deux systèmes sont incompatibles");
					}
					else
					{
						sysRight = (Unit)cvt.convert();					
						dView.getTextRight().setText(Double.toString(sysRight.getQuantity()));
					}
				}
				catch(NumberFormatException nfe)
				{
					dView.getErrors().setText("Veuillez renseigner un nombre (ex: 2.5)");
					dView.getTextLeft().setText("");
				}
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
				try
				{
					Double qte = Double.parseDouble(dView.getTextRight().getText().toString());
					sysRight.setQuantity(qte);
					sysRight.setReference(unitRight);
					sysLeft.setReference(unitLeft);
					
					Converter cvt = sysRight.getConverterTo(sysLeft);
					if(cvt == null)
					{
						dView.getErrors().setText("Les deux systèmes sont incompatibles");
					}
					else
					{
						sysLeft= (Unit)cvt.convert();
						dView.getTextLeft().setText(Double.toString(sysLeft.getQuantity()));
					}
				}
				catch(NumberFormatException nfe)
				{
					dView.getErrors().setText("Veuillez renseigner un nombre (ex: 2.5)");
					dView.getTextRight().setText("");
				}
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
			dView.getConverter().dispose();
		}			
		
		//show the DefaultView
		else if(e.getSource() == dView.getMenu_view1())
		{
			DefaultView view = new DefaultView(true);
			//Object[] allValues = new Object[]{};
			
			//allValues = this.concat(isl.getList(), isv.getList());
			
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
			dView.getConverter().dispose();
		}	
	}

	/**
	 * Listeners for JComboBox
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		String choice = arg0.getItem().toString();
		
		if(arg0.getSource() == dView.getSystemLeft())						//Left System JComboBox
		{
			try
			{
				if(!choice.startsWith("---"))
				{
					Object[] tab;			
					this.sysLeft = UnitFactory.createUnit(choice);
					tab = this.sysLeft.getList();
					showUnitsLeft(tab);
				}
				else
					dView.getListLeft().removeAllItems();
				
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}			
		else if(arg0.getSource() == dView.getSystemRight())						//Right System JComboBox
		{
			try
			{
				if(!choice.startsWith("---"))
				{
					Object[] tab;
					this.sysRight = UnitFactory.createUnit(arg0.getItem().toString());
					tab = this.sysRight.getList();
					showUnitsRight(tab);
				}
				else
					dView.getListRight().removeAllItems();
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		//unit left ComboBox
		else if(arg0.getSource() == dView.getListLeft())						//Left Unit JComboBox
		{
			this.unitLeft = choice;
		}
		//unit right ComboBox
		else if(arg0.getSource() == dView.getListRight())						//Right Unit JComboBox
		{
			this.unitRight = choice;
		}
		
	}	
	
	/**
	 * 
	 * @param tab list of Unit (peta, zetta, centi...) for left Unit JComboBox
	 */
	private void showUnitsLeft(Object[] tab)
	{
		dView.getListLeft().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListLeft().addItem(tab[i]);
	}
	
	/**
	 * 
	 * @param tab list of Unit (peta, zetta, centi...) for right Unit JComboBox
	 */
	private void showUnitsRight(Object[] tab)
	{
		dView.getListRight().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListRight().addItem(tab[i]);
	}
}