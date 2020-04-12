/**
 *
 */
package tutorial.swing.borders;

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
    private FormPanel form;
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
        form = new FormPanel();

        tlb.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
//                System.out.println(text);
                txp.appendText(text);
            }
        });

        this.add(tlb, BorderLayout.NORTH);
        this.add(txp, BorderLayout.CENTER);
        this.add(form, BorderLayout.WEST);

        this.setSize(1024, 512);
        this.setVisible(true);

    }
    //_______________________________________________Main
    //_______________________________________________Methods

}
