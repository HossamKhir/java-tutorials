/**
 * 
 */
package tutorial.swing.toolbar;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author hossam
 *
 */
public class Toolbar extends JPanel {

	//_______________________________Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnHello;
	private JButton btnGoodbye;
	//_______________________________Constructors
	public Toolbar() {
		super();
		
		btnHello = new JButton("Hello!");
		btnGoodbye = new JButton("Goodbye!");
		
		// using flow layout to order from left to right
		// left ensures starting from the beginning of the line, otherwise it begins in the middle
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(btnHello);
		this.add(btnGoodbye);
	}
	//_______________________________Main
	//_______________________________Methods

}
