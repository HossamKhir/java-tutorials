/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.layout.manager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author hossa
 */
public class FormPanel extends JPanel {

    //_________________________________Fields

    private JLabel lblName;
    private JLabel lblOccupation;
    private JTextField txfName;
    private JTextField txfOccupation;
    private JButton btnOkay;

    private class ExtendedGridBagConstraints extends GridBagConstraints {
        public ExtendedGridBagConstraints cell(int x, int y) {
            this.gridx = x;
            this.gridy = y;
            return this;
        }

        public ExtendedGridBagConstraints weigh(float x, float y) {
            this.weightx = x;
            this.weighty = y;
            return this;
        }

        public ExtendedGridBagConstraints stick(int anch) {
            this.anchor = anch;
            return this;
        }

        public ExtendedGridBagConstraints filler(int filler) {
            this.fill = filler;
            return this;
        }
    }

    //_________________________________Constructors
    public FormPanel() {
        /* 
        on adding components w/ layout managers, the layout manager uses
        preferred size of such component
        the layout manager not necessarily respects preferred size, sometimes 
        even ignores it completely, but if possible, it would apply the size or
        one of the 2 dimensions
         */
        Dimension size = this.getPreferredSize();
//        System.out.println(size.toString());
        size.width = 256;
        this.setPreferredSize(size);

        lblName = new JLabel("Name:");
        lblOccupation = new JLabel("Occupation:");
        txfName = new JTextField(16);
        txfOccupation = new JTextField(16);

        btnOkay = new JButton("Okay");

//        this.setBorder(BorderFactory.createTitledBorder("Add person"));
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder,
                innerBorder));

        // grid bag layout is the most flexible layout manager out there
        this.setLayout(new GridBagLayout());

        // grid bag layout uses grid bag constraints
        ExtendedGridBagConstraints gridBagConstraints
                = new ExtendedGridBagConstraints().cell(0, 0).weigh(1, .1f).filler(GridBagConstraints.NONE).stick(GridBagConstraints.LINE_END);

        // initialising constraints
        Insets insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.insets = insets;
        // moving across a grid is moving on cells, w/ rows & columns
//        gridBagConstraints.gridx = 0;   // left most column
//        gridBagConstraints.gridy = 0;   // top most row

        // weights defines space of a dimension wrt the other dimension
//        gridBagConstraints.weightx = 1;
//        gridBagConstraints.weighty = 1; // 1, 1 means a square

        // determine how much space to be filled, horizontal, vertical, both, none
//        gridBagConstraints.fill = GridBagConstraints.NONE;

        // <!--first row -->
        // adding components to the layout
        this.add(lblName, gridBagConstraints);

        insets.right = 0;
//        configConstraints(gridBagConstraints, 1, 0, GridBagConstraints.LINE_START);
        gridBagConstraints.cell(1, 0).stick(GridBagConstraints.LINE_START);
        gridBagConstraints.insets = insets;
        this.add(txfName, gridBagConstraints);  // 1:21:16

        // <!--second row -->
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        insets.right = 5;
        gridBagConstraints.cell(0, 1).stick(GridBagConstraints.LINE_END);
        gridBagConstraints.insets = insets;
        this.add(lblOccupation, gridBagConstraints);

//        configConstraints(gridBagConstraints, 1, 1, GridBagConstraints.LINE_START);
        insets.right = 0;
        gridBagConstraints.cell(1, 1).stick(GridBagConstraints.LINE_START);
        gridBagConstraints.insets = insets;
        this.add(txfOccupation, gridBagConstraints);

        // <!--third row -->
//        configConstraints(gridBagConstraints, 1, 2, GridBagConstraints.FIRST_LINE_START, 1f, 2);
        gridBagConstraints.cell(1, 2).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, 2);
        this.add(btnOkay, gridBagConstraints);
    }

    //_________________________________Main
    //_________________________________Methods

}
