/**
 *
 */
package tutorial.swing.checkbox.menu;

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

        this.setJMenuBar(createMenuBar());

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

        // FIXME debug code
//        this.setUndecorated(true);
        this.setSize(1024, 512);
        this.setVisible(true);

    }

    // </editor-fold>
    // <editor-fold desc="main">
    // </editor-fold>
    // <editor-fold desc="methods">
    private JMenuBar createMenuBar() {
        // TODO declare a menu bar
        JMenuBar mnuBar = new JMenuBar();
        
        // TODO declare menus
        JMenu mFile = new JMenu("File");
        JMenu mWindow = new JMenu("Window");
        // TODO declare a sub menu (a menu under a menu)
        JMenu mShow = new JMenu("Show");
        
        // TODO declare menu items
        JMenuItem mniExportData = new JMenuItem("Export Data...");
        JMenuItem mniImportData = new JMenuItem("Import Data...");
        JMenuItem mniExit = new JMenuItem("Exit");
        JMenuItem mniShowForm = new JMenuItem("Person Form");
        
        // TODO add menu items to menus
        mFile.add(mniExportData);
        mFile.add(mniImportData);
        // TODO add a separator in menu
        mFile.addSeparator();
        mFile.add(mniExit);
        mShow.add(mniShowForm);
        // TODO add sub menu to menu
        mWindow.add(mShow);
        
        // TODO add menus to menu bar
//        mnuBar.setLayout(new BoxLayout(mnuBar, BoxLayout.LINE_AXIS));
        mnuBar.add(mFile);
        mnuBar.add(mWindow);
//        mnuBar.add(Box.createHorizontalGlue());
//        mnuBar.add(new JLabel("Testing title"));
//        mnuBar.add(Box.createHorizontalGlue());
        
        // return statement
        return mnuBar;
    }
    // </editor-fold>
}
