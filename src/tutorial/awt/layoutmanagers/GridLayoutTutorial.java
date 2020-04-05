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
public class GridLayoutTutorial {
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// default grid layout (1 row, 1 column)
	public static GridLayout glOneByOne = new GridLayout();
	// grid layout w/ rows & columns
	public static GridLayout glRowCol = new GridLayout(1, 2);
	// grid layout w/ rows, columns, & gaps
	public static GridLayout glGaps = new GridLayout(4, 8, 16, 32);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// add layout component
		glOneByOne.addLayoutComponent("Lable", new Label("Label"));
		// get # columns
		int numColumns = glRowCol.getColumns();
		System.out.println(numColumns);
		// get horizontal gaps
		numColumns = glGaps.getHgap();
		// get # rows
		numColumns = glOneByOne.getRows();
		// get vertical gap
		numColumns = glRowCol.getVgap();
		// layout container w/ this 
		glGaps.layoutContainer(new Frame());
		// get min size
		Dimension size = glOneByOne.minimumLayoutSize(new Frame());
		// get preferred size
		size = glRowCol.preferredLayoutSize(new Frame());
		// remove component
		glGaps.removeLayoutComponent(null);
		// set # columns
		glOneByOne.setColumns(numColumns);
		// set horizontal gap
		glRowCol.setHgap(numColumns);
		// set # rows
		glGaps.setRows(numColumns);
		// set vertical gap
		glOneByOne.setVgap(numColumns);
		// get layout as string
		System.out.println(glRowCol.toString());
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Label msglabel;

	public GridLayoutTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		GridLayoutTutorial  gridLayoutTutorial = new GridLayoutTutorial();  
		gridLayoutTutorial.showGridLayoutDemo();       
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

	private void showGridLayoutDemo(){
		headerLabel.setText("Layout in action: GridLayout");      

		Panel panel = new Panel();
		panel.setBackground(Color.darkGray);
		panel.setSize(300,300);
		GridLayout layout = new GridLayout(0,3);
		layout.setHgap(10);
		layout.setVgap(10);

		panel.setLayout(layout);        
		panel.add(new Button("Button 1"));
		panel.add(new Button("Button 2")); 
		panel.add(new Button("Button 3")); 
		panel.add(new Button("Button 4")); 
		panel.add(new Button("Button 5")); 
		controlPanel.add(panel);
		mainFrame.setVisible(true);  
	}
	//---------
}
