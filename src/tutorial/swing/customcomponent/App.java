/**
 * 
 */
package tutorial.swing.customcomponent;

import javax.swing.SwingUtilities;

/**
 * @author hossam
 *
 */
public class App {
	
	//_______________________________________________Fields
	//_______________________________________________Constructors
	//_______________________________________________Main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MainFrame("Custom Component");
			}
		});
	}
	//_______________________________________________Methods

}
