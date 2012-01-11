import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class KeyBoardController implements ActionListener, MouseListener 
{	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("left2right")
		{
			this.setTextLeft("12");
		}
	}
}