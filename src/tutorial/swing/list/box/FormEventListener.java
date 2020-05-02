package tutorial.swing.list.box;

import tutorial.swing.events.*;
import java.util.EventListener;

public interface FormEventListener extends EventListener {
    public void formEventOccurred(FormEvent event);
}
