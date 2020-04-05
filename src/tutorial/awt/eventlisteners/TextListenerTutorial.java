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
public class TextListenerTutorial implements TextListener {
	// @methods
	//---------
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText("Entered text: " + textField.getText());
	}
	//---------
	// @example	
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private TextField textField;

	public TextListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		TextListenerTutorial  textListenerTutorial = new TextListenerTutorial();  
		textListenerTutorial.showTextListenerDemo();
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

	private void showTextListenerDemo(){
		headerLabel.setText("Listener in action: TextListener");      

		textField  = new TextField(10);

		textField.addTextListener(this);
		Button okButton = new Button("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Entered text: " 
						+ textField.getText());                
			}
		});

		controlPanel.add(textField);
		controlPanel.add(okButton);    
		mainFrame.setVisible(true);  
	}
	//---------
}
