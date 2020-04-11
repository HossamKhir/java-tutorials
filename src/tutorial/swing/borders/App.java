/**
 *
 */
package tutorial.swing.borders;

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
            }
        });
    }
    //_______________________________________________Methods

}
// 1:10:55
