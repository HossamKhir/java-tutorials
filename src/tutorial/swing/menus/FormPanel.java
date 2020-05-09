/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.swing.menus;

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
    private JComboBox cmbEmployment;
    private JCheckBox chkCitizen;
    private JTextField txfTax;
    private JLabel lblTax;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private ButtonGroup grpGender;

    private FormEventListener feListener;

    // </editor-fold>
    // <editor-fold desc="constructors">
    public FormPanel() {
        /**
         * on adding components w/ layout managers, the layout manager uses
         * preferred size of such component the layout manager not necessarily
         * respects preferred size, sometimes even ignores it completely, but if
         * possible, it would apply the size or one of the 2 dimensions
         */
        Dimension size = this.getPreferredSize();
//        System.out.println(size.toString());
        size.width = 256;
        this.setPreferredSize(size);

        instantiateComponents();
        setupLstAge();
        setupCmbEmployment();
        setupTaxID();
        setupRadios();

        chkCitizen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblTax.setEnabled(chkCitizen.isSelected());
                txfTax.setEnabled(chkCitizen.isSelected());
            }
        });

        btnOkay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String strName = txfName.getText();
                String strOccupation = txfOccupation.getText();
//                String strAgeCategory = (String) lstAge.getSelectedValue();
                AgeCategory ageCat = (AgeCategory) lstAge.getSelectedValue();
                // values are of AgeCategory class, not String anymore
                String empCat = (String) cmbEmployment.getSelectedItem();
                String taxID = txfTax.getText();
                String gender
                        = grpGender.getSelection().getActionCommand();

                // FIXME debug code
