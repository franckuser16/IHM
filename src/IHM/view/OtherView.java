package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import controller.Controller_OtherView;


public class OtherView
{
	/*
     * attributes without Getters/Setters
     */
	private JFrame converter = new JFrame("Converter");
	
	//For the menu of the application
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    
    private Box boxTitle = new Box(BoxLayout.LINE_AXIS);	//unit box on left
    private Box boxAmount = new Box(BoxLayout.LINE_AXIS);	//unit box on left
    private Box boxFrom = new Box(BoxLayout.LINE_AXIS);	//unit box on right
    private Box boxTo = new Box(BoxLayout.LINE_AXIS);	//box which contains button to convert
    private Box boxConvert = new Box(BoxLayout.LINE_AXIS);	//box which contains button to convert
    private Box boxResult = new Box(BoxLayout.LINE_AXIS);	//box which contains button to convert
    
    private Box mainBox = new Box(BoxLayout.PAGE_AXIS);	
  
    /*
     * attributes with Getters/Setters
     */
    private JLabel title = new JLabel();
    
    private JLabel amountLabel = new JLabel("Amount: ");
    private JFormattedTextField amountText = new JFormattedTextField(NumberFormat.getNumberInstance());
    
    private JLabel fromLabel = new JLabel("From: ");
    private JList fromList = new JList();
    private JScrollPane fromPane = new JScrollPane(fromList);
    
    private JLabel toLabel = new JLabel("To: ");
    private JList toList = new JList();
    private JScrollPane toPane = new JScrollPane(toList);
    
    private JButton convert = new JButton("Convert");
    
    private JLabel result = new JLabel();
    
    //menu items
    private JMenuItem menu_view1 = new JMenuItem("View 1");
    private JMenuItem menu_view2 = new JMenuItem("View 2");
    private JMenuItem menu_quit = new JMenuItem("Quit");

	/**
	 * Set all the element of a default converter
	 */
    public OtherView()
    {
    	//about JFrame...
    	converter.setLocationRelativeTo(null);
        converter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        converter.setPreferredSize(new Dimension(300, 350));
        
        title.setFont(new Font("Calibri", Font.TYPE1_FONT, 20));
        title.setForeground(Color.ORANGE);
        title.setText("Converter");
    	        
        amountText.setPreferredSize(new Dimension(250, 25));
        amountText.setMaximumSize(amountText.getPreferredSize());
        
        convert.setFocusable(false);
        
        /*
         * Pour les tests
         */
        String[] data = {"one", "two", "three", "four", "teeeeeeeeeeest"};
        fromList.setListData(data);
        toList.setListData(data);   
    }
    
    /**
     * This method should be call when you have finish modification on controls.
     * It paste the elements together
     */
    public void buildUI()
    {	
    	//only ONE selection on the list
    	fromList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        toList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fromList.setVisibleRowCount(1);
        toList.setVisibleRowCount(1);
        
    	/*
    	 * listeners
    	 */
        menu_quit.addActionListener(new Controller_OtherView(this));
    	menu_view2.addActionListener(new Controller_OtherView(this));
    	menu_view1.addActionListener(new Controller_OtherView(this));
    	convert.addActionListener(new Controller_OtherView(this));
    	fromList.addListSelectionListener(new Controller_OtherView(this));
    	toList.addListSelectionListener(new Controller_OtherView(this));
    	
    	//open menu when you press ALT + M
    	menu.setMnemonic(KeyEvent.VK_M);
    	//ALT + ENTER to convert
    	convert.setMnemonic(KeyEvent.VK_ENTER);
    	
    	boxTitle.add(Box.createGlue());
    	boxTitle.add(title);
    	boxTitle.add(Box.createGlue());
    	
    	boxAmount.add(Box.createGlue());
    	boxAmount.add(amountLabel);
    	boxAmount.add(amountText);
    	boxAmount.add(Box.createGlue());
    	
    	boxFrom.add(Box.createGlue());
    	boxFrom.add(fromLabel);
    	boxFrom.add(fromPane);
    	boxFrom.add(Box.createGlue());
    	
    	boxTo.add(Box.createGlue());
    	boxTo.add(toLabel);
    	boxTo.add(toPane);
    	boxTo.add(Box.createGlue());
    	
    	boxConvert.add(Box.createGlue());
    	boxConvert.add(convert);
    	boxConvert.add(Box.createGlue());
    	
    	boxResult.add(Box.createGlue());
    	boxResult.add(result);
    	boxResult.add(Box.createGlue());
    	
    	mainBox.add(boxTitle);
    	mainBox.add(boxAmount);
    	mainBox.add(boxFrom);
    	mainBox.add(boxTo);
    	mainBox.add(boxConvert);
    	mainBox.add(boxResult);
        
        //Menu
        menu.add(menu_view1);
        menu.add(menu_view2);
        menu.add(new JSeparator());
        menu.add(menu_quit);
        menuBar.add(menu);                
        
        //add boxes and menu to frame
        converter.setJMenuBar(menuBar);
        converter.add(mainBox, BorderLayout.CENTER);
        
        converter.setMinimumSize(converter.getPreferredSize());
        converter.pack();
        converter.setVisible(true);
    }

	public JButton getConvert()
	{
		return convert;
	}

	public void setConvert(JButton convert)
	{
		this.convert = convert;
	}

	public JMenuItem getMenu_view1()
	{
		return menu_view1;
	}

	public void setMenu_view1(JMenuItem menu_view1)
	{
		this.menu_view1 = menu_view1;
	}

	public JMenuItem getMenu_view2()
	{
		return menu_view2;
	}

	public void setMenu_view2(JMenuItem menu_view2)
	{
		this.menu_view2 = menu_view2;
	}

	public JMenuItem getMenu_quit()
	{
		return menu_quit;
	}

	public void setMenu_quit(JMenuItem menu_quit)
	{
		this.menu_quit = menu_quit;
	}

	public JLabel getResult()
	{
		return result;
	}

	public void setResult(JLabel result)
	{
		this.result = result;
	}
    
	public JList getFromList()
	{
		return fromList;
	}

	public void setFromList(JList fromList)
	{
		this.fromList = fromList;
	}

	public JList getToList()
	{
		return toList;
	}

	public void setToList(JList toList)
	{
		this.toList = toList;
	}

	//Getters JFrame
	public JFrame getConverter()
	{
		return converter;
	}
}
