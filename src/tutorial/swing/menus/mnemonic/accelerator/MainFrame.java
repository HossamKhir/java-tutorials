/**
 *
 */
package tutorial.swing.menus.mnemonic.accelerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
    // <editor-fold desc="constructors">

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
//        JMenuItem mniShowForm = new JMenuItem("Person Form");
        JCheckBoxMenuItem cbmiShowForm = new JCheckBoxMenuItem("Person Form");
        cbmiShowForm.setSelected(true);
        // TODO practice using JRadioButtonMenuItem

        // TODO add menu items to menus
        mFile.add(mniExportData);
        mFile.add(mniImportData);
        // TODO add a separator in menu
        mFile.addSeparator();
        mFile.add(mniExit);
        mShow.add(cbmiShowForm);
        // TODO add sub menu to menu
        mWindow.add(mShow);

        // TODO add menus to menu bar
//        mnuBar.setLayout(new BoxLayout(mnuBar, BoxLayout.LINE_AXIS));
        mnuBar.add(mFile);
        mnuBar.add(mWindow);
//        mnuBar.add(Box.createHorizontalGlue());
//        mnuBar.add(new JLabel("Testing title"));
//        mnuBar.add(Box.createHorizontalGlue());

        // TODO add action listeners
        cbmiShowForm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) actionEvent.getSource();
                form.setVisible(menuItem.isSelected());
            }
        });

        mniExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        // TODO add mnemonics
        mFile.setMnemonic(KeyEvent.VK_F);
        mniExit.setMnemonic(KeyEvent.VK_X);

        // TODO setup accelerators
        mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
//        mniExit.setAccelerator(KeyStroke.getKeyStroke("control K X"));
        /**
         * notice: a mnemonic consists of 1 key + ALT as default
         * an accelerator consists of 2 keys (the 2nd being either ALT, CTRL, SHIFT)
         *
         * using multiple modifier keys (i.e. Ctrl+Alt) use:
         * getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK))
         *
         * using single key (i.e. F5) use:
         * getKeyStroke(KeyEvent.VK_F5, 0)
         * */

        // return statement
        return mnuBar;
    }
    // </editor-fold>
}
