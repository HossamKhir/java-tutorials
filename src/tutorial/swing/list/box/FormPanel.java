/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.list.box;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author hossam
 */
public class FormPanel extends JPanel {

    // <editor-fold desc="fields">
    private JLabel lblName;
    private JLabel lblOccupation;
    private JTextField txfName;
    private JTextField txfOccupation;
    private JButton btnOkay;
    private JList lstAge;

    private FormEventListener feListener;

    // </editor-fold>
    // <editor-fold desc="constructors">
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
        txfName = new JTextField(10);
        txfOccupation = new JTextField(10);
        btnOkay = new JButton("Okay");
        lstAge = new JList();

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18!"));
        ageModel.addElement(new AgeCategory(1, "18 to 65!"));
        ageModel.addElement(new AgeCategory(2, "65 or over!"));

        lstAge.setPreferredSize(new Dimension(110, 70));
        lstAge.setBorder(BorderFactory.createEtchedBorder());
        lstAge.setModel(ageModel);
        lstAge.setSelectedIndex(1);

        btnOkay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String strName = txfName.getText();
                String strOccupation = txfOccupation.getText();
//                String strAgeCategory = (String) lstAge.getSelectedValue();
                AgeCategory ageCat = (AgeCategory) lstAge.getSelectedValue();
                // values are of AgeCategory class, not String anymore

                // FIXME debug code
                System.out.println(ageCat);

                // create an event to be sent for another component
                FormEvent fEvent
                        = new FormEvent(this, strName, strOccupation,
                                ageCat.getId());

                if (feListener != null) {
                    feListener.formEventOccurred(fEvent);
                }
            }
        });

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

        // <editor-fold desc="first row">
        // adding components to the layout
        this.add(lblName, gridBagConstraints);

        insets.right = 0;
//        configConstraints(gridBagConstraints, 1, 0, GridBagConstraints.LINE_START);
        gridBagConstraints.cell(1, 0).stick(GridBagConstraints.LINE_START);
        gridBagConstraints.insets = insets;
        this.add(txfName, gridBagConstraints);  // 1:21:16
        // </editor-fold>
        // <editor-fold desc="second row">
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
        // </editor-fold>
        // <editor-fold desc="third row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        gridBagConstraints.cell(1, 2).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(lstAge, gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="fourth row">
//        configConstraints(gridBagConstraints, 1, 2, GridBagConstraints.FIRST_LINE_START, 1f, 2);
        gridBagConstraints.cell(1, 3).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, 2);
        this.add(btnOkay, gridBagConstraints);
        // </editor-fold>
    }

    // <editor-fold>
    // <editor-fold desc="main" defaultstate="collapsed">
    // </editor-fold>
    // <editor-fold desc="methods" defaultstate="collapsed">
    /**
     *
     * @param listener
     */
    public void setFormListener(FormEventListener listener) {
        this.feListener = listener;
    }
    // </editor-fold>
}

// <editor-fold desc="utility classes">
class AgeCategory {

    // <editor-fold desc="fields">
    private int id;
    private String text;

    // </editor-fold>
    // <editor-fold desc="constructors">
    public AgeCategory(int id, String strText) {
        this.id = id;
        this.text = strText;
    }
    // </editor-fold>
    // <editor-fold desc="methods">

    /* overriding the to string method to send the wanted text */
    @Override
    public String toString() {
        return this.text;
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    // </editor-fold>

}

class ExtendedGridBagConstraints extends GridBagConstraints {

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

// </editor-fold>
