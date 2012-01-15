import view.DefaultView;

public class Main 
{	
	public static void createAndShowGUI()
    {
        DefaultView view = new DefaultView(false);
        
        view.buildUI();
        
        view.getMenu_view1().setEnabled(true);
        
        //This does the same thing as if a user have click on "View1" in the menu.
        //So it initializes the application via the controller; 
        view.getMenu_view1().doClick();
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
