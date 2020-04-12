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
public class ContainerListenerTutorial implements ContainerListener {
	// @methods
	//---------
	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ e.getComponent().getClass().getSimpleName() + " added. ");
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
		statusLabel.setText(statusLabel.getText() 
				+ e.getComponent().getClass().getSimpleName() + " removed. ");
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ContainerListenerTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ContainerListenerTutorial  containerListenerTutorial = new ContainerListenerTutorial();  
		containerListenerTutorial.showContainerListenerDemo();
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

	private void showContainerListenerDemo(){
		headerLabel.setText("Listener in action: ContainerListener");      

		ScrollPane panel = new ScrollPane();      
		panel.setBackground(Color.magenta);            
		panel.addContainerListener(this);  

		Label msglabel = new Label();
		msglabel.setAlignment(Label.CENTER);
		msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");
		msglabel.setForeground(Color.white);
		panel.add(msglabel);

		Button btnAdd = new Button("Add");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Scrollbar scrNew = new Scrollbar();
				panel.add(scrNew);
			}
		});
		Button btnRemove = new Button("Remove");
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int c = panel.getComponentCount();
					if (c > 0) {
						Component[] comps = panel.getComponents();
						panel.remove(comps[c - 1]);
					}
					else {
						System.out.println("nothing to remove");
					}
				} catch(Exception ex) {
					System.out.println("An exception");
				}
			}

		});

		controlPanel.add(panel);
		controlPanel.add(btnAdd);
		controlPanel.add(btnRemove);
		mainFrame.setVisible(true);  
	}
	//---------
}
