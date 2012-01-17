package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.Controller_OtherView;


public class OtherView{
	/*
     * attributes without Getters/Setters
     */
	private JFrame converter = new JFrame("Converter");
	private Box boxTitle = new Box(BoxLayout.LINE_AXIS);
	private Box boxError = new Box(BoxLayout.LINE_AXIS);
    private Box boxAmount = new Box(BoxLayout.LINE_AXIS);
    private Box boxFrom = new Box(BoxLayout.LINE_AXIS);
    private Box boxTo = new Box(BoxLayout.LINE_AXIS);
    private Box boxConvert = new Box(BoxLayout.LINE_AXIS);
    private Box boxResult = new Box(BoxLayout.LINE_AXIS);
    
    //For the menu of the application
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    
    private Box mainBox = new Box(BoxLayout.PAGE_AXIS);	
  
    /*
     * attributes with Getters/Setters
     */
    private JLabel title = new JLabel();
    private JLabel errors = new JLabel();
    
    private JLabel amountLabel = new JLabel("Amount: ");
    private JTextField amountText = new JTextField();
    
    private JLabel fromLabel = new JLabel("From: ");
    private DefaultListModel fromModelListSystem = new DefaultListModel();
    private JList fromListSystem = new JList(fromModelListSystem);
    private JScrollPane fromPaneSystem = new JScrollPane(fromListSystem);
    private DefaultListModel fromModelListUnits = new DefaultListModel();
    private JList fromListUnits = new JList(fromModelListUnits);
    private JScrollPane fromPaneUnits = new JScrollPane(fromListUnits);
    
    private JLabel toLabel = new JLabel("To: ");
    private DefaultListModel toModelListSystem = new DefaultListModel();
    private JList toListSystem = new JList(toModelListSystem);
    private JScrollPane toPaneSystem = new JScrollPane(toListSystem);
    private DefaultListModel toModelListUnits = new DefaultListModel();
    private JList toListUnits = new JList(toModelListUnits);
    private JScrollPane toPaneUnits = new JScrollPane(toListUnits);
    
    private JButton convert = new JButton("Convert");
    
    private JLabel result = new JLabel();
    
    //menu items
    private JRadioButtonMenuItem menu_view1 = new JRadioButtonMenuItem("View 1");
    private JRadioButtonMenuItem menu_view2 = new JRadioButtonMenuItem("View 2");
    private JMenuItem menu_quit = new JMenuItem("Quit");
    
    private boolean frameVisibility;

	/**
	 * Set all the element of a default converter
	 */
    public OtherView(boolean visibility){
    	frameVisibility = visibility;
    	
    	//about JFrame...
        converter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        converter.setPreferredSize(new Dimension(550, 440));
        
        //title of application
        title.setFont(new Font("Calibri", Font.TYPE1_FONT, 20));
        title.setForeground(Color.ORANGE);
        title.setText("Converter");
        
        //look&feel errors messages
        errors.setForeground(Color.RED);
    	        
        //text field for amount
        amountText.setPreferredSize(new Dimension(250, 25));
        amountText.setMaximumSize(amountText.getPreferredSize());
        
        //remove focusable's option for conversion's button
        convert.setFocusable(false);
        
        //set size for JList
        fromPaneSystem.setPreferredSize(new Dimension(250, 80));
        fromPaneSystem.setMaximumSize(fromPaneSystem.getPreferredSize());
        toPaneSystem.setPreferredSize(new Dimension(250, 80));
        toPaneSystem.setMaximumSize(fromPaneSystem.getPreferredSize());
        fromPaneUnits.setPreferredSize(new Dimension(250, 80));
        fromPaneUnits.setMaximumSize(fromPaneSystem.getPreferredSize());
        toPaneUnits.setPreferredSize(new Dimension(250, 80));
        toPaneUnits.setMaximumSize(fromPaneSystem.getPreferredSize());
    }
    
