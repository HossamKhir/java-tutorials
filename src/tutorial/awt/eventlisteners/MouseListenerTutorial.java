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
public class MouseListenerTutorial implements MouseListener {
	// @methods
	//---------
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText("Mouse Clicked: ("
				+e.getX()+", "+e.getY() +")");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public MouseListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		MouseListenerTutorial  mouseListenerTutorial = new MouseListenerTutorial();  
		mouseListenerTutorial.showMouseListenerDemo();
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

	private void showMouseListenerDemo(){
		headerLabel.setText("Listener in action: MouseListener");      

		Panel panel = new Panel();      
		panel.setBackground(Color.magenta);
		panel.setLayout(new FlowLayout());        
		panel.addMouseListener(this);

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
		msglabel.setForeground(Color.WHITE);

		msglabel.addMouseListener(this);
		panel.add(msglabel);

		controlPanel.add(panel);

		mainFrame.setVisible(true);  
	}
	//---------
}
