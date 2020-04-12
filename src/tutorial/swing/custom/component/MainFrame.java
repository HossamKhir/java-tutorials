/**
 * 
 */
package tutorial.swing.custom.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author hossa
 *
 */
public class MainFrame extends JFrame {

	//_______________________________________________Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private TextPanel txp;
	//_______________________________________________Constructors
	public MainFrame() {
		super();
	}

	public MainFrame(String strTitle) {
		super(strTitle);
		
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		
		btn = new JButton("Click me!");
		txp = new TextPanel();
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txp.appendText(arg0.toString());
			}
			
		});
		
		this.add(btn, BorderLayout.SOUTH);
		this.add(txp, BorderLayout.CENTER);
		
		this.setSize(512, 512);
		this.setVisible(true);

	}
	//_______________________________________________Main
	//_______________________________________________Methods

}
