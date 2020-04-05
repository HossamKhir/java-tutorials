/**
 * 
 */
package tutorial.awt.eventadapters;

import java.awt.*;
import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class KeyAdapterTutorial extends KeyAdapter {
	// @constructors
	//--------------
	public KeyAdapterTutorial() {
		super();	// KeyAdapter();
		prepareGUI();
	}
	//--------------
	// @methods
	//---------
	public void keyPressed(KeyEvent e) {                
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			statusLabel.setText("Entered text: " + textField.getText());
		}
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private TextField textField;

	public static void main(String[] args){
		KeyAdapterTutorial  keyAdapterTutorial = new KeyAdapterTutorial();        
		keyAdapterTutorial.showKeyAdapterDemo();
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

	private void showKeyAdapterDemo(){
		headerLabel.setText("Listener in action: KeyAdapter");      

		textField = new TextField(10);
		textField.addKeyListener(this);
		Button okButton = new Button("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Entered text: " + textField.getText());                
			}
		});

		controlPanel.add(textField);
		controlPanel.add(okButton);    
		mainFrame.setVisible(true);  
	}

	//---------
}
