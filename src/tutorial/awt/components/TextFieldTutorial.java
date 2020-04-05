/**
 * 
 */
package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;

import javax.accessibility.AccessibleContext;

/**
 * @author hossam
 *
 */
public class TextFieldTutorial {
	// @constructors
	//--------------
	// a text field
	public static TextField txtNew = new TextField();
	// text field w/ # of columns
	public static TextField txtColumns = new TextField(8);
	// text field w/ initial text
	public static TextField txtInitial = new TextField("Initialised");
	// text field w/ initial text & # of columns
	public static TextField txtTextColumns = new TextField("Text", 8);
	// 
	//--------------
	// @methods
	//-----------------------------
	public static void vMethods() {
		// add action listener
		txtNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create peer for text field
		txtColumns.addNotify();
		// check for presence of characte set echoing
		boolean isEcho = txtInitial.echoCharIsSet();
		// get accessible context
		AccessibleContext acTextField = txtTextColumns.getAccessibleContext();
		// get array of action listeners
		ActionListener[] alArray = txtNew.getActionListeners();
		// get # of columns in text field
		int numColumns = txtColumns.getColumns();
		// get character to use for echoing
		char echo = txtInitial.getEchoChar();
		System.out.println(echo);
		// get array of listeners
		txtTextColumns.getListeners(null);
		// get minimum dimension for text field
		Dimension dmnSize = txtNew.getMinimumSize();
		// get minimum dimension for text field w/ # of columns
		dmnSize = txtColumns.getMinimumSize(8);
		// get preferred size
		dmnSize = txtInitial.getPreferredSize();
		// get preferred size of text field w/ # of columns
		dmnSize = txtTextColumns.getPreferredSize(8);
		// remove action listener
		txtNew.removeActionListener(null);
		// set # of columns 
		txtColumns.setColumns(16);
		// set echo character for the text field
		txtInitial.setEchoChar('e');
		// set text on the text field
		txtTextColumns.setText("Text");

		// some protected & inherited methods

	}
	//-----------------------------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public TextFieldTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		TextFieldTutorial  textFieldTutorial = new TextFieldTutorial();
		textFieldTutorial.showTextFieldDemo();
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

	private void showTextFieldDemo(){
		headerLabel.setText("Control in action: TextField"); 

		Label  namelabel= new Label("User ID: ", Label.RIGHT);
		Label  passwordLabel = new Label("Password: ", Label.CENTER);
		final TextField userText = new TextField(6);
		final TextField passwordText = new TextField(6);
		passwordText.setEchoChar('*');

		Button loginButton = new Button("Login");

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     
				String data = "Username: " + userText.getText();
				data += ", Password: " + passwordText.getText();
				statusLabel.setText(data);        
			}
		}); 

		controlPanel.add(namelabel);
		controlPanel.add(userText);
		controlPanel.add(passwordLabel);       
		controlPanel.add(passwordText);
		controlPanel.add(loginButton);
		mainFrame.setVisible(true);  
	}
	//---------

}
