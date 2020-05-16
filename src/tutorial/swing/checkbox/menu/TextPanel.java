/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.checkbox.menu;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author hossam
 */
public class TextPanel extends JPanel {

    // <editor-fold desc="fields">
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextArea txa;
    // </editor-fold>
    // <editor-fold desc="constructors">
    public TextPanel() {
        super();

        this.setLayout(new BorderLayout());
        txa = new JTextArea();
        // JTextArea is one of the components that might need scrolling
        this.add(new JScrollPane(txa), BorderLayout.CENTER);
    }

    // </editor-fold>
    // <editor-fold desc="methods">
    public void appendText(String strText) {
        this.txa.append(strText + "\n");
    }
    // </editor-fold>
}
// 33:45
