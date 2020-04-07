/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.actionlistener;

import javax.swing.SwingUtilities;

/**
 *
 * @author hossam
 */
public class App {

	//_______________________________Fields

	//_______________________________Constructors

	//_______________________________Main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame("A really long title\n");
			}
		});
	}
	//_______________________________Methods
}
