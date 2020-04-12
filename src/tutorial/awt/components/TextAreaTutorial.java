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
public class TextAreaTutorial {
	// @fields
	//--------
	static int[] field = {
			TextArea.SCROLLBARS_BOTH,
			TextArea.SCROLLBARS_HORIZONTAL_ONLY,
			TextArea.SCROLLBARS_NONE,
			TextArea.SCROLLBARS_VERTICAL_ONLY,
	};
	//--------
	// @constructors
	//--------------
	// empty text area
	public static TextArea txaEmpty = new TextArea();
	// empty text area w/ rows & columns
	public static TextArea txaRowColumn = new TextArea(8, 8);
	// text area w/ text
	public static TextArea txaText = new TextArea("Text");
	// text area w/ text, rows & columns
	public static TextArea txaColumnRowText = new TextArea("Area with text", 8, 8);
	// text area w/ text, rows, columns & scroll bars
	public static TextArea txaScroll = new TextArea("Scroll all over", 8, 8, TextArea.SCROLLBARS_BOTH);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// create peer for text area
		txaEmpty.addNotify();
		// append text to the current text area
		txaRowColumn.append("Appended");
		// get accessible context
		AccessibleContext acTextArea = txaText.getAccessibleContext();
		// get # of columns in text area
		int numColumns = txaColumnRowText.getColumns();
		// get minimum dimension sizes
		Dimension dmnSize = txaScroll.getMinimumSize();
		// get minimum dimension size for text field w/ row & column
		dmnSize = txaEmpty.getMinimumSize(numColumns, numColumns);
		// get preferred size
		dmnSize = txaRowColumn.getPreferredSize();
		// get preferred size for text field w/ row & column
		dmnSize = txaText.getPreferredSize(numColumns, numColumns);
		// get # of rows
		numColumns = txaColumnRowText.getRows();
		// get scroll bar visibility in terms of an integer
		numColumns = txaScroll.getScrollbarVisibility();
		// insert text @ index
		txaEmpty.insert("Inserted", numColumns);
		// replace range of character
		txaRowColumn.replaceRange("Replaced", numColumns, 8+numColumns);
		// set # of columns for text area
		txaText.setColumns(numColumns);
		// set # of rows for text area
		txaColumnRowText.setRows(numColumns);

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public TextAreaTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		TextAreaTutorial  textAreaTutorial = new TextAreaTutorial();
		textAreaTutorial.showTextAreaDemo();
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

	private void showTextAreaDemo(){
		headerLabel.setText("Control in action: TextArea"); 

		Label  commentlabel= new Label("Comments: ", Label.RIGHT);

		final TextArea commentTextArea = new TextArea("This is an AWT tutorial "
				+"to make GUI application in Java.",5,30);

		Button showButton = new Button("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     
				statusLabel.setText( commentTextArea.getText());        
			}
		}); 

		controlPanel.add(commentlabel);
		controlPanel.add(commentTextArea);        
		controlPanel.add(showButton);
		mainFrame.setVisible(true);  
	}
	//---------
}
