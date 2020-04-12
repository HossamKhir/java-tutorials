package tutorial.swing.action.listener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame implements ActionListener {

	//_________________________________Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JTextArea txa;

	//_________________________________Constructors
	public MainFrame() {
		super();
	}

	public MainFrame(String strTitle) {
		super(strTitle);
		
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		btn = new JButton("Click me!\n");
		btn.addActionListener(this);
		txa = new JTextArea();
		
		this.add(btn, BorderLayout.SOUTH);
		this.add(txa, BorderLayout.CENTER);
		
		this.setSize(1024, 512);
		this.setVisible(true);
	}
	//_________________________________Main
	//_________________________________Methods

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		txa.append(arg0.toString());
	}

}
