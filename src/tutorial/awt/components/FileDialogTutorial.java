/**
 * 
 */
package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;
import java.io.FilenameFilter;

/**
 * @author hossa
 *
 */
public class FileDialogTutorial {
	// @fields
	//--------
	public static int[] fields = {
			FileDialog.LOAD,
			FileDialog.SAVE,
	};
	//--------
	// @constructors
	//--------------
	// new file dialog
	private static Dialog dlgParent;
	public static FileDialog fdNew = new FileDialog(dlgParent);
	// file dialog w/ dialog parent & title
	public static FileDialog fdTitled = new FileDialog(dlgParent, "Title");
	// file dialog w/ dialog parent & title & mode (save, load)
	public static FileDialog fdMode = new FileDialog(dlgParent, "Mode", FileDialog.LOAD);
	// file dialog w/ frame parent
	public static FileDialog fdFramed = new FileDialog(new Frame());
	// file dialog w/ frame parent & title
	public static FileDialog fdTitledFrame = new FileDialog(new Frame(), "Title");
	// file dialog w/ frame parent & title & mode
	public static FileDialog fdFrameMode = new FileDialog(new Frame(), "Mode", FileDialog.SAVE);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// create peer for file dialog
		fdNew.addNotify();
		// get directory of file dialog
		String strDirectory = fdTitled.getDirectory();
		// get selected file of file dialog
		strDirectory = fdMode.getFile();
		// get file name filter of file dialog
		FilenameFilter fnFilter = fdFramed.getFilenameFilter();
		// get mode of file dialog
		int mode = fdTitledFrame.getMode();
		// set directory for file dialog
		fdFrameMode.setDirectory(strDirectory);
		// set the selected file for file dialog
		fdNew.setFile(strDirectory);
		// set file name filter
		fdTitled.setFilenameFilter(fnFilter);
		// set mode of file dialog
		fdMode.setMode(mode);

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public FileDialogTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		FileDialogTutorial  fileDialogTutorial = new FileDialogTutorial();
		fileDialogTutorial.showFileDialogDemo();
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

	private void showFileDialogDemo(){
		headerLabel.setText("Control in action: FileDialog"); 

		final FileDialog fileDialog = new FileDialog(mainFrame,"Select file");
		Button showFileDialogButton = new Button("Open File");
		showFileDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);
				statusLabel.setText("File Selected :" 
						+ fileDialog.getDirectory() + fileDialog.getFile());
			}
		});

		controlPanel.add(showFileDialogButton);
		mainFrame.setVisible(true);  
	}
	//---------

}
