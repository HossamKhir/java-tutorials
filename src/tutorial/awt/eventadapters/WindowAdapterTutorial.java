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
public class WindowAdapterTutorial extends WindowAdapter {
	// @constructors
	//--------------
	public WindowAdapterTutorial() {
		super();	// WindowAdapter();
		prepareGUI();
	}
	//--------------
	// @methods
	//---------
	public void windowClosing(WindowEvent windowEvent){
		aboutFrame.dispose();
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Frame aboutFrame;

	public static void main(String[] args){
		WindowAdapterTutorial  windowAdapterTutorial = new WindowAdapterTutorial();        
		windowAdapterTutorial.showWindowAdapterDemo();
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

	private void showWindowAdapterDemo(){
		headerLabel.setText("Listener in action: WindowAdapter");      

		Button okButton = new Button("OK");

		aboutFrame = new Frame();
		aboutFrame.setSize(300,200);;
		aboutFrame.setTitle("WindowAdapter Demo");
		aboutFrame.addWindowListener(this);   
		aboutFrame.setLayout(new GridLayout(2, 3));
		Label msgLabel = new Label("Welcome to tutorialspoint.");
		msgLabel.setAlignment(Label.CENTER);
		msgLabel.setSize(100,100);
		aboutFrame.add(msgLabel);
		aboutFrame.add(okButton);
		aboutFrame.setVisible(true);
	}
	//---------
}
