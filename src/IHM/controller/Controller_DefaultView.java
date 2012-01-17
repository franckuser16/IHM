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
	
	/**
	 * Constructeur du Controller
	 * @param dv: la vue auquelle le controller répond
	 */
	public Controller_DefaultView(DefaultView dv)
	{
		dView = dv;
	}
	
	/**
	 * Gère les écouteurs des boutons de conversion, des menus et des différents item du menu
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//on a cliqué sur le bouton de conversion de la gauche vers la droite ("-->")
		if(e.getSource() == dView.getLeft2right())
		{
			if(dView.getTextLeft().getText().isEmpty())		//le champ valeur est vide
			{
				//affichage d'une erreur
				dView.getErrors().setText("Veuillez renseigner une valeur.");
				dView.getTextLeft().setBackground(Color.PINK);						
			}
			else
			{
				//on cache les éventuelles erreurs précédentes
				dView.getErrors().setText("");
				dView.getTextLeft().setBackground(Color.WHITE);
				dView.getTextRight().setBackground(Color.WHITE);
				
				//conversion
				try
				{
					//on récupère la valeur que l'on souhaite convertir
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
				//on a rentré des lettres ou caractères spéciaux dans le champs texte
				catch(NumberFormatException nfe)	
				{
					dView.getErrors().setText("Veuillez renseigner un nombre (ex: 2.5)");
					dView.getTextLeft().setText("");
				}
			}
		}
			
		//on a cliqué sur le bouton de conversion de la droite vers la gauche ("<--")
		else if(e.getSource() == dView.getRight2left())
		{
			if(dView.getTextRight().getText().isEmpty())	//le champ valeur est vide
			{
				//affichage d'une erreur
				dView.getErrors().setText("Veuillez renseigner une valeur.");
				dView.getTextRight().setBackground(Color.PINK);
			}
			else
			{
				//on cache les éventuelles erreurs précédentes
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
				//on a rentré des lettres ou caractères spéciaux dans le champs texte
				catch(NumberFormatException nfe)
				{
					dView.getErrors().setText("Veuillez renseigner un nombre (ex: 2.5)");
					dView.getTextRight().setText("");
				}
			}
		}
		
		//on a cliqué sur Quit dans le menu
		else if(e.getSource() == dView.getMenu_quit())
			System.exit(0);
		
		//on a cliqué sur View 2 dans le menu, on charge donc OtherView
		else if(e.getSource() == dView.getMenu_view2())
		{
			OtherView view = new OtherView(true);
			
			//--- début des modifications
			//On pré-rempli les champs contenant la liste des Systèmes  
			Iterator<Map.Entry<String, String[]>> it = systemUnits.entrySet().iterator();
			while(it.hasNext())
			{
				@SuppressWarnings("rawtypes")
				Map.Entry pairs = (Map.Entry)it.next();
				
				//ajoute les en-têtes (Volume, longueur, masse...)
				view.getFromModelListSystem().addElement("--- " + pairs.getKey() + " ---");
				view.getToModelListSystem().addElement("--- " + pairs.getKey() + " ---");
				
				//ajoute les systèmes (Metric, Imperial...)
				for(int i = 0; i < systemUnits.get(pairs.getKey()).length; i++)
				{
					view.getFromModelListSystem().addElement(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
					view.getToModelListSystem().addElement(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
				}
			}
			//--- fin des modifications
			
			view.buildUI();
			
			//on ferme l'ancienne vue
			dView.getConverter().dispose();
		}			
		
		//on a cliqué sur View 1 dans le menu, on charge donc DefaultView
		else if(e.getSource() == dView.getMenu_view1())
		{
			DefaultView view = new DefaultView(true);
			
			////--- début des modifications
			//On pré-rempli les champs contenant la liste des Systèmes 	        
			Iterator<Map.Entry<String, String[]>> it = systemUnits.entrySet().iterator();
			while(it.hasNext())
			{
				@SuppressWarnings("rawtypes")
				Map.Entry pairs = (Map.Entry)it.next();
				
				//ajoute les en-têtes (Volume, longueur, masse...)
				view.getSystemLeft().addItem("--- " + pairs.getKey() + " ---");
				view.getSystemRight().addItem("--- " + pairs.getKey() + " ---");
				
				//ajoute les systèmes (Metric, Imperial...)
				for(int i = 0; i < systemUnits.get(pairs.getKey()).length; i++)
				{
					view.getSystemLeft().addItem(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
					view.getSystemRight().addItem(systemUnits.get(pairs.getKey())[i] + " " + pairs.getKey());
				}
			}
	        //--- fin des modifications
	        
			view.buildUI();
			
			//on ferme l'ancienne vue
			dView.getConverter().dispose();
		}	
	}

	/**
	 * Gère les écouteurs des quatre listes déroulantes
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		String choice = arg0.getItem().toString();	//récupère le texte de l'item choisi
		
		//On a sélectionné un item dans liste déroulante contenant les différents systèmes de gauche
		if(arg0.getSource() == dView.getSystemLeft())
		{
			try
			{
				//si on a choisi autre chose qu'une en-tête (--- Volume ----, --- Length ---, ...)
				if(!choice.startsWith("---"))
				{
					Object[] tab;
					//récupère l'instanciation de la classe correspondante au système sélectionné dans la liste déroulante
					this.sysLeft = UnitFactory.createUnit(choice);
					//récupère la liste des unités correspondantes au système sélectionné (à l'aide de l'instanciation précédente)
					tab = this.sysLeft.getList();
					//rempli la liste déroulante des unités
					showUnitsLeft(tab);
				}
				else	//on a choisi une en-tête, on vide le champ des unités
					dView.getListLeft().removeAllItems();
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			} 
			
		}			
		//On a sélectionné un item dans liste déroulante contenant les différents systèmes de droite
		else if(arg0.getSource() == dView.getSystemRight())
		{
			try
			{
				//si on a choisi autre chose qu'une en-tête (--- Volume ----, --- Length ---, ...)
				if(!choice.startsWith("---"))
				{
					Object[] tab;
					//récupère l'instanciation de la classe correspondante au système sélectionné dans la liste déroulante
					this.sysRight = UnitFactory.createUnit(arg0.getItem().toString());
					//récupère la liste des unités correspondantes au système sélectionné (à l'aide de l'instanciation précédente)
					tab = this.sysRight.getList();
					//rempli la liste déroulante des unités
					showUnitsRight(tab);
				}
				else
					dView.getListRight().removeAllItems();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			} 
		}
		//On a sélectionné un item dans liste déroulante contenant les différentes unités de gauche
		else if(arg0.getSource() == dView.getListLeft())
		{
			//On stock l'item choisi
			this.unitLeft = choice;
		}
		//On a sélectionné un item dans liste déroulante contenant les différentes unités de droite
		else if(arg0.getSource() == dView.getListRight())
		{
			//On stock l'item choisi
			this.unitRight = choice;
		}
		
	}	
	
	/**
	 * Affiche les unités disponibles (dans la deuxième liste déroulante de gauche) 
	 * en fonctions du système sélectionné (dans la première liste déroulante de gauche)
	 * @param tab: le tableau contenant toutes les unités
	 */
	private void showUnitsLeft(Object[] tab)
	{
		dView.getListLeft().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListLeft().addItem(tab[i]);
	}
	
	/**
	 * Affiche les unités disponibles (dans la deuxième liste déroulante de droite) 
	 * en fonctions du système sélectionné (dans la première liste déroulante de droite)
	 * @param tab: le tableau contenant toutes les unités
	 */
	private void showUnitsRight(Object[] tab)
	{
		dView.getListRight().removeAllItems();
		for(int i = 0; i < tab.length; i++)
			dView.getListRight().addItem(tab[i]);
	}
}