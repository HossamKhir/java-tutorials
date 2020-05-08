/**
 *
 */
package tutorial.swing.events;

import javax.swing.*;
import java.awt.*;

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

        // to handle events from form panel
        form.setFormListener(new FormEventListener(){
            @Override
            public void formEventOccurred(FormEvent event) {
                String strName = event.getName();
                String strOccupation = event.getOccupation();

                txp.appendText(strName + ": " + strOccupation);
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
