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
public class ItemListenerTutorial implements ItemListener {
	// @methods
	//---------
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		statusLabel.setText(arg0.getItem()
				+" Checkbox: " 
				+ (arg0.getStateChange()==1?"checked":"unchecked"));
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ItemListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ItemListenerTutorial  itemListenerTutorial = new ItemListenerTutorial();  
		itemListenerTutorial.showItemListenerDemo();
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

	private void showItemListenerDemo(){
		headerLabel.setText("Listener in action: ItemListener");      
		Checkbox chkApple = new Checkbox("Apple");
		Checkbox chkMango = new Checkbox("Mango");
		Checkbox chkPeer = new Checkbox("Peer");

		chkApple.addItemListener(this);
		chkMango.addItemListener(this);
		chkPeer.addItemListener(this);

		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);               
//		mainFrame.setVisible(true); 
	}
	//---------
}
