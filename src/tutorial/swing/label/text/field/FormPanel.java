/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.label.text.field;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author hossa
 */
public class FormPanel extends JPanel {

    //_________________________________Fields
    //_________________________________Constructors
    public FormPanel() {
        /* 
        on adding components w/ layout managers, the layout manager uses
        prefered size of such component
        the layout manager not necessarily respects preferred size, sometimes 
        even ignores it completely, but if possible, it would apply the size or
        one of the 2 dimensions
         */
        Dimension size = this.getPreferredSize();
//        System.out.println(size.toString());
        size.width = 256;
        this.setPreferredSize(size);
//        this.setBorder(BorderFactory.createTitledBorder("Add person"));
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, 
                innerBorder));
    }
    //_________________________________Main
    //_________________________________Methods

}
