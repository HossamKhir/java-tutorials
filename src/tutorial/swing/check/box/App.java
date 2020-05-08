/**
 *
 */
package tutorial.swing.check.box;

import javax.swing.*;

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
                new MainFrame("Toolbar");
                // main frame is considered the controller
            }
        });
    }
    //_______________________________________________Methods

}
