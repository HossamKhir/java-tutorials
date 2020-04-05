/**
 * 
 */
package tutorial.awt.layoutmanagers;

import java.awt.*;
import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class FlowLayoutTutorial {
	// @fields
	//--------
	public static int[] fields = {
			FlowLayout.CENTER,		// rows centred 
			FlowLayout.LEADING,		// rows justified to leading edge of orientation
			FlowLayout.LEFT,		// rows justified left
			FlowLayout.RIGHT,		// rows justified right
			FlowLayout.TRAILING,	// rows justified to trailing edge of orientation
	};
	//--------
	// @constructors
	//--------------
	// default flow layout (centre alignment, 5 unit gaps horizontal & vertical)
	public static FlowLayout flDefault = new FlowLayout();
	// flow layout w/ default 5 unit gap & specific alignment
	public static FlowLayout flAlign = new FlowLayout(FlowLayout.RIGHT);
	// flow layout w/ alignment, vertical & horizontal gaps
	public static FlowLayout flGap = new FlowLayout(FlowLayout.LEADING, 4, 8);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// add component to layout
		flDefault.addLayoutComponent("Button", new Button("Button"));
		// get alignment
		int align = flAlign.getAlignment();
		System.out.println(align);
		// get horizontal gap
		align = flGap.getHgap();
		// get vertical gap
		align = flDefault.getVgap();
		// layout a container w/ this layout
		flAlign.layoutContainer(new Frame());
		// get min size
		Dimension size = flGap.minimumLayoutSize(new Frame());
		// get preferred size
		size = flDefault.preferredLayoutSize(new Frame());
		// remove component from layout
		flAlign.removeLayoutComponent(null);
		// set alignment for layout
		flGap.setAlignment(align);
		// set horizontal gap
		flDefault.setHgap(align);
		// set vertical gap
		flAlign.setVgap(align);
		// get layout as string
		System.out.println(flGap.toString());

		// some inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Label msglabel;

	public FlowLayoutTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		FlowLayoutTutorial  flowLayoutTutorial = new FlowLayoutTutorial();  
		flowLayoutTutorial.showFlowLayoutDemo();       
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

		msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);  
	}

	private void showFlowLayoutDemo(){
		headerLabel.setText("Layout in action: FlowLayout");      

		Panel panel = new Panel();
		panel.setBackground(Color.darkGray);
		panel.setSize(200,200);
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);              
		layout.setVgap(10);
		panel.setLayout(layout);        
		panel.add(new Button("OK"));
		panel.add(new Button("Cancel"));       

		controlPanel.add(panel);

		mainFrame.setVisible(true);  
	}
	//---------
}
