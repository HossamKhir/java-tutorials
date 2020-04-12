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
public class ScrollBarTutorial {
	// @fields
	//--------
	public static int[] fields = {
			Scrollbar.HORIZONTAL,
			Scrollbar.VERTICAL,
	};
	//--------
	// @constructors
	//--------------
	// new scroll bar
	public static Scrollbar scrNew = new Scrollbar();
	// scroll bar w/ orientation
	public static Scrollbar scrOriented = new Scrollbar(Scrollbar.HORIZONTAL);
	// scroll bar w/ orientation, value, visibility, min & max amounts
	public static Scrollbar scrValue = new Scrollbar(Scrollbar.VERTICAL, 2, 4, 1, 8);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get accessible context
		AccessibleContext acScrollBar = scrNew.getAccessibleContext();
		// get array of adjustment listeners
		AdjustmentListener[] alScrollBar = scrOriented.getAdjustmentListeners();
		// get array of listeners
		scrValue.getListeners(null);
		// add adjustment listener to the scroll bar
		scrNew.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create peer for scroll bar
		scrOriented.addNotify();
		// get block increment of scroll bar
		int blockIncrement = scrValue.getBlockIncrement();
		// get max value of scroll bar
		blockIncrement = scrNew.getMaximum();
		// get min value of scroll bar
		blockIncrement = scrOriented.getMinimum();
		// get orientation of scroll bar
		blockIncrement = scrValue.getOrientation();
		// get unit increment of scroll bar
		blockIncrement = scrNew.getUnitIncrement();
		// get current value of scroll bar
		blockIncrement = scrOriented.getValue();
		// get status of value changing
		boolean isChanging = scrValue.getValueIsAdjusting();
		// get visible amount of scroll bar
		blockIncrement = scrNew.getVisibleAmount();
		// remove adjustment listener
		scrOriented.removeAdjustmentListener(null);
		// set block increment
		scrValue.setBlockIncrement(blockIncrement);
		// set max value for scroll bar
		scrNew.setMaximum(blockIncrement);
		// set min value for scroll bar
		scrOriented.setMinimum(blockIncrement);
		// set orientation
		scrValue.setOrientation(Scrollbar.HORIZONTAL);
		// set unit increment
		scrNew.setUnitIncrement(blockIncrement);
		// set current value
		scrOriented.setValue(blockIncrement);
		// set value is adjusting
		scrValue.setValueIsAdjusting(isChanging);
		// set values (current value, visibility, min & max) for scroll bar
		scrNew.setValues(blockIncrement, blockIncrement, blockIncrement, blockIncrement);
		// set visible amount of scroll bar
		scrOriented.setVisibleAmount(blockIncrement);
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ScrollBarTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ScrollBarTutorial  scrollBarTutorial = new ScrollBarTutorial();
		scrollBarTutorial.showScrollbarDemo();
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

	private void showScrollbarDemo(){                                       
		headerLabel.setText("Control in action: Scrollbar"); 

		final Scrollbar horizontalScroller = new Scrollbar(Scrollbar.HORIZONTAL);
		final Scrollbar verticalScroller = new Scrollbar();
		verticalScroller.setOrientation(Scrollbar.VERTICAL);
		horizontalScroller.setMaximum (100);
		horizontalScroller.setMinimum (1);
		verticalScroller.setMaximum (100);
		verticalScroller.setMinimum (1);

		horizontalScroller.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				statusLabel.setText("Horozontal: "
						+horizontalScroller.getValue() 
						+" ,Vertical: "
						+ verticalScroller.getValue());
			}
		});

		verticalScroller.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				statusLabel.setText("Horozontal: "
						+horizontalScroller.getValue() 
						+" ,Vertical: "+ verticalScroller.getValue());
			}
		});

		controlPanel.add(horizontalScroller);
		controlPanel.add(verticalScroller);

		mainFrame.setVisible(true);  
	}
	//---------

}
