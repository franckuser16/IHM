//package IHM.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

/**
 *
 * @author jeremy
 */
public class ui
{
    private static JFrame converter = new JFrame("Converter");
    private static JLabel title = new JLabel("Metric to Imperial Length Converter");
    private static Box boxNorth = new Box(BoxLayout.X_AXIS);
    private static Box boxCenter = new Box(BoxLayout.X_AXIS);
    private static Box boxUnit1 = new Box(BoxLayout.Y_AXIS);
    private static Box boxUnit2 = new Box(BoxLayout.Y_AXIS);
    private static Box boxButtons = new Box(BoxLayout.Y_AXIS);
    
    private final static Dimension sizeControls = new Dimension(250, 25);
    
    public static void createAndShowGUI()
    {
        converter.setLocationRelativeTo(null);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setPreferredSize(new Dimension(450, 200));

        //box which contains title
        boxNorth.add(Box.createGlue());
        boxNorth.add(title);
        boxNorth.add(Box.createGlue());

        //elements of first unit box
        JLabel titleLeft = new JLabel("Unit 1");
        
        JComboBox listLeft = new JComboBox();
        listLeft.setPreferredSize(sizeControls);
        listLeft.setMaximumSize(listLeft.getPreferredSize());
        
        JFormattedTextField textLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
        textLeft.setPreferredSize(sizeControls);        
        textLeft.setMaximumSize(textLeft.getPreferredSize());
        
        //boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(Box.createGlue());
        boxUnit1.add(titleLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 10)));
        boxUnit1.add(listLeft);
        boxUnit1.add(Box.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);
        boxUnit1.add(Box.createGlue());

        //elements of button's box
        JButton left2right = new JButton("-->");
        JButton right2left = new JButton("<--");
        boxButtons.add(Box.createGlue());
        boxButtons.add(left2right);
        boxButtons.add(Box.createRigidArea(new Dimension(0, 20)));
        boxButtons.add(right2left);
        boxButtons.add(Box.createGlue());

        //elements of second unit box
        JLabel titleRight = new JLabel("Unit 2");
        
        JComboBox listRight = new JComboBox();
        listRight.setPreferredSize(sizeControls);
        listRight.setMaximumSize(listRight.getPreferredSize());
        
        JFormattedTextField textRight = new JFormattedTextField(NumberFormat.getNumberInstance());
        textRight.setPreferredSize(sizeControls);
        textRight.setMaximumSize(textRight.getPreferredSize());
        
        //boxUnit2.add(Box.createRigidArea(new Dimension(0, 20)));
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

        converter.add(boxNorth, BorderLayout.NORTH);
        converter.add(boxCenter, BorderLayout.CENTER);
        converter.pack();
        converter.setVisible(true);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