    /**
     * This method should be call when you have finished modifications on controls.
     * It pastes elements together
     */
    public void buildUI(){	
    	menu_view2.setSelected(true);
    	menu_view2.setEnabled(false);
    	
    	boxError.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	//only ONE selection on the list
    	fromListSystem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        toListSystem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fromListUnits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        toListUnits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    	//listeners
        Controller_OtherView controller = new Controller_OtherView(this);
        menu_quit.addActionListener(controller);
    	menu_view2.addActionListener(controller);
    	menu_view1.addActionListener(controller);
    	convert.addActionListener(controller);
    	fromListSystem.addListSelectionListener(controller);
    	toListSystem.addListSelectionListener(controller);
    	fromListUnits.addListSelectionListener(controller);
    	toListUnits.addListSelectionListener(controller);
    	
    	//open menu when you press ALT + M
    	menu.setMnemonic(KeyEvent.VK_M);
    	//ALT + ENTER to convert
    	convert.setMnemonic(KeyEvent.VK_ENTER);
    	//ALT + 1 for view 1
    	menu_view1.setMnemonic(KeyEvent.VK_1);
    	//ALT + 2 for view 2
    	menu_view2.setMnemonic(KeyEvent.VK_2);
    	//ALT + Q to quit
    	menu_quit.setMnemonic(KeyEvent.VK_Q);
    	
    	boxTitle.add(Box.createGlue());
    	boxTitle.add(title);
    	boxTitle.add(Box.createGlue());
    	
    	boxError.add(Box.createGlue());
    	boxError.add(errors);
    	boxError.add(Box.createGlue());
    	
    	boxAmount.add(Box.createGlue());
    	boxAmount.add(amountLabel);
    	boxAmount.add(amountText);
    	boxAmount.add(Box.createGlue());
    	
    	boxFrom.add(Box.createGlue());
    	boxFrom.add(fromLabel);
    	boxFrom.add(fromPaneSystem);
    	boxFrom.add(fromPaneUnits);
    	boxFrom.add(Box.createGlue());
    	
    	boxTo.add(Box.createGlue());
    	boxTo.add(toLabel);
    	boxTo.add(toPaneSystem);
    	boxTo.add(toPaneUnits);
    	boxTo.add(Box.createGlue());
    	
    	boxConvert.add(Box.createGlue());
    	boxConvert.add(convert);
    	boxConvert.add(Box.createGlue());
    	
    	boxResult.add(Box.createGlue());
    	boxResult.add(result);
    	boxResult.add(Box.createGlue());
    	
    	mainBox.add(boxTitle);
    	mainBox.add(boxError);
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
        converter.setLocationRelativeTo(null);
        converter.pack();
        converter.setVisible(frameVisibility);
    }

	public JButton getConvert(){
		return convert;
	}

	public void setConvert(JButton convert){
		this.convert = convert;
	}

	public JRadioButtonMenuItem getMenu_view1(){
		return menu_view1;
	}

	public void setMenu_view1(JRadioButtonMenuItem menu_view1){
		this.menu_view1 = menu_view1;
	}

	public JRadioButtonMenuItem getMenu_view2(){
		return menu_view2;
	}

	public void setMenu_view2(JRadioButtonMenuItem menu_view2){
		this.menu_view2 = menu_view2;
	}

	public JMenuItem getMenu_quit(){
		return menu_quit;
	}

	public void setMenu_quit(JMenuItem menu_quit){
		this.menu_quit = menu_quit;
	}

	public JLabel getResult(){
		return result;
	}

	public void setResult(JLabel result){
		this.result = result;
	}

	public JFrame getConverter()
	{
		return converter;
	}

	public JLabel getErrors(){
		return errors;
	}

	public void setErrors(JLabel errors){
		this.errors = errors;
	}

	public JTextField getAmountText(){
		return amountText;
	}

	public void setAmountText(JTextField amountText){
		this.amountText = amountText;
	}

	public DefaultListModel getFromModelListSystem()
	{
		return fromModelListSystem;
	}

	public DefaultListModel getFromModelListUnits()
	{
		return fromModelListUnits;
	}

	public DefaultListModel getToModelListSystem()
	{
		return toModelListSystem;
	}

	public DefaultListModel getToModelListUnits()
	{
		return toModelListUnits;
	}

	public JList getFromListSystem()
	{
		return fromListSystem;
	}

	public JList getFromListUnits()
	{
		return fromListUnits;
	}

	public JList getToListSystem()
	{
		return toListSystem;
	}

	public JList getToListUnits()
	{
		return toListUnits;
	}
	
}
