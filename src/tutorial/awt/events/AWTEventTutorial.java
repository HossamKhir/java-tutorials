/**
 * 
 */
package tutorial.awt.events;

import java.awt.*;

/**
 * @author hossam
 *
 */
public class AWTEventTutorial {
	// @fields
	//--------
	public static int[] iFields = {
//		AWTEvent.	
	};
	public static long[] lFields = {
			AWTEvent.ACTION_EVENT_MASK,
			AWTEvent.ADJUSTMENT_EVENT_MASK,
			AWTEvent.COMPONENT_EVENT_MASK,
			AWTEvent.CONTAINER_EVENT_MASK,
			AWTEvent.FOCUS_EVENT_MASK,
			AWTEvent.HIERARCHY_BOUNDS_EVENT_MASK,
			AWTEvent.HIERARCHY_EVENT_MASK,
			AWTEvent.INPUT_METHOD_EVENT_MASK,
			AWTEvent.INVOCATION_EVENT_MASK,
			AWTEvent.ITEM_EVENT_MASK,
			AWTEvent.KEY_EVENT_MASK,
			AWTEvent.MOUSE_EVENT_MASK,
			AWTEvent.MOUSE_MOTION_EVENT_MASK,
			AWTEvent.MOUSE_WHEEL_EVENT_MASK,
			AWTEvent.PAINT_EVENT_MASK,
			AWTEvent.RESERVED_ID_MAX,
			AWTEvent.TEXT_EVENT_MASK,
			AWTEvent.WINDOW_EVENT_MASK,
			AWTEvent.WINDOW_FOCUS_EVENT_MASK,
			AWTEvent.WINDOW_STATE_EVENT_MASK,
	};
	//--------
	// @constructors
	//--------------
	// cannot be instantiated
	// new AWTEvent object
//	public static AWTEvent awtEvent = new AWTEvent(new Event(new Object(), 0, new Object()));
	// AWTEvent w/ source object
//	public static AWTEvent awtObject = new AWTEvent(new Object(), 0);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get event type
		AWTEvent awtDummy = null;
		int id = awtDummy.getID();
		System.out.println(id);
		// set event source
		awtDummy.setSource(new Object());
		// get event as string
		String strEvent = awtDummy.toString();
		System.out.println(strEvent);
		
		// some protected & inherited methods
	}
	//---------
}
