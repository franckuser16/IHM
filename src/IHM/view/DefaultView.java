package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

import controller.Controller_DefaultView;

/**
 *
 * @author Jérémy Filhoulaud
 */
public class DefaultView
{
	/*
     * attributes without Getters/Setters
     */
	private JFrame converter = new JFrame("Converter");    
    private Box boxUnit1 = new Box(BoxLayout.PAGE_AXIS);	//unit box on left
    private Box boxUnit2 = new Box(BoxLayout.PAGE_AXIS);	//unit box on right
    private Box boxButtons = new Box(BoxLayout.Y_AXIS);	//box which contains button to convert
    private Box boxNorth = new Box(BoxLayout.X_AXIS);	//box which contains title
    private Box boxCenter = new Box(BoxLayout.X_AXIS);	//box which contains boxUnit1, boxUnit2 and boxButtons
    
	//For the menu of the application
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    
    //size of combo boxes and text fields
	private final static Dimension sizeControls = new Dimension(250, 25);
  
    /*
     * attributes with Getters/Setters
     */
    private JLabel title = new JLabel();
    
    //Composition of first unit box
    private JLabel titleLeft = new JLabel("Unit 1");
    private JComboBox listLeft = new JComboBox();
    private JFormattedTextField textLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
    
    //Composition of second unit box
    private JLabel titleRight = new JLabel("Unit 2");
    private JComboBox listRight = new JComboBox();
    private JFormattedTextField textRight = new JFormattedTextField(NumberFormat.getNumberInstance());
    
    //buttons to convert
    private JButton left2right;
    private JButton right2left;
    
    //menu items
    private JRadioButtonMenuItem menu_view1 = new JRadioButtonMenuItem("View 1");
    private JRadioButtonMenuItem menu_view2 = new JRadioButtonMenuItem("View 2");
    private JMenuItem menu_quit = new JMenuItem("Quit");

	/**
	 * Set all the element of a default converter
	 */
    public DefaultView()
    {
    	//about JFrame...
    	converter.setLocationRelativeTo(null);
        converter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        converter.setPreferredSize(new Dimension(450, 200));
        
        //title of application
        title.setFont(new Font("Calibri", Font.TYPE1_FONT, 20));
        title.setForeground(Color.ORANGE);
        title.setText("Converter");
    	
        //elements of first unit box        
        listLeft.setPreferredSize(sizeControls);
        listLeft.setMaximumSize(listLeft.getPreferredSize());        
        
        textLeft.setPreferredSize(sizeControls);        
        textLeft.setMaximumSize(textLeft.getPreferredSize());
        
        //elements of button's box
        left2right = new JButton("-->");
        right2left = new JButton("<--");
        //not focusable because there are keyboard shortcuts (ATL + L & ALT + R)
        left2right.setFocusable(false);
        right2left.setFocusable(false);

        //size of JComboBox
        listRight.setPreferredSize(sizeControls);
        listRight.setMaximumSize(listRight.getPreferredSize());
        textRight.setPreferredSize(sizeControls);
        textRight.setMaximumSize(textRight.getPreferredSize());
    }
    
