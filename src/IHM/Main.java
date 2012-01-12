import view.OtherView;

public class Main 
{	
	public static void createAndShowGUI()
    {
        OtherView view = new OtherView(false);
        view.buildUI();
        
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
