package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;

public class CheckBoxGroupTutorial {
	// constructors
	//--------------------------------------------------------------
	public static CheckboxGroup chkEmptyGroup = new CheckboxGroup();
	//--------------------------------------------------------------
	public static void vCheckBoxGroupMethods() {
		// get the current choice of checkbox from the group
		Checkbox chkCurrent = chkEmptyGroup.getSelectedCheckbox();
		// set the current checkbox
		chkEmptyGroup.setSelectedCheckbox(new Checkbox("Hello", true));
		// get string representation of the checkbox group
		String strToString = chkEmptyGroup.toString();
		System.out.println(strToString);
		// some inherited methods
	}
	//-------------------------------------------------------------
	// example
	//-------------------------------------------------------------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public CheckBoxGroupTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		CheckBoxGroupTutorial  checkBoxGroupTutorial = new CheckBoxGroupTutorial();
		checkBoxGroupTutorial.showCheckBoxGroupDemo();
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

	private void showCheckBoxGroupDemo(){

		headerLabel.setText("Control in action: CheckBoxGroup"); 

		CheckboxGroup fruitGroup = new CheckboxGroup();

		Checkbox chkApple = new Checkbox("Apple",fruitGroup,true);
		Checkbox chkMango = new Checkbox("Mango",fruitGroup,false);
		Checkbox chkPeer = new Checkbox("Peer",fruitGroup,false);

		statusLabel.setText("Apple Checkbox: checked");
		chkApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {             
				statusLabel.setText("Apple Checkbox: checked");
			}
		});

		chkMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Mango Checkbox: checked");
			}
		});

		chkPeer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Peer Checkbox: checked");
			}
		});

		controlPanel.add(chkApple);
		controlPanel.add(chkMango);   
		controlPanel.add(chkPeer);       

		mainFrame.setVisible(true);  
	}
	//-------------------------------------------------------------
}
