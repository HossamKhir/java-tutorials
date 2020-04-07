/**
 * 
 */
package tutorial.swing.jframe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author hossam
 *
 */
public class App {
	public static final JFrame frame = new JFrame("Hello World");

	public static void main(String[] args) {
		// for multi threading
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// to terminate the programme on clicking close
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// sets frame size (width x height)
				frame.setSize(400, 400);
				// display the frame
				frame.setVisible(true);
				// 13:45
			}

		});

	}
}
