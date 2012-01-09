import javax.swing.JLabel;

public class main 
{	
	public static void createAndShowGUI()
    {
        ui view1 = new ui();
        
        //here you can modify look and feel of all the elements 
        view1.setTitleLeft(new JLabel("Meter"));
        
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
