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
     * attributes without Getters/Setters
     */
	private JFrame converter = new JFrame("Converter");    
    private Box boxUnit1 = new Box(BoxLayout.PAGE_AXIS);		//unit box on left
    private Box boxUnit2 = new Box(BoxLayout.PAGE_AXIS);		//unit box on right
    private Box boxButtons = new Box(BoxLayout.PAGE_AXIS);		//box which contains button to convert
    private Box boxError = new Box(BoxLayout.LINE_AXIS);		//box which contains error label
    private Box boxNorth = new Box(BoxLayout.LINE_AXIS);		//box which contains title
    private Box boxConversion = new Box(BoxLayout.LINE_AXIS);	//box which contains boxUnit1, boxUnit2 and boxButtons
    private Box boxCenter = new Box(BoxLayout.PAGE_AXIS);		//box which contains boxError & boxConversion
    
	//For the menu of the application
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    
    //size of combo boxes and text fields
	private final static Dimension sizeControls = new Dimension(250, 25);
  
    /*
     * attributes with Getters/Setters
     */
    private JLabel title = new JLabel();
    private JLabel errors = new JLabel();
    
    //Composition of first unit box
    private JComboBox systemLeft = new JComboBox();
    private JComboBox listLeft = new JComboBox();
    private JTextField textLeft = new JTextField();
    
    //Composition of second unit box
    private JComboBox systemRight = new JComboBox();
    private JComboBox listRight = new JComboBox();
    private JTextField textRight = new JTextField();
    
    //buttons to convert
    private JButton left2right;
    private JButton right2left;
    
    //menu items
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
    	
    	//about JFrame...
        converter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        converter.setPreferredSize(new Dimension(550, 250));
        
        //title of application
        title.setFont(new Font("Calibri", Font.TYPE1_FONT, 20));
        title.setForeground(Color.ORANGE);
        title.setText("Converter");
        
        //look&feel errors messages
        errors.setForeground(Color.RED);
        
        //elements of button's box
        left2right = new JButton("-->");
        right2left = new JButton("<--");

        //size of JTextField
        textLeft.setPreferredSize(sizeControls);        
        textLeft.setMaximumSize(textLeft.getPreferredSize());
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
    	
    	//sizes of JComboBox
    	listLeft.setPreferredSize(sizeControls);
        listLeft.setMaximumSize(listLeft.getPreferredSize());
        listRight.setPreferredSize(sizeControls);
        listRight.setMaximumSize(listRight.getPreferredSize());
        systemLeft.setPreferredSize(sizeControls);
        systemLeft.setMaximumSize(systemLeft.getPreferredSize());
        systemRight.setPreferredSize(sizeControls);
        systemRight.setMaximumSize(systemRight.getPreferredSize());
    	
    	/*
    	 * add all listeners
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
    	
    	//keyboard shorcut
    	menu.setMnemonic(KeyEvent.VK_M);			//ALT + M to open menu    	
    	left2right.setMnemonic(KeyEvent.VK_L);		//ALT + L to convert left to right    	
    	right2left.setMnemonic(KeyEvent.VK_R);		//ALT + R to convert right to left    	
    	menu_view1.setMnemonic(KeyEvent.VK_1);		//ALT + 1 for view 1    	
    	menu_view2.setMnemonic(KeyEvent.VK_2);		//ALT + 2 for view 2    	
    	menu_quit.setMnemonic(KeyEvent.VK_Q);		//ALT + Q to quit
    	
    	//align controls in boxes
    	systemRight.setAlignmentX(Component.CENTER_ALIGNMENT);
        systemLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        
        //box which contains error message
        boxError.add(Box.createGlue());
        boxError.add(errors);
        boxError.add(Box.createGlue());
        
        //add all the elements in first unit box
        boxUnit1.add(Box.createGlue());
        boxUnit1.add(systemLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(listLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);
        boxUnit1.add(Box.createGlue());
        
        //add all the elements in second unit box
        boxUnit2.add(Box.createGlue());
        boxUnit2.add(systemRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
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

        //elements of conversion box (boxButtons, boxUnit1 and boxUnit2)
        boxConversion.add(Box.createGlue());
        boxConversion.add(boxUnit1);
        boxConversion.add(Box.createHorizontalStrut(20));
        boxConversion.add(boxButtons);
        boxConversion.add(Box.createHorizontalStrut(20));
        boxConversion.add(boxUnit2);
        boxConversion.add(Box.createGlue());  
        
        //elements of center box (boxError & boxConversion)
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxError);
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxConversion);
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
        converter.setLocationRelativeTo(null);
        converter.pack();
        converter.setVisible(frameVisibility);
    }
	
	/**
	 * 
	 * @return the title of the converter
	 */
    public JLabel getTitle()
	{
		return title;
	}

    /**
     * Set the title of the converter
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
	public JComboBox getSystemLeft()
	{
		return systemLeft;
	}

	/**
	 * Set system of left box
	 * @param systemLeft: the new JComboBox
	 */
	public void setSystemLeft(JComboBox systemLeft)
	{
		this.systemLeft = systemLeft;
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
	public JTextField getTextLeft()
	{
		return textLeft;
	}

	/**
	 * Set the left text field
	 * @param textLeft: the new JTextField
	 */
	public void setTextLeft(JTextField textLeft)
	{
		this.textLeft = textLeft;
	}

	/**
	 * 
	 * @return system of right box 
	 */
	public JComboBox getSystemRight()
	{
		return systemRight;
	}

	/**
	 * Set system of right box
	 * @param systemLeft: the new JComboBox
	 */
	public void setSystemRight(JComboBox systemRight)
	{
		this.systemRight = systemRight;
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
	public JTextField getTextRight()
	{
		return textRight;
	}

	/**
	 * Set the right text field
	 * @param textRight: the new JTextField
	 */
	public void setTextRight(JTextField textRight)
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

	/**
	 * 
	 * @return error label on application
	 */
	public JLabel getErrors()
	{
		return errors;
	}

	/**
	 * Set the error label of the application
	 * @param errors: the new JLabel
	 */
	public void setErrors(JLabel errors)
	{
		this.errors = errors;
	}
	
	
}