import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import view.DefaultView;

public class Main 
{	
	public static void createAndShowGUI()
    {
        DefaultView view1 = new DefaultView();
        
        /*
         * here you can modify look and feel of all the elements 
         */
        view1.setTitleLeft(new JLabel("Meter"));
        
        Object[] units = new Object[]{"m","cm","mm","µm"};
        JComboBox leftCombo = new JComboBox(units);
        leftCombo.setPreferredSize(new Dimension(250, 25));
        leftCombo.setMaximumSize(leftCombo.getPreferredSize());
        view1.setListLeft(leftCombo);
        /*
         * 
         */
        
        view1.buildUI();
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
