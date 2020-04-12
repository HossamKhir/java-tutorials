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
public class ContainerEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		ContainerEvent.COMPONENT_ADDED,
		ContainerEvent.COMPONENT_REMOVED,
		ContainerEvent.CONTAINER_FIRST,
		ContainerEvent.CONTAINER_LAST,
	};
	//--------
	// @constructors
	//--------------
	// new container event
	private static Container container = null;
	public static ContainerEvent ceNew = new ContainerEvent(container, 0, container);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get child component
		Component child = ceNew.getChild();
		// get source
		child = ceNew.getContainer();
		
		// some protected & inherited methods
	}
	//---------
}
