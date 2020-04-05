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
public class ChoiceTutorial {
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// choice menu
	public static Choice chcNew = new Choice();
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// add item to choice menu
		chcNew.add("New Item");
		// add item listener
		chcNew.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// create peer for choice menu
		chcNew.addNotify();
		// get accessible context
		AccessibleContext acChoice = chcNew.getAccessibleContext();
		// get # of items
		int numItems = chcNew.getItemCount();
		// get item @ index
		String strItem = chcNew.getItem(numItems);
		System.out.println(strItem);
		// get array of item listeners
		ItemListener[] ilArray = chcNew.getItemListeners();
		// get array of listeners
		chcNew.getListeners(null);
		// get index of selected item
		numItems = chcNew.getSelectedIndex();
		// get the selected item as string
		strItem = chcNew.getSelectedItem();
		// get selected object in an array (of length 1)
		Object[] objSelected = chcNew.getSelectedObjects();
		// insert an item at a position
		chcNew.insert("Item", numItems);
		// remove item by index
		chcNew.remove(numItems);
		// remove 1st occurrence of an item
		chcNew.remove(strItem);
		// remove all items from menu
		chcNew.removeAll();
		// remove item listener
		chcNew.removeItemListener(null);
		// select item at index
		chcNew.select(numItems);
		// select item by string value
		chcNew.select(strItem);

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ChoiceTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ChoiceTutorial  choiceTutorial = new ChoiceTutorial();
		choiceTutorial.showChoiceDemo();
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

	private void showChoiceDemo(){                                       

		headerLabel.setText("Control in action: Choice"); 
		final Choice fruitChoice = new Choice();

		fruitChoice.add("Apple");
		fruitChoice.add("Grapes");
		fruitChoice.add("Mango");
		fruitChoice.add("Peer");

		Button showButton = new Button("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     
				String data = "Fruit Selected: " 
						+ fruitChoice.getItem(fruitChoice.getSelectedIndex());
				statusLabel.setText(data);
			}
		}); 

		controlPanel.add(fruitChoice);
		controlPanel.add(showButton);

		mainFrame.setVisible(true);  
	}
	//---------
}
