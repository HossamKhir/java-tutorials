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
public class ComponentListenerTutorial implements ComponentListener{
	// @methods
	//---------
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ arg0.getComponent().getClass().getSimpleName() + " resized. ");
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ arg0.getComponent().getClass().getSimpleName() + " moved. ");
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ arg0.getComponent().getClass().getSimpleName() + " shown. ");
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ arg0.getComponent().getClass().getSimpleName() + " hidden. ");
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ComponentListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ComponentListenerTutorial  componentListenerTutorial = new ComponentListenerTutorial();  
		componentListenerTutorial.showComponentListenerDemo();
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

	private void showComponentListenerDemo(){
		headerLabel.setText("Listener in action: ComponentListener");      

		ScrollPane panel = new ScrollPane();      
		panel.setBackground(Color.MAGENTA);            

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
		msglabel.setForeground(Color.WHITE);
		panel.add(msglabel);

		msglabel.addComponentListener(this);      
		controlPanel.add(panel);
		mainFrame.setVisible(true);  
	}
	//---------
}
