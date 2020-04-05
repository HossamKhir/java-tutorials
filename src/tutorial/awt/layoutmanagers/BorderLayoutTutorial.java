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
public class BorderLayoutTutorial {
	// @fields
	//--------
	public static String[] fields = {
			BorderLayout.AFTER_LAST_LINE,		// PAGE_END
			BorderLayout.AFTER_LINE_ENDS,		// LINE_END
			BorderLayout.BEFORE_FIRST_LINE,		// PAGE_START
			BorderLayout.BEFORE_LINE_BEGINS,	// LINE_START
			BorderLayout.CENTER,				// middle of container
			BorderLayout.EAST,					// right side of container
			BorderLayout.LINE_END,				// end of line direction of container
			BorderLayout.LINE_START,			// beginning of line direction of container
			BorderLayout.NORTH,					// top of container
			BorderLayout.PAGE_END,				// after last line of content
			BorderLayout.PAGE_START,			// before first line of content
			BorderLayout.SOUTH,					// bottom of container
			BorderLayout.WEST,					// left side of container
	};
	//--------
	// @constructors
	//--------------
	// border layout w/ no gaps
	public static BorderLayout blGapless = new BorderLayout();
	// border layout w/ gaps
	public static BorderLayout blGaps = new BorderLayout(4, 8);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// add component to layout w/ constraints
		blGapless.addLayoutComponent(new Label(), new Object());
		// if using per-component string, add component w/ string (deprecated)
		//		blGaps.addLayoutComponent("Name", new Button("Name"));
		// get horizontal gap
		int gap = blGaps.getHgap();
		// get x alignment
		float align = blGapless.getLayoutAlignmentX(new Frame());
		System.out.println(align);
		// get y alignment
		align = blGaps.getLayoutAlignmentY(new Frame());
		// get vertical gap
		gap = blGapless.getVgap();
		// invalidate layout
		blGaps.invalidateLayout(new Frame());
		// Lay out the container argument w/ this border layout
		blGapless.layoutContainer(new Frame());
		// get max size
		Dimension size = blGaps.maximumLayoutSize(new Frame());
		// get min size
		size = blGapless.minimumLayoutSize(new Frame());
		// remove component from layout
		blGaps.removeLayoutComponent(null);
		// set horizontal gap
		blGapless.setHgap(gap);
		// set vertical gap
		blGaps.setVgap(gap);
		// get layout as string
		System.out.println(blGapless.toString());

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

	public BorderLayoutTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		BorderLayoutTutorial  borderLayoutTutorial = new BorderLayoutTutorial();  
		borderLayoutTutorial.showBorderLayoutDemo();       
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

	private void showBorderLayoutDemo(){
		headerLabel.setText("Layout in action: BorderLayout");      

		Panel panel = new Panel();
		panel.setBackground(Color.darkGray);
		panel.setSize(300,300);
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);        

		panel.add(new Button("Center"),BorderLayout.CENTER);
		panel.add(new Button("Line Start"),BorderLayout.LINE_START); 
		panel.add(new Button("Line End"),BorderLayout.LINE_END);
		panel.add(new Button("East"),BorderLayout.EAST);   
		panel.add(new Button("West"),BorderLayout.WEST); 
		panel.add(new Button("North"),BorderLayout.NORTH); 
		panel.add(new Button("South"),BorderLayout.SOUTH);

		controlPanel.add(panel);

		mainFrame.setVisible(true);  
	}
	//---------
}
