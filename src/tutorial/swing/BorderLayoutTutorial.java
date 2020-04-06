/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author hossam
 */
public class BorderLayoutTutorial extends JFrame {

    //_____________________________________________Fields
    //_____________________________________________Constructors
    /**
     *
     */
    public BorderLayoutTutorial() {
        super();

        setLayout(new BorderLayout());

        add(new JTextArea(), BorderLayout.CENTER);
        add(new JButton("Click Me!"), BorderLayout.SOUTH);

        setSize(512, 512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     *
     * @param strTitle
     */
    public BorderLayoutTutorial(String strTitle) {
        super(strTitle);

        setLayout(new BorderLayout());

        add(new JTextArea(), BorderLayout.CENTER);
        add(new JButton("Click Me!"), BorderLayout.SOUTH);

        setSize(512, 512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //_____________________________________________Main
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayoutTutorial("Hello World!");
            }
        });
    }
    //_____________________________________________Methods
}
// 21:55