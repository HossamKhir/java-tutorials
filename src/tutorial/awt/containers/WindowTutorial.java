/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.containers;

import java.awt.*;
import java.awt.Dialog.*;
import java.awt.event.*;
import java.awt.im.*;
import java.awt.image.*;
import java.beans.*;
import java.util.*;
import java.util.List;

import javax.accessibility.*;

/**
 *
 * @author Hossam
 */
public class WindowTutorial {
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// invisible window w/ frame owner
	private static final Frame frm = new Frame("Frame");
	public static Window wndFramed = new Window(frm);
	// invisible window w/ window owner
	public static Window wndWindowed = new Window(wndFramed);
	// invisible window w/ window owner w/ graphic configuration
	private static final GraphicsConfiguration gConfig = null;
	public static Window wndGraph = new Window(wndWindowed, gConfig);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// make window displayable
		wndFramed.addNotify();
		// add property change listener
		PropertyChangeListener pcListener = null;
		wndWindowed.addPropertyChangeListener(pcListener);
		// add property change listener to specific property
		wndGraph.addPropertyChangeListener("Listen", pcListener);
		// add window focus listener
		WindowFocusListener wfListener = null;
		wndFramed.addWindowFocusListener(wfListener);
		// add window listener
		WindowListener wListener = null;
		wndWindowed.addWindowListener(wListener);
		// add window state listener
		WindowStateListener wsListener = null;
		wndGraph.addWindowStateListener(wsListener);
		// create strategy for multi-buffering
		wndFramed.createBufferStrategy(0);
		// create strategy for multi-buffering w/ buffer capabilities
		BufferCapabilities bCapabilities = null;
		try {
			wndWindowed.createBufferStrategy(1, bCapabilities);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// release native screen resources of window, its subcomponents, & owned children
		wndGraph.dispose();
		// get accessible context
		AccessibleContext aContext = wndFramed.getAccessibleContext();
		// get buffer strategy
		BufferStrategy bStrategy = wndWindowed.getBufferStrategy();
		// check focusable window state
		boolean focus = wndGraph.getFocusableWindowState();
		// get focus owner component
		Component comp = wndFramed.getFocusOwner();
		// get set of focus traversal keys
		Set<AWTKeyStroke> setAWT = wndWindowed.getFocusTraversalKeys(2);
		// get graphics configuration
		GraphicsConfiguration gConfig = wndGraph.getGraphicsConfiguration();
		// get list of icon images
		List<Image> iconImages = wndFramed.getIconImages();
		// get input context
		InputContext iContext = wndWindowed.getInputContext();
		// get list of all listeners
		wndGraph.getListeners(null);
		// get locale object associated w/ window
		Locale locale = wndFramed.getLocale();
		// get modal exclusion type
		ModalExclusionType meType = wndWindowed.getModalExclusionType();
		// get child component to gain focus
		Component component = wndGraph.getMostRecentFocusOwner();
		// get array of all owned windows
		Window[] owned = wndFramed.getWindows();
		// get owner of current window
		owned[0] = wndWindowed.getOwner();
		// get array of windows w/ no owners
		owned = wndGraph.getOwnerlessWindows();
		// get toolkit of window
		Toolkit toolkit = wndFramed.getToolkit();
		// get warning string displayed w/ window
		String warning = wndWindowed.getWarningString();
		// get array of window focus listeners
		WindowFocusListener[] wfListeners = wndGraph.getWindowFocusListeners();
		// get array of window listeners
		WindowListener[] wListeners = wndFramed.getWindowListeners();
		// get array of all owned windows
		owned = wndWindowed.getWindows();
		// get array of window state listeners
		WindowStateListener[] wsListeners = wndGraph.getWindowStateListeners();
		// check activity of window
		focus = wndFramed.isActive();
		// check if window is always on top
		focus = wndWindowed.isAlwaysOnTop();
		// check support of window for always on top
		focus = wndGraph.isAlwaysOnTopSupported();
		// check focusability of window
		focus = wndFramed.isFocusableWindow();
		// check focus of window
		focus = wndWindowed.isFocused();
		// check appearance @ default location for windowing system
		focus = wndGraph.isLocationByPlatform();
		// check if window is showing on screen
		focus = wndFramed.isShowing();
		// make window fit preferred size & layout of its subcomponents
		wndWindowed.pack();
		// paint the window
		Graphics graphics = null;
		wndGraph.paint(graphics);
		// make window undisplayable
		wndFramed.removeNotify();
		// remove window focus listener
		wndWindowed.removeWindowFocusListener(wfListener);
		// remove window listener
		wndGraph.removeWindowListener(wListener);
		// remove window state listener
		wndFramed.removeWindowStateListener(wsListener);
		// set always on top
		wndWindowed.setAlwaysOnTop(focus);
		// move & resize window
		wndGraph.setBounds(4, 8, 16, 32);
		// move & resize window to conform to rectangle
		Rectangle rect = null;
		wndFramed.setBounds(rect);
		// set cursor image
		wndWindowed.setCursor(new Cursor(64));
		// set focusable window state
		wndGraph.setFocusableWindowState(focus);
		// set icon image
		Image img = null;
		wndFramed.setIconImage(img);
		// set icon images for window
		wndWindowed.setIconImages(iconImages);
		// set whether or not window should appear @ default location for native windowing system
		wndGraph.setLocationByPlatform(focus);
		// set location of window relative to component
		wndFramed.setLocationRelativeTo(component);
		// set min size
		wndWindowed.setMinimumSize(new Dimension());
		// set modal exclusion type
		wndGraph.setModalExclusionType(meType);
		// set size of window w/ dimension
		wndFramed.setSize(new Dimension());
		// set size of window w/ width & height
		wndWindowed.setSize(128, 256);
		// show or hide window 
		wndGraph.setVisible(focus);
		// send window to back (may make it lose focus)
		wndFramed.toBack();
		// bring window to front (may make it gain focus)
		wndWindowed.toFront();

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Label msglabel;

	public WindowTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		WindowTutorial  windowTutorial = new WindowTutorial();          
		windowTutorial.showWindowDemo();
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

	private void showWindowDemo(){
		headerLabel.setText("Container in action: Window");   
		final MessageWindow window = 
				new MessageWindow(mainFrame,
						"Welcome to TutorialsPoint AWT Tutorial.");

		Button okButton = new Button("Open a Window");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(true);
				statusLabel.setText("A Window shown to the user.");                
			}
		});
		controlPanel.add(okButton);
		mainFrame.setVisible(true);  
	}

	class MessageWindow extends Window{
		private String message; 

		public MessageWindow(Frame parent, String message) { 
			super(parent);               
			this.message = message; 
			setSize(300, 300);       
			setLocationRelativeTo(parent);
			setBackground(Color.gray);
		}

		public void paint(Graphics g) { 
			super.paint(g);
			g.drawRect(0,0,getSize().width - 1,getSize().height - 1); 
			g.drawString(message,50,150); 
		} 
	}
	//---------
}
