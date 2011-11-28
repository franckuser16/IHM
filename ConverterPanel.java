/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm1;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author jeremy
 */
public class ConverterPanel extends JPanel
{
    private JLabel title;
    private JTextField left;
    private JTextField right;
    private JLabel unitLeft;
    private JLabel unitRight;
    private JButton left2right;
    private JButton right2left;
    private JComboBox comboLeft;
    private JComboBox comboRight;
    
    /**
     * 
     * @return background colors of both label which contains units
     */
    public Color getLabelsBackgroundColor()
    {
        return unitLeft.getBackground();
    }
    
    /**
     * Set colors of both label which contains units
     * @param c the new color
     */
    public void setLabelsBackgroundColor(Color c)
    {
        unitLeft.setBackground(c);
        unitRight.setBackground(c);
    }
    
    /**
     * 
     * @return background color of the title
     */
    public Color getTitlesBackgroundColor()
    {
        return title.getBackground();
    }
    
    /**
     * Set background color of the title
     * @param c new background color
     */
    public void setTitlesBackgroundColor(Color c)
    {
        title.setBackground(c);
    }
    
    /**
     * 
     * @return background color of both fields
     */
    public Color getFieldsBackgroundColor()
    {
        return left.getBackground();
    }
    
    /**
     * Set background color of both fields
     * @param c the new color
     */
    public void setFieldsBackgroundColor(Color c)
    {
        left.setBackground(c);
        right.setBackground(c);
    }
    
    /**
     * 
     * @return background color of both buttons
     */
    public Color getButtonsBackgroundColor()
    {
        return left2right.getBackground();
    }
    
    /**
     * Set background colors of both buttons
     * @param c the new color
     */
    public void setButtonsBackgroundColor(Color c)
    {
        left2right.setBackground(c);
        right2left.setBackground(c);
    }
    
    /**
     * 
     * @return background color of both ComboBoxes
     */
    public Color getCombosBackgroundColor()
    {
        return comboLeft.getBackground();
    }
    
    /**
     * Set backgrounds colors of both ComboBoxes
     * @param c the new color
     */
    public void setCombosBackgroundColor(Color c)
    {
        comboLeft.setBackground(c);
        comboRight.setBackground(c);        
    }    
    
    /**
     * 
     * @return border colors of both label which contains units
     */
    public Color getLabelsBorderColor()
    {
        UIDefaults border = UIManager.getLookAndFeelDefaults();
        
        if(unitLeft.getBorder() instanceof LineBorder)
            return border.getColor(unitLeft.getBorder());
        
        return null;
    }
    
    /**
     * Set colors of both borders label which contains units
     * @param c the new color
     */
    public void setLabelsBorderColor(Color c)
    {
        unitLeft.setBorder(BorderFactory.createLineBorder(c));
        unitRight.setBorder(BorderFactory.createLineBorder(c));
    }
    
    /**
     * 
     * @return border color of the title
     */
    public Color getTitlesBorderColor()
    {
        UIDefaults border = UIManager.getLookAndFeelDefaults();
        
        if(title.getBorder() instanceof LineBorder)
            return border.getColor(title.getBorder());
        
        return null;
    }
    
    /**
     * Set border color of the title
     * @param c new border color
     */
    public void setTitlesBorderColor(Color c)
    {
        title.setBorder(BorderFactory.createLineBorder(c));
    }
    
    /**
     * 
     * @return border color of both fields
     */
    public Color getFieldsBorderColor()
    {
        UIDefaults border = UIManager.getLookAndFeelDefaults();
        
        if(left.getBorder() instanceof LineBorder)
            return border.getColor(left.getBorder());
        
        return null;
    }
    
    /**
     * Set border color of both fields
     * @param c the new color
     */
    public void setFieldsBorderColor(Color c)
    {
        left.setBorder(BorderFactory.createLineBorder(c));
        right.setBorder(BorderFactory.createLineBorder(c));
    }
    
    /**
     * 
     * @return Border color of both buttons
     */
    public Color getButtonsBorderColor()
    {
        UIDefaults border = UIManager.getLookAndFeelDefaults();
        
        if(left2right.getBorder() instanceof LineBorder)
            return border.getColor(left2right.getBorder());
        
        return null;
    }
    
    /**
     * Set border colors of both buttons
     * @param c the new color
     */
    public void setButtonsBorderColor(Color c)
    {
        left2right.setBorder(BorderFactory.createLineBorder(c));
        right2left.setBorder(BorderFactory.createLineBorder(c));
    }
    
    /**
     * 
     * @return border color of both ComboBoxes
     */
    public Color getCombosBorderColor()
    {
        UIDefaults border = UIManager.getLookAndFeelDefaults();
        
        if(comboLeft.getBorder() instanceof LineBorder)
            return border.getColor(comboLeft.getBorder());
        
        return null;
    }
    
    /**
     * Set border colors of both ComboBoxes
     * @param c the new color
     */
    public void setCombosBorderColor(Color c)
    {
        comboLeft.setBorder(BorderFactory.createLineBorder(c));
        comboRight.setBorder(BorderFactory.createLineBorder(c));
    }
    
    /**
     * Create a new JLabel
     * @param title the text of the label
     * @return the new JLabel object
     */
    private JLabel createLabel(String title)
    {
        JLabel label = new JLabel(title);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }
    
    /**
     * To create a new title
     * @return new JLabel object
     */
    private JLabel createTitle()
    {
        JLabel label = new JLabel("Units Converter");
        label.setBackground(Color.LIGHT_GRAY);
        return label;
    }
    
    /**
     * Create a new JTextField
     * @return new JTextField
     */
    private JTextField createTextField()
    {
        JTextField textField = new JTextField("0.0");
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return new JTextField();
    }
    
    /**
     * Create a new JComboBox
     * @param o object like vector to show to users differents choice in comboBox
     * @return new JComboBox
     */
    private JComboBox createChooseBox(Object[] o)
    {
        JComboBox comboBox = new JComboBox();
        comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return new JComboBox();
    }
    
    /**
     * Create box with all that you need to build a converter
     * @param l label which contains the name of the system
     * @param c comboBox which contains all units
     * @param f text fields where user can put numbers
     * @return new box which contains all these elements
     */
    private Box createUnitsBox(JLabel l, JComboBox c, JTextField f)
    {
        return new Box(WIDTH);
    }
    
    public static void createAndShowGUI()
    {             
        JFrame myFrame = new JFrame("Checkers");
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
        
        myFrame.pack();
        myFrame.setVisible(true);               
    }        

    public static void main(String[] args)
    {
        //formule "magique" pour l'instant
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
