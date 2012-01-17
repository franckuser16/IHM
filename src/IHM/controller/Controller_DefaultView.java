package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import javax.swing.JComboBox;

import model.Converter;
import model.Unit;
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
	
	@SuppressWarnings("serial")
	private static final HashMap<String, String> systemUnits = new HashMap<String, String>() {{

		put ("Imperial system -> Volume", "ImperialSysVolume");
		put ("Imperial system -> Length", "ImperialSysLength");
		put ("Metric system -> Volume", "MetricSysVolume");
		put ("Metric system -> Length", "MetricSysLength");
	}};
	
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
				Double qte = Double.parseDouble(dView.getTextLeft().getText().toString());
				sysLeft.setQuantity(qte);
				sysLeft.setReference(unitLeft);
				sysRight.setReference(unitRight);
				
				Converter cvt = sysLeft.getConverterTo(sysRight);
				sysRight = (Unit)cvt.convert();
				dView.getTextRight().setText(Double.toString(sysRight.getQuantity()));	
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
				Double qte = Double.parseDouble(dView.getTextRight().getText().toString());
				sysRight.setQuantity(qte);
				sysRight.setReference(unitRight);
				sysLeft.setReference(unitLeft);
				
				Converter cvt = sysRight.getConverterTo(sysLeft);
				sysLeft= (Unit)cvt.convert();
				dView.getTextLeft().setText(Double.toString(sysLeft.getQuantity()));				
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
			//Object[] allValues = new Object[]{};
			
			//allValues = this.concat(isl.getList(), isv.getList());
			
			//--- beginning modifications	        
	        JComboBox leftComboSystem = new JComboBox(systemUnits.keySet().toArray());
	        view.setSystemLeft(leftComboSystem);
	        JComboBox rightComboSystem = new JComboBox(systemUnits.keySet().toArray());
	        view.setSystemRight(rightComboSystem);
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
		if(arg0.getSource() == dView.getSystemLeft())						//Left System JComboBox
		{
			try
			{
				Class<?> systemClass = Class.forName("model." + systemUnits.get(arg0.getItem().toString()));
				Constructor<?> construct = systemClass.getConstructor(new Class[]{Double.TYPE, String.class});
					
				Object o = construct.newInstance(new Object[]{new Double(1.5), new String("")});
				Object[] tab;
				
				this.sysLeft = (Unit)o;
				tab = this.sysLeft.getList();
				
				showUnitsLeft(tab);
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
				Class<?> systemClass = Class.forName("model." + systemUnits.get(arg0.getItem().toString()));
				Constructor<?> construct = systemClass.getConstructor(new Class[]{Double.TYPE, String.class});
					
				Object o = construct.newInstance(new Object[]{new Double(1.5), new String("")});
				Object[] tab;
				
				this.sysRight = (Unit)o;
				tab = this.sysRight.getList();
				
//				for(int i = 0; i < tab.length; i++)
//					System.out.println(tab[i].toString());
				
				showUnitsRight(tab);
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
			this.unitLeft = arg0.getItem().toString();
		}
		//unit right ComboBox
		else if(arg0.getSource() == dView.getListRight())						//Right Unit JComboBox
		{
			this.unitRight = arg0.getItem().toString();
		}
		
	}	
	
	private void showUnitsLeft(Object[] tab)
	{
		dView.getListLeft().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListLeft().addItem(tab[i]);
	}
	
	private void showUnitsRight(Object[] tab)
	{
		dView.getListRight().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListRight().addItem(tab[i]);
	}
}