import javax.swing.JLabel;

public class main 
{	
	public static void createAndShowGUI()
    {
        DefaultView view1 = new DefaultView();
        
        //here you can modify look and feel of all the elements 
        view1.setTitleLeft(new JLabel("Meter"));
        view1.setTitle(new JLabel("Mon nouveau titre"));
        
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