    /**
     * This method should be call when you have finish modification on controls.
     * It paste the elements together
     */
    public void buildUI()
    {	
    	menu_view1.setSelected(true);
    	menu_view1.setEnabled(false);
    	
    	/*
    	 * add all listeners
    	 */
    	left2right.addActionListener(new Controller_DefaultView(this));
    	right2left.addActionListener(new Controller_DefaultView(this));
    	menu_quit.addActionListener(new Controller_DefaultView(this));
    	menu_view2.addActionListener(new Controller_DefaultView(this));
    	menu_view1.addActionListener(new Controller_DefaultView(this));
    	listLeft.addItemListener(new Controller_DefaultView(this));
    	listRight.addItemListener(new Controller_DefaultView(this));
    	
    	//keyboard shorcut
    	menu.setMnemonic(KeyEvent.VK_M);			//ALT + M to open menu    	
    	left2right.setMnemonic(KeyEvent.VK_L);		//ALT + L to convert left to right    	
    	right2left.setMnemonic(KeyEvent.VK_R);		//ALT + R to convert right to left    	
    	menu_view1.setMnemonic(KeyEvent.VK_1);		//ALT + 1 for view 1    	
    	menu_view2.setMnemonic(KeyEvent.VK_2);		//ALT + 2 for view 2    	
    	menu_quit.setMnemonic(KeyEvent.VK_Q);		//ALT + Q to quit
    	
    	//align controls in boxes
    	titleRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        listLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        listRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        textRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        left2right.setAlignmentX(Component.CENTER_ALIGNMENT);
        right2left.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    	//box which contains title
        boxNorth.add(Box.createGlue());
        boxNorth.add(title);
        boxNorth.add(Box.createGlue());                
        
        //add all the elements in first unit box
        boxUnit1.add(Box.createGlue());
        boxUnit1.add(titleLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 10)));
        boxUnit1.add(listLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);
        boxUnit1.add(Box.createGlue());
        
        //add all the elements in second unit box
        boxUnit2.add(Box.createGlue());
        boxUnit2.add(titleRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 10)));
        boxUnit2.add(listRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(textRight);
        boxUnit2.add(Box.createGlue());
        
        //box which contains buttons to convert
        boxButtons.add(Box.createGlue());
        boxButtons.add(left2right);
        boxButtons.add(Box.createRigidArea(new Dimension(0, 20)));
        boxButtons.add(right2left);
        boxButtons.add(Box.createGlue());

        //element of center box (boxButtons, boxUnit1 and boxUnit2)
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxUnit1);
        boxCenter.add(Box.createHorizontalStrut(20));
        boxCenter.add(boxButtons);
        boxCenter.add(Box.createHorizontalStrut(20));
        boxCenter.add(boxUnit2);
        boxCenter.add(Box.createGlue());    
        
        //Menu
        menu.add(menu_view1);
        menu.add(menu_view2);
        menu.add(new JSeparator());
        menu.add(menu_quit);
        menuBar.add(menu);                
        
        //add boxes and menu to frame
        converter.setJMenuBar(menuBar);
        converter.add(boxNorth, BorderLayout.NORTH);
        converter.add(boxCenter, BorderLayout.CENTER);
        
        converter.setMinimumSize(converter.getPreferredSize());
        converter.pack();
        converter.setVisible(true);
    }
	
	/**
	 * 
	 * @return the title of the frame
	 */
    public JLabel getTitle()
	{
		return title;
	}

    /**
     * To set the title of the converter
     * @param title: the new JLabel
     */
	public void setTitle(JLabel title)
	{
		this.title = title;
	}

	/**
	 * 
	 * @return title (unit string) of left box 
	 */
	public JLabel getTitleLeft()
	{
		return titleLeft;
	}

	/**
	 * Set title (unit string) of left box
	 * @param titleLeft: the new JLabel
	 */
	public void setTitleLeft(JLabel titleLeft)
	{
		this.titleLeft = titleLeft;
	}

	/**
	 *
	 * @return left combo box which contains all units
	 */
	public JComboBox getListLeft()
	{
		return listLeft;
	}

	/**
	 * Set left combo box to add units
	 * @param listLeft: the new JComboBox
	 */
	public void setListLeft(JComboBox listLeft)
	{
		this.listLeft = listLeft;
	}

	/**
	 *
	 * @return the left text field
	 */
	public JFormattedTextField getTextLeft()
	{
		return textLeft;
	}

	/**
	 * Set the left text field
	 * @param textLeft: the new JFormattedTextField
	 */
	public void setTextLeft(JFormattedTextField textLeft)
	{
		this.textLeft = textLeft;
	}

	/**
	 * 
	 * @return title (unit string) of right box 
	 */
	public JLabel getTitleRight()
	{
		return titleRight;
	}

	/**
	 * Set title (unit string) of right box
	 * @param titleLeft: the new JLabel
	 */
	public void setTitleRight(JLabel titleRight)
	{
		this.titleRight = titleRight;
	}

	/**
	 *
	 * @return right combo box which contains all units
	 */
	public JComboBox getListRight()
	{
		return listRight;
	}

	/**
	 * Set right combo box to add units
	 * @param listRight: the new JComboBox
	 */
	public void setListRight(JComboBox listRight)
	{
		this.listRight = listRight;
	}

	/**
	 * 
	 * @return the right text field
	 */
	public JFormattedTextField getTextRight()
	{
		return textRight;
	}

	/**
	 * Set the right text field
	 * @param textRight: the new JFormattedTextField
	 */
	public void setTextRight(JFormattedTextField textRight)
	{
		this.textRight = textRight;
	}
	
	/**
	 * 
	 * @return the button which makes conversion from left to right
	 */
	public JButton getLeft2right()
	{
		return left2right;
	}

	/**
	 * Set the button which makes conversion from left to right
	 * @param left2right: the new JButton
	 */
	public void setLeft2right(JButton left2right)
	{
		this.left2right = left2right;
	}

	/**
	 * 
	 * @return the button which makes conversion from right to left
	 */
	public JButton getRight2left()
	{
		return right2left;
	}

	/**
	 * Set the button which makes conversion from right to left
	 * @param right2left: the new JButton
	 */
	public void setRight2left(JButton right2left)
	{
		this.right2left = right2left;
	}

	/**
	 * 
	 * @return the item in menu which represents the first view
	 */
	public JRadioButtonMenuItem getMenu_view1()
	{
		return menu_view1;
	}

	/**
	 * Set the item in menu which represents the first view
	 * @param menu_view1: the new JRadioButtonMenuItem
	 */
	public void setMenu_view1(JRadioButtonMenuItem menu_view1)
	{
		this.menu_view1 = menu_view1;
	}

	/**
	 * 
	 * @return the item in menu which represents the second view
	 */
	public JRadioButtonMenuItem getMenu_view2()
	{
		return menu_view2;
	}

	/**
	 * Set the item in menu which represents the second view
	 * @param menu_view2: the new JRadioButtonMenuItem
	 */
	public void setMenu_view2(JRadioButtonMenuItem menu_view2)
	{
		this.menu_view2 = menu_view2;
	}

	/**
	 * 
	 * @return the item in menu which represents application's closure
	 */
	public JMenuItem getMenu_quit()
	{
		return menu_quit;
	}

	/**
	 * Set the item in menu which represents application's closure
	 * @param menu_quit: the new JMenuItem
	 */
	public void setMenu_quit(JMenuItem menu_quit)
	{
		this.menu_quit = menu_quit;
	}

	/**
	 * 
	 * @return the main JFrame
	 */
	public JFrame getConverter()
	{
		return converter;
	}
}
