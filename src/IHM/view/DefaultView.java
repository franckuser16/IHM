package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.Controller_DefaultView;

/**
 *
 * @author Jérémy Filhoulaud
 */
public class DefaultView
{
	/*
     * Attributs sans Getters/Setters
     */
	private JFrame converter = new JFrame("Converter");    
    private Box boxUnit1 = new Box(BoxLayout.PAGE_AXIS);		//boite de conversion de gauche
    private Box boxUnit2 = new Box(BoxLayout.PAGE_AXIS);		//boite de conversion de droite
    private Box boxButtons = new Box(BoxLayout.PAGE_AXIS);		//boite qui contient les boutons de conversion
    private Box boxError = new Box(BoxLayout.LINE_AXIS);		//boite qui contient le message d'erreur
    private Box boxNorth = new Box(BoxLayout.LINE_AXIS);		//boite qui contient le titre
    private Box boxConversion = new Box(BoxLayout.LINE_AXIS);	//boite qui contient boxUnit1, boxUnit2 et boxButtons
    private Box boxCenter = new Box(BoxLayout.PAGE_AXIS);		//boite qui contient boxError & boxConversion
    
	//Pour la création d'un menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    
    //Taille des contrôles comme les champs textes ou les listes déroulantes
	private final static Dimension sizeControls = new Dimension(250, 25);
  
    /*
     * Attributs avec Getters/Setters
     */
	//"Titre" et message d'erreur de l'application 
    private JLabel title = new JLabel();
    private JLabel errors = new JLabel();
    
    //Eléments de la boite de conversion de gauche
    private JComboBox systemLeft = new JComboBox();
    private JComboBox listLeft = new JComboBox();
    private JTextField textLeft = new JTextField();
    
    //Eléments de la boite de conversion de droite
    private JComboBox systemRight = new JComboBox();
    private JComboBox listRight = new JComboBox();
    private JTextField textRight = new JTextField();
    
    //Les deux boutons permettant la conversion
    private JButton left2right;
    private JButton right2left;
    
    //les items du menu
    private JRadioButtonMenuItem menu_view1 = new JRadioButtonMenuItem("View 1");
    private JRadioButtonMenuItem menu_view2 = new JRadioButtonMenuItem("View 2");
    private JMenuItem menu_quit = new JMenuItem("Quit");
    
    private boolean frameVisibility; 

	/**
	 * Set all the element of a default converter
	 */
    public DefaultView(boolean visibility)
    {
    	frameVisibility = visibility;
    	
    	//paramétrage de la fenêtre
        converter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        converter.setPreferredSize(new Dimension(550, 250));
        
        //modification du look&feel du titre de l'application
        title.setFont(new Font("Calibri", Font.TYPE1_FONT, 20));
        title.setForeground(Color.ORANGE);
        title.setText("Converter");
        
        //look&feel du message d'erreur
        errors.setForeground(Color.RED);
        
        //texte dans les boutons de conversion
        left2right = new JButton("-->");
        right2left = new JButton("<--");

        //taille des champs texte
        textLeft.setPreferredSize(sizeControls);        
        textLeft.setMaximumSize(textLeft.getPreferredSize());
        textRight.setPreferredSize(sizeControls);
        textRight.setMaximumSize(textRight.getPreferredSize());
    }
    
