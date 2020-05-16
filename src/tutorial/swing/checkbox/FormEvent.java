package tutorial.swing.checkbox;

import java.util.EventObject;

public class FormEvent extends EventObject {

    // <editor-fold desc="fields">
    private int ageCategory;
    private String name;
    private String occupation;
    private String empCat;
    private String taxID;
    private boolean isCitizen;
    // </editor-fold>
    // <editor-fold desc="constructors">

    /**
     * @param source
     */
    public FormEvent(Object source) {
        super(source);
    }

    /**
     * @param source
     * @param objectList
     */
    public FormEvent(Object source, Object... objectList) {
        super(source);
        switch (objectList.length) {
            case 6:
                this.isCitizen = (boolean) objectList[5];
            case 5:
                this.taxID = (String) objectList[4];
            case 4:
                this.empCat = (String) objectList[3];
            case 3:
                this.ageCategory = (int) objectList[2];
            case 2:
                this.occupation = (String) objectList[1];
            case 1:
                this.name = (String) objectList[0];
                break;
            default:

        }
    }
    // </editor-fold>
    // <editor-fold desc="main">
    // </editor-fold>
    // <editor-fold desc="methods">

    /**
     *
     * @return
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     *
     * @param taxID
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     *
     * @return
     */
    public boolean isIsCitizen() {
        return isCitizen;
    }

    /**
     *
     * @param isCitizen
     */
    public void setIsCitizen(boolean isCitizen) {
        this.isCitizen = isCitizen;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return
     */
    public int getAgeCategory() {
        return ageCategory;
    }

    /**
     * @param ageCategory
     */
    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    /**
     * @return
     */
    public String getEmpCat() {
        return empCat;
    }

    /**
     * @param empCat
     */
    public void setEmpCat(String empCat) {
        this.empCat = empCat;
    }

    // </editor-fold>
}
