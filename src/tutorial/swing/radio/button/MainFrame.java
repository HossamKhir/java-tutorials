/**
 *
 */
package tutorial.swing.radio.button;

import javax.swing.*;
import java.awt.*;

/**
 * @author hossam
 *
 */
public class MainFrame extends JFrame {

    // <editor-fold desc="fields">
    private Toolbar tlb;
    private TextPanel txp;
    private FormPanel form;
    // </editor-fold>
    // <editor-fold desc="consturctors">

    /**
     *
     */
    public MainFrame() {
        super();
    }

    /**
     *
     * @param strTitle
     */
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
        form.setFormListener(new FormEventListener() {
            @Override
            public void formEventOccurred(FormEvent event) {
                String strName = event.getName();
                String strOccupation = event.getOccupation();
                int ageCat = event.getAgeCategory();
                String empCat = event.getEmpCat();

                txp.appendText(strName + ": " + strOccupation + ": " + ageCat + ": " + empCat);
                
                // FIXME debug code
                System.out.println(event.getGender());
            }
        });

        this.add(tlb, BorderLayout.NORTH);
        this.add(txp, BorderLayout.CENTER);
        this.add(form, BorderLayout.WEST);

        this.setSize(1024, 512);
        this.setVisible(true);

    }
    // </editor-fold>
    // <editor-fold desc="main">
    // </editor-fold>
    // <editor-fold desc="methods">
    // </editor-fold>
}
