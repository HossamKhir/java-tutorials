/**
 *
 */
package tutorial.swing.model.viewer.controller;

import java.awt.BorderLayout;
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

        tlb.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
//                System.out.println(text);
                txp.appendText(text);
            }
        });

        this.add(tlb, BorderLayout.NORTH);
        this.add(txp, BorderLayout.CENTER);

        this.setSize(1024, 512);
        this.setVisible(true);

    }
    //_______________________________________________Main
    //_______________________________________________Methods

}