    /**
     * Cette méthode assemble les éléments entre eux (imbrication des différentes Box...)
     */
    public void buildUI()
    {	
    	menu_view1.setSelected(true);
    	menu_view1.setEnabled(false);
    	
    	//définit la taille des listes déroulantes
    	listLeft.setPreferredSize(sizeControls);
        listLeft.setMaximumSize(listLeft.getPreferredSize());
        listRight.setPreferredSize(sizeControls);
        listRight.setMaximumSize(listRight.getPreferredSize());
        systemLeft.setPreferredSize(sizeControls);
        systemLeft.setMaximumSize(systemLeft.getPreferredSize());
        systemRight.setPreferredSize(sizeControls);
        systemRight.setMaximumSize(systemRight.getPreferredSize());
    	
    	/*
    	 * définit tous les écouteurs sur les champs textes, listes déroulantes et boutons
    	 */
        Controller_DefaultView cdv = new Controller_DefaultView(this);
    	left2right.addActionListener(cdv);
    	right2left.addActionListener(cdv);
    	menu_quit.addActionListener(cdv);
    	menu_view2.addActionListener(cdv);
    	menu_view1.addActionListener(cdv);
    	listLeft.addItemListener(cdv);
    	listRight.addItemListener(cdv);
    	systemLeft.addItemListener(cdv);
    	systemRight.addItemListener(cdv);
    	
    	//définit les raccourcis clavier
    	menu.setMnemonic(KeyEvent.VK_M);			//ALT + M pour ouvrir le menu   	
    	left2right.setMnemonic(KeyEvent.VK_L);		//ALT + L pour effectuer la conversion de la gauche vers la droite    	
    	right2left.setMnemonic(KeyEvent.VK_R);		//ALT + R pour effectuer la conversion de la vers la gauche
    	menu_view1.setMnemonic(KeyEvent.VK_1);		//ALT + 1 pour ouvrir la vue 1 (après ALT + M)   	
    	menu_view2.setMnemonic(KeyEvent.VK_2);		//ALT + 2 pour ouvrir la vue 2 (après ALT + M)
    	menu_quit.setMnemonic(KeyEvent.VK_Q);		//ALT + Q pour quitter l'application (après ALT + M)
    	
    	//aligne les contrôles dans les boites
    	systemRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        systemLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        listLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        listRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        textRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        left2right.setAlignmentX(Component.CENTER_ALIGNMENT);
        right2left.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    	//ajoute le titre dans sa boite
        boxNorth.add(Box.createGlue());
        boxNorth.add(title);
        boxNorth.add(Box.createGlue());
        
        //ajoute le message d'erreur dans sa boite
        boxError.add(Box.createGlue());
        boxError.add(errors);
        boxError.add(Box.createGlue());
        
        //ajoute les éléments de conversion dans la boite de gauche
        boxUnit1.add(Box.createGlue());
        boxUnit1.add(systemLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(listLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);
        boxUnit1.add(Box.createGlue());
        
        //ajoute les éléments de conversion dans la boite de droite
        boxUnit2.add(Box.createGlue());
        boxUnit2.add(systemRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(listRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(textRight);
        boxUnit2.add(Box.createGlue());
        
        //ajoute les boutons de conversion dans leur boite 
        boxButtons.add(Box.createGlue());
        boxButtons.add(left2right);
        boxButtons.add(Box.createRigidArea(new Dimension(0, 20)));
        boxButtons.add(right2left);
        boxButtons.add(Box.createGlue());

        //ajoute les boites de conversion et des boutons dans une boite
        boxConversion.add(Box.createGlue());
        boxConversion.add(boxUnit1);
        boxConversion.add(Box.createHorizontalStrut(20));
        boxConversion.add(boxButtons);
        boxConversion.add(Box.createHorizontalStrut(20));
        boxConversion.add(boxUnit2);
        boxConversion.add(Box.createGlue());  
        
        //ajotue les boites du message d'erreur et de conversion dans une boite
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxError);
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxConversion);
        boxCenter.add(Box.createGlue());
        
        //ajoute les items dans le menu
        menu.add(menu_view1);
        menu.add(menu_view2);
        menu.add(new JSeparator());
        menu.add(menu_quit);
        menuBar.add(menu);                
        
        //ajoute le menu, la boite contenant le titre et la boite contenant le système de conversion, à la fenêtre
        converter.setJMenuBar(menuBar);
        converter.add(boxNorth, BorderLayout.NORTH);
        converter.add(boxCenter, BorderLayout.CENTER);
        
        //"affichage" de la fenêtre
        converter.setMinimumSize(converter.getPreferredSize());
        converter.setLocationRelativeTo(null);
        converter.pack();
        converter.setVisible(frameVisibility);
    }
	
	/**
	 * 
	 * @return le titre de l'application
	 */
    public JLabel getTitle()
	{
		return title;
	}

    /**
     * Permet la modification du titre de l'application
     * @param title: le nouveau JLabel
     */
	public void setTitle(JLabel title)
	{
		this.title = title;
	}

	/**
	 * 
	 * @return la liste déroulante de gauche qui contient les systèmes 
	 */
	public JComboBox getSystemLeft()
	{
		return systemLeft;
	}

	/**
	 * Permet la modification de la liste déroulante de gauche qui contient les systèmes
	 * @param systemLeft: la nouvelle JCombobox
	 */
	public void setSystemLeft(JComboBox systemLeft)
	{
		this.systemLeft = systemLeft;
	}

	/**
	 *
	 * @return la liste déroulante de gauche qui contient les unités
	 */
	public JComboBox getListLeft()
	{
		return listLeft;
	}

	/**
	 * Permet la modification de la liste déroulante de gauche qui contient les unités 
	 * @param listLeft: la nouvelle JComboBox
	 */
	public void setListLeft(JComboBox listLeft)
	{
		this.listLeft = listLeft;
	}

	/**
	 *
	 * @return le champ texte de gauche
	 */
	public JTextField getTextLeft()
	{
		return textLeft;
	}

	/**
	 * Permet la modification du champ texte de gauche
	 * @param textLeft: le nouveau champ texte
	 */
	public void setTextLeft(JTextField textLeft)
	{
		this.textLeft = textLeft;
	}

	/**
	 * 
	 * @return la liste déroulante de droite qui contient les systèmes 
	 */
	public JComboBox getSystemRight()
	{
		return systemRight;
	}

	/**
	 * Permet la modification de la liste déroulante de droite qui contient les systèmes
	 * @param systemLeft: la nouvelle JComboBox
	 */
	public void setSystemRight(JComboBox systemRight)
	{
		this.systemRight = systemRight;
	}

	/**
	 *
	 * @return la liste déroulante de droite qui contient les unités
	 */
	public JComboBox getListRight()
	{
		return listRight;
	}

	/**
	 * Permet la modification de la liste déroulante de droite qui contient les unités
	 * @param listRight: la nouvelle JComboBox
	 */
	public void setListRight(JComboBox listRight)
	{
		this.listRight = listRight;
	}

	/**
	 * 
	 * @return le champ texte de droite 
	 */
	public JTextField getTextRight()
	{
		return textRight;
	}

	/**
	 * Permet la modification du champs texte de droite
	 * @param textRight: le nouveau JTextField
	 */
	public void setTextRight(JTextField textRight)
	{
		this.textRight = textRight;
	}
	
	/**
	 * 
	 * @return le bouton permettant la conversion de la gauche vers la droite
	 */
	public JButton getLeft2right()
	{
		return left2right;
	}

	/**
	 * Modifie le bouton permettant la conversion de la gauche vers la droite
	 * @param left2right: le nouveau JButton
	 */
	public void setLeft2right(JButton left2right)
	{
		this.left2right = left2right;
	}

	/**
	 * 
	 * @return le bouton permettant la conversion de la droite vers la gauche
	 */
	public JButton getRight2left()
	{
		return right2left;
	}

	/**
	 * Modifie le bouton permettant la conversion de la droite vers la gauche
	 * @param right2left: le nouveau JButton
	 */
	public void setRight2left(JButton right2left)
	{
		this.right2left = right2left;
	}

	/**
	 * 
	 * @return le premier item du menu
	 */
	public JRadioButtonMenuItem getMenu_view1()
	{
		return menu_view1;
	}

	/**
	 * Modifie le premier item du menu
	 * @param menu_view1: le nouveau JRadioButtonMenuItem
	 */
	public void setMenu_view1(JRadioButtonMenuItem menu_view1)
	{
		this.menu_view1 = menu_view1;
	}

	/**
	 * 
	 * @return le deuxième item du menu
	 */
	public JRadioButtonMenuItem getMenu_view2()
	{
		return menu_view2;
	}

	/**
	 * Modifie le deuxième item du menu
	 * @param menu_view2: le nouveau JRadioButtonMenuItem
	 */
	public void setMenu_view2(JRadioButtonMenuItem menu_view2)
	{
		this.menu_view2 = menu_view2;
	}

	/**
	 * 
	 * @return l'item du menu permettant de quitter l'application 
	 */
	public JMenuItem getMenu_quit()
	{
		return menu_quit;
	}

	/**
	 * Modifie l'item du menu permettant de quitter l'application
	 * @param menu_quit: le nouveau JMenuItem
	 */
	public void setMenu_quit(JMenuItem menu_quit)
	{
		this.menu_quit = menu_quit;
	}

	/**
	 * 
	 * @return la fenêtre principale
	 */
	public JFrame getConverter()
	{
		return converter;
	}

	/**
	 * 
	 * @return le message d'erreur de l'application
	 */
	public JLabel getErrors()
	{
		return errors;
	}

	/**
	 * Modifie le message d'erreur de l'application
	 * @param errors: le nouveau JLabel
	 */
	public void setErrors(JLabel errors)
	{
		this.errors = errors;
	}
	
	
}