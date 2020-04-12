/**
 * 
 */
package tutorial.awt.events;

import java.awt.*;
import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class ComponentEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		ComponentEvent.COMPONENT_FIRST,
		ComponentEvent.COMPONENT_HIDDEN,
		ComponentEvent.COMPONENT_LAST,
		ComponentEvent.COMPONENT_MOVED,
		ComponentEvent.COMPONENT_RESIZED,
		ComponentEvent.COMPONENT_SHOWN,
	};
	//--------
	// @constructors
	//--------------
	// new component event
	public static ComponentEvent ceNew = new ComponentEvent(new Label(), 0);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get source component
		Component cmp = ceNew.getComponent();
		
		// some protected & inherited methods
	}
	//---------
}