//                System.out.println(empCat);

                // create an event to be sent for another component
                FormEvent fEvent
                        = new FormEvent(this, strName, strOccupation,
                                ageCat.getId(), empCat, taxID,
                                chkCitizen.isSelected(), gender);

                if (feListener != null) {
                    feListener.formEventOccurred(fEvent);
                }
            }
        });
        bordering();
        layoutComponents();
    }

    private void setupTaxID() {
        // TODO setup tax ID
        lblTax.setEnabled(false);
        txfTax.setEnabled(false);
    }

    private void instantiateComponents() {
        lblName = new JLabel("Name:");
        lblOccupation = new JLabel("Occupation:");
        txfName = new JTextField(10);
        txfOccupation = new JTextField(10);
        btnOkay = new JButton("Okay");
        lstAge = new JList();
        cmbEmployment = new JComboBox();
        chkCitizen = new JCheckBox();
        txfTax = new JTextField(10);
        lblTax = new JLabel("Tax ID:");
        radMale = new JRadioButton("Male");
        radFemale = new JRadioButton("Female");
        grpGender = new ButtonGroup();
    }

    private void setupRadios() {
        radMale.setSelected(true);
        radMale.setActionCommand("male");
        radFemale.setActionCommand("female");
        grpGender.add(radMale);
        grpGender.add(radFemale);
    }

    // </editor-fold>
    // <editor-fold desc="main" defaultstate="collapsed">
    // </editor-fold>
    // <editor-fold desc="methods" defaultstate="collapsed">
    /**
     * @param listener
     */
    public void setFormListener(FormEventListener listener) {
        this.feListener = listener;
    }

    /**
     *
     */
    private void layoutComponents() {
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
        int y = 0;
        gridBagConstraints.cell(1, y).stick(GridBagConstraints.LINE_START);
        gridBagConstraints.insets = insets;
        this.add(txfName, gridBagConstraints);  // 1:21:16
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        insets.right = 5;
        gridBagConstraints.cell(0, ++y).stick(GridBagConstraints.LINE_END);
        gridBagConstraints.insets = insets;
        this.add(lblOccupation, gridBagConstraints);

//        configConstraints(gridBagConstraints, 1, 1, GridBagConstraints.LINE_START);
        insets.right = 0;
        gridBagConstraints.cell(1, 1).stick(GridBagConstraints.LINE_START);
        gridBagConstraints.insets = insets;
        this.add(txfOccupation, gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);

        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(lstAge, gridBagConstraints);
        gridBagConstraints.cell(0, y).stick(GridBagConstraints.FIRST_LINE_END).weigh(1, .1f);
        this.add(new JLabel("Age: "), gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(cmbEmployment, gridBagConstraints);
        gridBagConstraints.cell(0, y).stick(GridBagConstraints.FIRST_LINE_END).weigh(1, .1f);
        this.add(new JLabel("Employment: "), gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(chkCitizen, gridBagConstraints);
        gridBagConstraints.cell(0, y).stick(GridBagConstraints.FIRST_LINE_END).weigh(1, .1f);
        this.add(new JLabel("ARE citizen: "), gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 0, 1, GridBagConstraints.LINE_END);
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(txfTax, gridBagConstraints);
        gridBagConstraints.cell(0, y).stick(GridBagConstraints.FIRST_LINE_END).weigh(1, .1f);
        this.add(lblTax, gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(radMale, gridBagConstraints);
        gridBagConstraints.cell(0, y).stick(GridBagConstraints.LINE_END).weigh(1, .025f);
        this.add(new JLabel("Gender: "), gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, .1f);
        this.add(radFemale, gridBagConstraints);
//        gridBagConstraints.cell(0, y).stick(GridBagConstraints.FIRST_LINE_END).weigh(1, .1f);
//        this.add(new JLabel("Gender: "), gridBagConstraints);
        // </editor-fold>
        // <editor-fold desc="next row">
//        configConstraints(gridBagConstraints, 1, 2, GridBagConstraints.FIRST_LINE_START, 1f, 2);
        gridBagConstraints.cell(1, ++y).stick(GridBagConstraints.FIRST_LINE_START).weigh(1, 2);
        this.add(btnOkay, gridBagConstraints);
        // </editor-fold>
    }

    /**
     *
     */
    private void bordering() {
        //        this.setBorder(BorderFactory.createTitledBorder("Add person"));
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder,
                innerBorder));
    }

    /**
     *
     */
    private void setupCmbEmployment() {
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Unemployed");

        cmbEmployment.setModel(empModel);
        cmbEmployment.setSelectedIndex(0);  // set default selection
        cmbEmployment.setEditable(true);    // allows for editing values
    }

    /**
     *
     */
    private void setupLstAge() {
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18!"));
        ageModel.addElement(new AgeCategory(1, "18 to 65!"));
        ageModel.addElement(new AgeCategory(2, "65 or over!"));

        lstAge.setPreferredSize(new Dimension(110, 70));
        lstAge.setBorder(BorderFactory.createEtchedBorder());
        lstAge.setModel(ageModel);
        lstAge.setSelectedIndex(1);
    }
    // </editor-fold>
}

/**
 *
 */
// <editor-fold desc="utility classes">
class AgeCategory {

    // <editor-fold desc="fields">
    private int id;
    private String text;

    // </editor-fold>
    // <editor-fold desc="constructors">
    /**
     * @param id
     * @param strText
     */
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

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
    // </editor-fold>

}

/**
 *
 */
class ExtendedGridBagConstraints extends GridBagConstraints {

    /**
     * @param x
     * @param y
     * @return
     */
    public ExtendedGridBagConstraints cell(int x, int y) {
        this.gridx = x;
        this.gridy = y;
        return this;
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public ExtendedGridBagConstraints weigh(float x, float y) {
        this.weightx = x;
        this.weighty = y;
        return this;
    }

    /**
     * @param anch
     * @return
     */
    public ExtendedGridBagConstraints stick(int anch) {
        this.anchor = anch;
        return this;
    }

    /**
     * @param filler
     * @return
     */
    public ExtendedGridBagConstraints filler(int filler) {
        this.fill = filler;
        return this;
    }
}

// </editor-fold>
