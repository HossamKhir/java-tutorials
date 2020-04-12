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
public class WindowListenerTutorial implements WindowListener {
	// @methods
	//---------
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		aboutFrame.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Frame aboutFrame;

	public WindowListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		WindowListenerTutorial  windowListenerTutorial = new WindowListenerTutorial();  
		windowListenerTutorial.showWindowListenerDemo();
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

	private void showWindowListenerDemo(){
		headerLabel.setText("Listener in action: WindowListener");      

		Button okButton = new Button("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				aboutFrame.dispose();
			}
		});

		aboutFrame = new Frame();
		aboutFrame.setSize(300,200);;
		aboutFrame.setTitle("WindowListener Demo");
		aboutFrame.setLayout(new FlowLayout());
		aboutFrame.addWindowListener(this);

		Label msgLabel = new Label("Welcome to tutorialspoint.");
		msgLabel.setAlignment(Label.CENTER);
		msgLabel.setSize(100,100);
		aboutFrame.add(msgLabel);
		aboutFrame.add(okButton);
		aboutFrame.setVisible(true);
	}
	//---------
}
