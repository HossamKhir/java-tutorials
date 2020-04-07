/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.layoutmanager;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author hossam
 */
public class App extends JFrame {

	//_______________________________Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//_______________________________Constructors
	
	public App() {
		super();
	}
	
	public App(String strTitle) {
		super(strTitle);
		this.setDefaultCloseOperation(App.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(new JButton("Click me!\n"), BorderLayout.SOUTH);
		this.add(new JTextArea(), BorderLayout.CENTER);
		this.setSize(512, 512);
		this.setVisible(true);
	}

	//_______________________________Main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new App("Border Layout");
			}
		});
	}
	//_______________________________Methods
}
