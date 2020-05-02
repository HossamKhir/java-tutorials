/**
 *
 */
package tutorial.swing.list.box;

import tutorial.swing.events.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author hossam
 *
 */
public class Toolbar extends JPanel implements ActionListener {

    //_______________________________Fields
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton btnHello;
    private JButton btnGoodbye;
    private StringListener textListener;
    //_______________________________Constructors

    public Toolbar() {
        super();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        this.btnHello = new JButton("Hello!");
        this.btnGoodbye = new JButton("Goodbye!");

        // action listener allow for event handling
        this.btnHello.addActionListener(this);
        this.btnGoodbye.addActionListener(this);

        /* using flow layout to order from left to right
        // left ensures starting from the beginning of the line, otherwise it
        // begins in the middle */
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(btnHello);
        this.add(btnGoodbye);
    }
    //_______________________________Main
    //_______________________________Methods

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("A button is was clicked!\n");
        JButton btnClicked = (JButton) e.getSource();

        if (btnClicked == btnHello) {
//            System.out.println("Hello!\n");
            if (textListener != null) {
                textListener.textEmitted("Hello");
            }
        } else if (btnClicked == btnGoodbye) {
//            System.out.println("Goodbye!\n");
            if (textListener != null) {
                textListener.textEmitted("Goodbye!");
            }
        }
    }

}
