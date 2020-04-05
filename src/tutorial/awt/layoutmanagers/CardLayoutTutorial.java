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
public class CardLayoutTutorial {
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// card layout w/ zero-size gaps
	public static CardLayout clZero = new CardLayout();
	// card layout w/ horizontal & vertical gaps
	public static CardLayout clGaps = new CardLayout(4, 8);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// add component to layout 
		clZero.addLayoutComponent(new Frame(), new GridLayout(3, 1));
		// flip to first card
		clGaps.first(new Frame());
		// get horizontal gap
		int gap = clZero.getHgap();
		// get x alignment
		float align = clGaps.getLayoutAlignmentX(new Frame());
		System.out.println(align);
		// get y alignment
		align = clZero.getLayoutAlignmentY(new Frame());
		// get vertical gap
		gap = clGaps.getVgap();
		// invalidate layout
		clZero.invalidateLayout(new Frame());
		// flip to last card
		clGaps.last(new Frame());
		// layout a component argument w/ this card layout
		clZero.layoutContainer(new Frame());
		// get max size
		Dimension size = clGaps.maximumLayoutSize(new Frame());
		// get min size
		size = clZero.minimumLayoutSize(new Frame());
		// flip to next card
		clGaps.next(new Frame());
		// get preferred size
		size = clZero.preferredLayoutSize(new Frame());
		// flip to previous card
		clGaps.previous(new Frame());
		// remove component from layout
		clZero.removeLayoutComponent(null);
		// set horizontal gap
		clGaps.setHgap(gap);
		// set vertical gap
		clZero.setVgap(gap);
		// get layout as string
		System.out.println(clGaps.toString());

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

	public CardLayoutTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		CardLayoutTutorial  cardLayoutTutorial = new CardLayoutTutorial();  
		cardLayoutTutorial.showCardLayoutDemo();       
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

	private void showCardLayoutDemo(){
		headerLabel.setText("Layout in action: CardLayout");      

		final Panel panel = new Panel();
		panel.setBackground(Color.CYAN);
		panel.setSize(300,300);

		CardLayout layout = new CardLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);        

		Panel buttonPanel = new Panel(new FlowLayout());

		buttonPanel.add(new Button("OK"));
		buttonPanel.add(new Button("Cancel"));    

		Panel textBoxPanel = new Panel(new FlowLayout());

		textBoxPanel.add(new Label("Name:"));
		textBoxPanel.add(new TextField(20));

		panel.add("Button", buttonPanel);
		panel.add("Text", textBoxPanel);

		Choice choice = new Choice();
		choice.add("Button");
		choice.add("Text");

		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.getLayout());
				cardLayout.show(panel, (String)e.getItem());
			}
		});
		controlPanel.add(choice);
		controlPanel.add(panel);

		mainFrame.setVisible(true);  
	}
	//---------
}
