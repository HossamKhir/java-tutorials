/**
 * 
 */
package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

import javax.accessibility.AccessibleContext;

/**
 * @author hossa
 *
 */
public class DialogTutorial {
	// @fields
	//--------
	public static Dialog.ModalityType field = Dialog.DEFAULT_MODALITY_TYPE;
	//--------
	// @constructors
	//--------------
	private static Dialog dlgOwner;
	// invisible modeless dialog w/ empty title
	public static Dialog dlgInvisible = new Dialog(dlgOwner);
	// invisible modeless dialog w/ title
	public static Dialog dlgTitled = new Dialog(dlgInvisible, "Title");
	// invisible modal dialog w/ title
	public static Dialog dlgModal = new Dialog(dlgTitled, "Modal", true);
	// invisible modal dialog w/ title & graphics configuration
	/*
	 * public static Dialog dlgGraphics = new Dialog(dlgModal, "Graphics", false,
	 * new GraphicsConfiguration() {
	 * 
	 * @Override public AffineTransform getNormalizingTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public GraphicsDevice getDevice() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public AffineTransform getDefaultTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel(int transparency) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Rectangle getBounds() { // TODO Auto-generated method stub
	 * return null; } });
	 */
	// invisible modeless dialog w/ empty title & frame owner
	public static Dialog dlgFramed = new Dialog(new Frame());
	// invisible modal dialog w/ empty title & frame owner
	public static Dialog dlgTitleLessFrame = new Dialog(new Frame(), true);
	// invisible modeless dialog w/ title & frame owner
	public static Dialog dlgTitledFrame = new Dialog(new Frame(), "Frame");
	// invisible modal dialog w/ title & frame owner
	public static Dialog dlgModalTitledFrame = new Dialog(new Frame(), "Modal", false);
	// invisible modal dialog w/ title & frame owner & graphics configuration
	/*
	 * public static Dialog dlgGraphicsFrame = new Dialog(new Frame(), "Graphics",
	 * true, new GraphicsConfiguration() {
	 * 
	 * @Override public AffineTransform getNormalizingTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public GraphicsDevice getDevice() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public AffineTransform getDefaultTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel(int transparency) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Rectangle getBounds() { // TODO Auto-generated method stub
	 * return null; } });
	 */
	// invisible modeless dialog w/ empty title & window owner
	//    public static Dialog dlgWindow = new Dialog(new Window());
	// invisible modal dialog w/ empty title & window owner
	//	public static Dialog dlgWindowModal = new Dialog (new Window(), Dialog.DEFAULT_MODALITY_TYPE);
	// invisible modeless dialog w/ title & window owner
	//	public static Dialog dlgTitledWindow = new Dialog(new Window(), "Title");
	// invisible modal dialog w/ title & window owner
	//	public static Dialog dlgModalTitledWindow = new Dialog(new Window(), "Modal", Dialog.DEFAULT_MODALITY_TYPE);
	// invisible modal dialog w/ title, window owner & graphics configuration
	/*
	 * public static Dialog dlgGraphicsWindow = new Dialog(new Window(), "Graphics",
	 * Dialog.DEFAULT_MODALITY_TYPE, new GraphicsConfiguration() {
	 * 
	 * @Override public AffineTransform getNormalizingTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public GraphicsDevice getDevice() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public AffineTransform getDefaultTransform() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel(int transparency) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ColorModel getColorModel() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Rectangle getBounds() { // TODO Auto-generated method stub
	 * return null; } });
	 */
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// create peer for dialog
		dlgInvisible.addNotify();
		// get accessible context
		AccessibleContext acDialog = dlgTitled.getAccessibleContext();
		// get modality type of dialog
		Dialog.ModalityType mtGot = dlgModal.getModalityType();
		// get title of dialog
		String strTitle = dlgModal.getTitle();
		System.out.println(strTitle);
		// check modality of dialog
		boolean isModal = dlgFramed.isModal();
		// check resizability of dialog
		isModal = dlgTitleLessFrame.isResizable();
		// check undecoration of dialog
		isModal = dlgTitledFrame.isUndecorated();
		// set modality of dialog
		dlgModalTitledFrame.setModal(isModal);
		// set modality type of dialog
		dlgModalTitledFrame.setModalityType(mtGot);
		// set resizability of dialog
		dlgInvisible.setResizable(isModal);
		// set title of dialog
		dlgTitled.setTitle(strTitle);
		// set undecoration property of dialog 
		dlgModal.setUndecorated(isModal);
		// set visibility of dialog
		dlgModal.setVisible(isModal);
		// put a window in back
		dlgFramed.toBack();

		// some protected & inherited methods

	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public DialogTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		DialogTutorial  dialogTutorial = new DialogTutorial();
		dialogTutorial.showDialogDemo();
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

	private void showDialogDemo(){
		headerLabel.setText("Control in action: Dialog"); 
		Button showAboutDialogButton = new Button("Show About Dialog");
		showAboutDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog aboutDialog = new AboutDialog(mainFrame);
				aboutDialog.setVisible(true);
			}
		});

		controlPanel.add(showAboutDialogButton);
		mainFrame.setVisible(true);  
	}

	class AboutDialog extends Dialog {
		public AboutDialog(Frame parent){
			super(parent, true);         
			setBackground(Color.GRAY);
			setLayout(new BorderLayout());
			Panel panel = new Panel();
			panel.add(new Button("Close"));
			add("South", panel);
			setSize(200,200);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent){
					dispose();
				}
			});
		}

		public boolean action(Event evt, Object arg){
			if(arg.equals("Close")){
				dispose();
				return true;
			}
			return false;
		}

		public void paint(Graphics g){
			g.setColor(Color.WHITE);
			g.drawString("H. K. Mersahl", 25,70 );
			g.drawString("Version 1.0", 60, 90);      
		}
	}
	//---------

}
