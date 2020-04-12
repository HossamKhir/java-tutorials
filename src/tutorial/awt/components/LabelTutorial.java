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
public class LabelTutorial {
	// @fields
	//--------
	static int[] fields = {
		Label.CENTER,
		Label.LEFT,
		Label.RIGHT,
	};
	//--------
	// constructing labels
	//-------------------------------------------------------------------------------------
	// empty label
	public static Label lblEmptyLabel = new Label();	// constructing empty label
	// label with left-justified string
	public static Label lblLeftJustifiedLabel = new Label("I am left justified");
	// label with custom alignment
	public static Label lblCustomAlignmentLabelCentre = new Label("I am center justified", Label.CENTER);
	public static Label lblCustomAlignmentLabelRight	= new Label("I am right justified", Label.RIGHT);
	//-------------------------------------------------------------------------------------
	// methods
	//-------------------------------------------------------------------------------------
	public static void vLabelMethods() {
		// create a peer for label, to change appearance without affecting functionality
		lblEmptyLabel.addNotify();
		// get accessible context of the label
		AccessibleContext acLeft = lblLeftJustifiedLabel.getAccessibleContext();
		// get alignment of the label
		int iAlignmentCentre = lblCustomAlignmentLabelCentre.getAlignment();
		// get the text of the label
		String strTextRight = lblCustomAlignmentLabelRight.getText();
		// set alignment for label
		lblEmptyLabel.setAlignment(Label.CENTER);
		// set text for label
		lblEmptyLabel.setText("I am no longer empty, you d*ck");
		// other inherited methods
	}
	//-------------------------------------------------------------------------------------
	// example
	//------------------------------------------------------------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public LabelTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		LabelTutorial  labelTutorial = new LabelTutorial();
		labelTutorial.showLabelDemo();
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

	private void showLabelDemo(){
		headerLabel.setText("Control in action: Label");      

		Label label = new Label();
		label.setText("Welcome to TutorialsPoint AWT Tutorial.");
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.GRAY);
		label.setForeground(Color.WHITE);
		controlPanel.add(label);

		mainFrame.setVisible(true);  
	}
	//------------------------------------------------------------
}
