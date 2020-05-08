package tutorial.swing.list.box;

import tutorial.swing.events.*;
import java.util.EventObject;

public class FormEvent extends EventObject {

    // <editor-fold desc="fields">
    private String name;
    private String occupation;
    private int ageCategory;
    // </editor-fold>
    // <editor-fold desc="constructors">

    /**
     *
     * @param source
     */
    public FormEvent(Object source) {
        super(source);
    }

    /**
     *
     * @param source
     * @param objectList
     */
    public FormEvent(Object source, Object... objectList) {
        super(source);
        switch (objectList.length) {
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    /**
     *
     * @return
     */
    public int getAgeCategory() {
        return ageCategory;
    }

    /**
     *
     * @param ageCategory
     */
    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }
    // </editor-fold>
}
