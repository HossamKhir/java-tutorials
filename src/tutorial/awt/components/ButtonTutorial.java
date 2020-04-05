package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;

import javax.accessibility.AccessibleContext;

public class ButtonTutorial {
	// constructing buttons
	//---------------------------------------------------------
	// empty text button
	public static Button btnEmptyButton = new Button();
	// text filled button
	public static Button btnTextedButton = new Button("Hello");
	//---------------------------------------------------------
	// button methods
	public static void vButtonMethods() {
		// add action listener to receive actions
		btnEmptyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// create peer for the button
		btnTextedButton.addNotify();
		// get accessible context
		AccessibleContext acButton = btnEmptyButton.getAccessibleContext();
		// get action command name of the event fired
		String str = btnTextedButton.getActionCommand();
		// get array of action listeners bound to the button
		ActionListener[] alArray = btnEmptyButton.getActionListeners();
		// get label of the button
		str = btnTextedButton.getLabel();
		// get array of listener objects
		btnEmptyButton.getListeners(null);
		// remove an action listener
		btnTextedButton.removeActionListener(null);
		// set action command name
		btnEmptyButton.setActionCommand("Command name");
		// set label for button
		btnTextedButton.setLabel("Label name");
		// some protected methods & some inherited methods
	}
	//-----------------------------------------------------------------
	// example

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ButtonTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ButtonTutorial  buttonTutorial = new ButtonTutorial();
		buttonTutorial.showButtonDemo();
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

	private void showButtonDemo(){
		headerLabel.setText("Control in action: Button"); 

		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Ok Button clicked.");
			}
		});

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Submit Button clicked.");
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Cancel Button clicked.");
			}
		});

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);       

		mainFrame.setVisible(true);  
	}

}
