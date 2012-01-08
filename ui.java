
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public static void createAndShowGUI()
    {
        converter.setLocationRelativeTo(null);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setPreferredSize(new Dimension(450, 200));

        //box which contains title
        boxNorth.add(boxNorth.createGlue());
        boxNorth.add(title);
        boxNorth.add(boxNorth.createGlue());

        //elements of first unit box
        JLabel titleLeft = new JLabel("Unit 1");
        JComboBox listLeft = new JComboBox();
        JTextField textLeft = new JTextField("0.0");
        boxUnit1.add(boxUnit1.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(titleLeft);
        boxUnit1.add(boxUnit1.createRigidArea(new Dimension(0, 10)));
        boxUnit1.add(listLeft);
        boxUnit1.add(boxUnit1.createRigidArea(new Dimension(0, 20)));
        boxUnit1.add(textLeft);

        //elements of button's box
        JButton left2right = new JButton("-->");
        JButton right2left = new JButton("<--");
        boxButtons.add(boxButtons.createGlue());
        boxButtons.add(left2right);
        boxButtons.add(boxButtons.createRigidArea(new Dimension(0, 20)));
        boxButtons.add(right2left);
        boxButtons.add(boxButtons.createGlue());

        //elements of second unit box
        JLabel titleRight = new JLabel("Unit 2");
        JComboBox listRight = new JComboBox();
        JTextField textRight = new JTextField("0.0");
        boxUnit2.add(boxUnit2.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(titleRight);
        boxUnit2.add(boxUnit2.createRigidArea(new Dimension(0, 10)));
        boxUnit2.add(listRight);
        boxUnit2.add(boxUnit2.createRigidArea(new Dimension(0, 20)));
        boxUnit2.add(textRight);

        //element of center box
        boxCenter.add(boxCenter.createGlue());
        boxCenter.add(boxUnit1);
        boxCenter.add(boxCenter.createHorizontalStrut(20));
        boxCenter.add(boxButtons);
        boxCenter.add(boxCenter.createHorizontalStrut(20));
        boxCenter.add(boxUnit2);
        boxCenter.add(boxCenter.createGlue());

        converter.add(boxNorth, BorderLayout.NORTH);
        converter.add(boxCenter, BorderLayout.CENTER);
        converter.pack();
        converter.setVisible(true);
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
