import view.DefaultView;

/**
*
* @author Jérémy Filhoulaud
*/
public class Main 
{	
	public static void createAndShowGUI()
    {
        DefaultView view = new DefaultView(false);
        
        view.buildUI();
        
        view.getMenu_view1().setEnabled(true);
        
        //Simule le clic d'un utilisateur sur le bouton View1 du menu
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
