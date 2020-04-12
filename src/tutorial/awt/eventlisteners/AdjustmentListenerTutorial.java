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
public class AdjustmentListenerTutorial implements AdjustmentListener {
	// @methods
	//---------
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText("Adjustment value: "+Integer.toString(e.getValue()));
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public AdjustmentListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		AdjustmentListenerTutorial  adjustmentListenerTutorial = new AdjustmentListenerTutorial();  
		adjustmentListenerTutorial.showAdjustmentListenerDemo();
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

	private void showAdjustmentListenerDemo(){
		headerLabel.setText("Listener in action: AdjustmentListener");      

		ScrollPane panel = new ScrollPane();      
		panel.setBackground(Color.magenta);
		panel.getHAdjustable().addAdjustmentListener(this);

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);   
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
		panel.add(msglabel);

		controlPanel.add(panel);
		mainFrame.setVisible(true);  
	}
	//---------
}
