package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;

import javax.accessibility.AccessibleContext;

public class CheckBoxTutorial {
	// constructing checkbox
	//---------------------------------------------------------------------------------------
	// empty label checkbox
	public static Checkbox chkEmpty = new Checkbox();
	// labeled checkbox
	public static Checkbox chkLabeled = new Checkbox("I have a label");
	// labeled checkbox w/ specified state
	public static Checkbox chkDefaultTrue = new Checkbox("I am groot", true);
	// labeled checkbox w/ specified state in a checbox group
	public static CheckboxGroup chkGroup = new CheckboxGroup();
	public static Checkbox chkGrouped = new Checkbox("I belong to a group", false, chkGroup);
	public static Checkbox chkGroupedAgain = new Checkbox("Where do I go", chkGroup, true);
	//---------------------------------------------------------------------------------------
	// methods
	//------------------------------------------------------------------------
	public static void vCheckboxMethods() {
		// add item listener
		chkEmpty.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// add peer to checkbox
		chkLabeled.addNotify();
		// get accessible context of a checkbox
		AccessibleContext acCheckbox = chkDefaultTrue.getAccessibleContext();
		// get checkbox group of a certain checkbox
		CheckboxGroup chkGroupFound = chkGrouped.getCheckboxGroup();
		// get array of item listeners
		ItemListener[] ilCheckbox = chkGroupedAgain.getItemListeners();
		// get label of checkbox
		String strLabelCheckbox = chkEmpty.getLabel();
		// get array of object listeners
		chkLabeled.getListeners(null);
		/* 
		 * get array of length: 1, from checkbox, which may be:
		 *  i]	the label of the checkbox if it is selected
		 * ii]	null if the checkbox is not selected
		 *  
		 * */
		Object[] selectedObjects = chkDefaultTrue.getSelectedObjects();
		// get the state of the checkbox
		boolean chkState = chkGrouped.getState();
		// remove item listener
		chkGroupedAgain.removeItemListener(null);
		// set the checkbox group
		chkEmpty.setCheckboxGroup(chkGroupFound);
		chkLabeled.setCheckboxGroup(chkGroupFound);
		chkDefaultTrue.setCheckboxGroup(chkGroupFound);
		// set label for checkbox
		chkEmpty.setLabel("I am no longer empty");
		// set state for the checkbox
		chkLabeled.setState(true);
		// some protected methods & some inherited ones
	}
	//------------------------------------------------------------------------
	// example
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public CheckBoxTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		CheckBoxTutorial  checkBoxTutorial = new CheckBoxTutorial();
		checkBoxTutorial.showCheckBoxDemo();
	}

	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();        
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);  
	}

	private void showCheckBoxDemo(){

		headerLabel.setText("Control in action: CheckBox"); 

		Checkbox chkApple = new Checkbox("Apple");
		Checkbox chkMango = new Checkbox("Mango");
		Checkbox chkPeer = new Checkbox("Peer");


		chkApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {             
				statusLabel.setText("Apple Checkbox: " 
						+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});

		chkMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Mango Checkbox: " 
						+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});

		chkPeer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Peer Checkbox: " 
						+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});

		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);       

		mainFrame.setVisible(true);  
	}
}
