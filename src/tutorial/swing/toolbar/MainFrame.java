/**
 * 
 */
package tutorial.swing.toolbar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author hossam
 *
 */
public class MainFrame extends JFrame {

	//_______________________________________________Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Toolbar tlb;
	private TextPanel txp;
	//_______________________________________________Constructors
	public MainFrame() {
		super();
	}

	public MainFrame(String strTitle) {
		super(strTitle);
		
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		tlb = new Toolbar();
		txp = new TextPanel();
		
		
		this.add(tlb, BorderLayout.NORTH);
		this.add(txp, BorderLayout.CENTER);
		
		this.setSize(512, 512);
		this.setVisible(true);

	}
	//_______________________________________________Main
	//_______________________________________________Methods

}
