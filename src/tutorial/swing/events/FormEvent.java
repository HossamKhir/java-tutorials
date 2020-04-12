package tutorial.swing.events;

import java.util.EventObject;

public class FormEvent extends EventObject {

    //______________________________________Fields
    private String name;
    private String occupation;
    //______________________________________Constructors

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String... strings) {
        super(source);
        this.name = strings[0];
        this.occupation = strings[1];
    }
    //______________________________________Main
    //______________________________________Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
