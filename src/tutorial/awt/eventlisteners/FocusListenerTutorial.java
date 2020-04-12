/**
 * 
 */
package tutorial.awt.eventlisteners;

import java.awt.*;
import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class FocusListenerTutorial implements FocusListener {
	// @methods
	//---------
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ e.getComponent().getClass().getSimpleName() + " gained focus. ");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ e.getComponent().getClass().getSimpleName() + " lost focus. ");
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public FocusListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		FocusListenerTutorial  focusListenerTutorial = new FocusListenerTutorial();  
		focusListenerTutorial.showFocusListenerDemo();
	}

	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 6));
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


	private void showFocusListenerDemo(){

		headerLabel.setText("Listener in action: FocusListener");      

		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");
		okButton.addFocusListener(this);  
		cancelButton.addFocusListener(this);  

		controlPanel.add(okButton);
		controlPanel.add(cancelButton);     
		mainFrame.setVisible(true);  
	}
	//---------
}
