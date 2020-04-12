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
public class MouseMotionListenerTutorial implements MouseMotionListener {
	// @methods
	//---------
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText("Mouse Dragged: ("+e.getX()+", "+e.getY() +")");

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText("Mouse Moved: ("+e.getX()+", "+e.getY() +")");
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public MouseMotionListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		MouseMotionListenerTutorial  mouseMotionListenerTutorial = new MouseMotionListenerTutorial();  
		mouseMotionListenerTutorial.showMouseMotionListenerDemo();
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

	private void showMouseMotionListenerDemo(){
		headerLabel.setText("Listener in action: MouseMotionListener");      

		Panel panel = new Panel();      
		panel.setBackground(Color.magenta);
		panel.setLayout(new FlowLayout());        
		panel.addMouseMotionListener(this);

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
		panel.add(msglabel);

		controlPanel.add(panel);

		mainFrame.setVisible(true);  
	}   
	//---------
}
