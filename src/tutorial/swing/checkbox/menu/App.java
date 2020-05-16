/**
 *
 */
package tutorial.swing.checkbox.menu;

import javax.swing.*;

/**
 * @author hossam
 *
 */
public class App {

    // <editor-fold desc="fields">
    // </editor-fold>
    // <editor-fold desc="constructors">
    // </editor-fold>
    // <editor-fold desc="main">
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
    // </editor-fold>
    // <editor-fold desc="methods">
    // </editor-fold>

}
