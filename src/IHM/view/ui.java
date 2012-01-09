//package IHM.view;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author jeremy
 */
public class ui
{
	/*
     * attributes without Getters/Setters
     */
	private static JFrame converter = new JFrame("Converter");
    private Box boxUnit1 = new Box(BoxLayout.Y_AXIS);	//unit on left
    private Box boxUnit2 = new Box(BoxLayout.Y_AXIS);	//unit on right
    private Box boxButtons = new Box(BoxLayout.Y_AXIS);	//box which contains button to convert
    
    private Box boxNorth = new Box(BoxLayout.X_AXIS);	//box which contains title
    private Box boxCenter = new Box(BoxLayout.X_AXIS);	//box which contains boxUnit1, boxUnit2 and boxButtons
    
    //For the menu of the application
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    private JMenuItem menu_view1 = new JMenuItem("View 1");
    private JMenuItem menu_view2 = new JMenuItem("View 2");
    private JMenuItem menu_quit = new JMenuItem("Quit");
    
    //buttons to convert
    private JButton left2right;
    private JButton right2left;
    
    //size of combo boxes and text fields
	private final static Dimension sizeControls = new Dimension(250, 25);
  
    /*
     * attributes with Getters/Setters
     */
    private JLabel title = new JLabel("Metric to Imperial Length Converter");
    
    private JLabel titleLeft = new JLabel("Unit 1");
    private JComboBox listLeft = new JComboBox();
    private JFormattedTextField textLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
    
    private JLabel titleRight = new JLabel("Unit 2");
    private JComboBox listRight = new JComboBox();
    private JFormattedTextField textRight = new JFormattedTextField(NumberFormat.getNumberInstance());
    
	/**
	 * Create all the element of a default converter
	 */
    public ui()
    {
    	//about JFrame...
    	converter.setLocationRelativeTo(null);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setPreferredSize(new Dimension(450, 200));
    	
        //elements of first unit box        
        listLeft.setPreferredSize(sizeControls);
        listLeft.setMaximumSize(listLeft.getPreferredSize());
        
        textLeft.setPreferredSize(sizeControls);        
        textLeft.setMaximumSize(textLeft.getPreferredSize());

        //elements of button's box
        left2right = new JButton("-->");
        right2left = new JButton("<--");

        //elements of second unit box        
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
    	//box which contains title
        boxNorth.add(Box.createGlue());
        boxNorth.add(title);
        boxNorth.add(Box.createGlue());
        
        //add all the elements in unit box
        boxUnit1.add(Box.createGlue());
        boxUnit1.add(titleLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 10)));
        boxUnit1.add(listLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);
        boxUnit1.add(Box.createGlue());
        
        //add all the elements in unit box
        boxUnit2.add(Box.createGlue());
        boxUnit2.add(titleRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 10)));
        boxUnit2.add(listRight);
        boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(textRight);
        boxUnit2.add(Box.createGlue());
        
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
       
        /*
        boxUnit1.setPreferredSize(new Dimension(listLeft.getWidth(), 100));
        boxUnit2.setPreferredSize(new Dimension(listRight.getWidth(), 100));
        boxButtons.setPreferredSize(new Dimension(left2right.getWidth(), 100));
        
        boxUnit1.setBorder(BorderFactory.createLineBorder(Color.black));
        boxUnit2.setBorder(BorderFactory.createLineBorder(Color.cyan));
        boxButtons.setBorder(BorderFactory.createLineBorder(Color.red));
        */
        
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
     * @param title: the new title
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
	 * @param titleLeft
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
	 * @param listLeft: the new combo box
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
	 * @param textLeft: the new value
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
	 * @param titleLeft
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
	 * @param listRight: the new combo box
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
	 * @param textRight: the new value
	 */
	public void setTextRight(JFormattedTextField textRight)
	{
		this.textRight = textRight;
	}
	
	
}
