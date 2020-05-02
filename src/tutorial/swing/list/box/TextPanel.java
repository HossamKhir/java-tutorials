/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.list.box;

import tutorial.swing.events.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author hossam
 */
public class TextPanel extends JPanel {

	//_______________________________________________Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea txa;
	//_______________________________________________Constructors
	public TextPanel() {
		super();

		this.setLayout(new BorderLayout());
		txa = new JTextArea();
		// JTextArea is one of the components that might need scrolling
		this.add(new JScrollPane(txa), BorderLayout.CENTER);
	}

	//_______________________________________________Main
	//_______________________________________________Methods

	public void appendText(String strText) {
		this.txa.append(strText + "\n");
	}
}
// 33:45