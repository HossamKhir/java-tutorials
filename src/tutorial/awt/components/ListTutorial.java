/**
 * 
 */
package tutorial.awt.components;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

import javax.accessibility.AccessibleContext;

/**
 * @author hossam
 *
 */
public class ListTutorial {
	// @constructors
	//----------------------------------------------
	// scrolling list
	public static List lstScrolling = new List();
	// list w/ initial visible # of lines
	public static List lstLines = new List(32);
	// list w/ specific number of rows
	public static List lstRows = new List(16, true);
	//----------------------------------------------
	// @methods
	//-------------------------------------------------------------
	public static void methods() {
		// add to the end of the list
		lstScrolling.add("end");
		// add @ a specific position
		lstLines.add("index", 16);
		// add action listener
		lstRows.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// add item listener
		lstScrolling.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// create peer for the list
		lstLines.addNotify();
		// deselect item @ an index
		lstRows.deselect(0);
		// get accessible context
		AccessibleContext acList = lstScrolling.getAccessibleContext();
		// get array of action listeners
		ActionListener[] alList = lstLines.getActionListeners();
		// get an item from an index
		String strItem = lstRows.getItem(0);
		System.out.println(strItem);
		// get number of items in the list
		int itemsNumber = lstScrolling.getItemCount();
		System.out.println(itemsNumber);
		// get array of item listeners
		ItemListener[] ilList = lstLines.getItemListeners();
		// get array of items
		String[] strArrayList = lstRows.getItems();
		for (String str : strArrayList){
			System.out.println(str);
		}
		// get minimum dimension size
		Dimension dmnList = lstScrolling.getMinimumSize();
		// get minimum dimension size for certain number of rows
		dmnList = lstLines.getMinimumSize(8);
		// get preferred size of the list
		dmnList = lstRows.getPreferredSize();
		// get preferred size of list for certain number of rows
		dmnList = lstScrolling.getPreferredSize(8);
		// get number of visible lines in a list
		itemsNumber = lstLines.getRows();
		// get the index of the current selection on the list
		itemsNumber = lstRows.getSelectedIndex();
		// get array of indices of selected items on the list (for multiple mode)
		int[] itemsSelected = lstScrolling.getSelectedIndexes();
		for (int i : itemsSelected){
			System.out.println(i);
		}
		// get the selected item on the list
		strItem = lstLines.getSelectedItem();
		// get selected items on the list (for multiple mode)
		strArrayList = lstRows.getSelectedItems();
		// get selected items on the list in an array of objects
		Object[] objArray = lstScrolling.getSelectedObjects();
		// get index of last item made visible by calling makeVisible
		itemsNumber = lstLines.getVisibleIndex();
		// check if an item @ an index is selected
		boolean isSelected = lstRows.isIndexSelected(itemsNumber);
		// check if the list supports multiple mode
		isSelected = lstScrolling.isMultipleMode();
		// make an item @ an index visible
		lstLines.makeVisible(8);
		// remove an item form an index
		lstRows.remove(8);
		// remove first occurrence of an item
		lstScrolling.remove("Hello");
		// remove an action listener
		lstLines.removeActionListener(null);
		// remove all items from the list
		lstRows.removeAll();
		// remove an item listener
		lstScrolling.removeItemListener(null);
		// remove the peer for the list
		lstLines.removeNotify();
		// replace an item @ an index w/ a new one
		lstRows.replaceItem("new val", 8);
		// select an item @ an index
		lstScrolling.select(8);
		// set multiple mode
		lstLines.setMultipleMode(isSelected);

		// some protected & inherited methods

	}
	//-------------------------------------------------------------
	// example
	//--------------------------------------------------------------------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ListTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ListTutorial  listTutorial = new ListTutorial();
		listTutorial.showListDemo();
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

	private void showListDemo(){                                       

		headerLabel.setText("Control in action: List"); 
		final List fruitList = new List(4,false);

		fruitList.add("Apple");
		fruitList.add("Grapes");
		fruitList.add("Mango");
		fruitList.add("Peer");

		final List vegetableList = new List(4,true);

		vegetableList.add("Lady Finger");
		vegetableList.add("Onion");
		vegetableList.add("Potato");
		vegetableList.add("Tomato");

		Button showButton = new Button("Show");

		showButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {     
				String data = "Fruits Selected: " 
						+ fruitList.getItem(fruitList.getSelectedIndex());
				data += ", Vegetables selected: ";
				for(String vegetable:vegetableList.getSelectedItems()){
					data += vegetable + " ";
				}
				statusLabel.setText(data);
			}
		}); 

		controlPanel.add(fruitList);
		controlPanel.add(vegetableList);
		controlPanel.add(showButton);

		mainFrame.setVisible(true);  
	}
	//--------------------------------------------------------------------
}
