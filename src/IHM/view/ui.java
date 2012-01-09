//package IHM.view;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

/**
 *
 * @author jeremy
 */
public class ui
{
	private static JFrame converter = new JFrame("Converter");
    private Box boxUnit1 = new Box(BoxLayout.Y_AXIS);
    private Box boxUnit2 = new Box(BoxLayout.Y_AXIS);
    private Box boxButtons = new Box(BoxLayout.Y_AXIS);
    
    //attributes with accessors
    private Box boxNorth = new Box(BoxLayout.X_AXIS);
    private Box boxCenter = new Box(BoxLayout.X_AXIS);
    private JLabel title = new JLabel("Metric to Imperial Length Converter");
    
    private JLabel titleLeft = new JLabel("Unit 1");
    private JComboBox listLeft = new JComboBox();
    private JFormattedTextField textLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
    
    private JLabel titleRight = new JLabel("Unit 2");
    private JComboBox listRight = new JComboBox();
    private JFormattedTextField textRight = new JFormattedTextField(NumberFormat.getNumberInstance());

	private final static Dimension sizeControls = new Dimension(250, 25);
    
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
        JButton left2right = new JButton("-->");
        JButton right2left = new JButton("<--");
        boxButtons.add(Box.createGlue());
        boxButtons.add(left2right);
        boxButtons.add(Box.createRigidArea(new Dimension(0, 20)));
        boxButtons.add(right2left);
        boxButtons.add(Box.createGlue());

        //elements of second unit box        
        listRight.setPreferredSize(sizeControls);
        listRight.setMaximumSize(listRight.getPreferredSize());
        
        //JFormattedTextField textRight = new JFormattedTextField(NumberFormat.getNumberInstance());
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

        //element of center box
        boxCenter.add(Box.createGlue());
        boxCenter.add(boxUnit1);
        boxCenter.add(Box.createHorizontalStrut(20));
        boxCenter.add(boxButtons);
        boxCenter.add(Box.createHorizontalStrut(20));
        boxCenter.add(boxUnit2);
        boxCenter.add(Box.createGlue());
        
        //add boxes to frame
        converter.add(boxNorth, BorderLayout.NORTH);
        converter.add(boxCenter, BorderLayout.CENTER);
        converter.pack();
        converter.setVisible(true);
    }

    /**
     * 
     * @return the box North which contains the title 
     */
	public Box getBoxNorth() 
	{
		return boxNorth;
	}

	/**
	 * 
	 * @return the center box which contains all the controls of conversion
	 */
	public Box getBoxCenter()
	{
		return boxCenter;
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
		//delete the old title 
		this.boxNorth.removeAll();
		//insert the new
		boxNorth.add(Box.createGlue());
        boxNorth.add(title);
        boxNorth.add(Box.createGlue());
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

	public JComboBox getListLeft()
	{
		return listLeft;
	}

	public void setListLeft(JComboBox listLeft)
	{
		this.listLeft = listLeft;
	}

	public JFormattedTextField getTextLeft()
	{
		return textLeft;
	}

	public void setTextLeft(JFormattedTextField textLeft)
	{
		this.textLeft = textLeft;
	}

	public JLabel getTitleRight()
	{
		return titleRight;
	}

	public void setTitleRight(JLabel titleRight)
	{
		this.titleRight = titleRight;
	}

	public JComboBox getListRight()
	{
		return listRight;
	}

	public void setListRight(JComboBox listRight)
	{
		this.listRight = listRight;
	}

	public JFormattedTextField getTextRight()
	{
		return textRight;
	}

	public void setTextRight(JFormattedTextField textRight)
	{
		this.textRight = textRight;
	}
	
	
}
