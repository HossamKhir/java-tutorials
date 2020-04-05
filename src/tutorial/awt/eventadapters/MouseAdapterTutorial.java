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
public class MouseAdapterTutorial extends MouseAdapter {
	// @constructors
	//--------------
	public MouseAdapterTutorial() {
		super();	// MouseAdapter();
		prepareGUI();
	}
	//--------------
	// @methods
	//---------
	public void mouseClicked(MouseEvent e) {
		statusLabel.setText("Mouse Clicked: ("
				+e.getX()+", "+e.getY() +")");
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public static void main(String[] args){
		MouseAdapterTutorial  mouseAdapterTutorial = new MouseAdapterTutorial();  
		mouseAdapterTutorial.showMouseAdapterDemo();
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

	private void showMouseAdapterDemo(){
		headerLabel.setText("Listener in action: MouseAdapter");      

		Panel panel = new Panel();      
		panel.setBackground(Color.magenta);
		panel.setLayout(new FlowLayout());        
		panel.addMouseListener(this);

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");

		msglabel.addMouseListener(this);
		panel.add(msglabel);
		controlPanel.add(panel);
		mainFrame.setVisible(true);  
	}
	//---------
}
