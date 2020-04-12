/**
 * 
 */
package tutorial.awt.events;

import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class InputEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		InputEvent.ALT_DOWN_MASK,
		InputEvent.ALT_GRAPH_DOWN_MASK,
		InputEvent.ALT_GRAPH_MASK,
		InputEvent.ALT_MASK,
		InputEvent.BUTTON1_DOWN_MASK,
		InputEvent.BUTTON1_MASK,
		InputEvent.BUTTON2_DOWN_MASK,
		InputEvent.BUTTON2_MASK,
		InputEvent.BUTTON3_DOWN_MASK,
		InputEvent.BUTTON3_MASK,
		InputEvent.CTRL_DOWN_MASK,
		InputEvent.CTRL_MASK,
		InputEvent.META_DOWN_MASK,
		InputEvent.META_MASK,
		InputEvent.SHIFT_DOWN_MASK,
		InputEvent.SHIFT_MASK,
	};
	//--------
	// @constructors
	//--------------
	// none available, abstract class
	public static InputEvent ipEvent = null;
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// consume the event, to not be processed in default manner
		ipEvent.consume();
		// get modifier mask
		int modifier = ipEvent.getModifiers();
		// get extended modifier mask
		modifier = ipEvent.getModifiersEx();
		// get extended modifier mask in string
		// should be accessed in a static manner
		String strModifier = InputEvent.getModifiersExText(modifier);
		System.out.println(strModifier);
		// get time stamp of i/p event
		long when = ipEvent.getWhen();
		System.out.println(when);
		// check alt modifier 
		boolean down = ipEvent.isAltDown();
		// check alt graph modifier
		down = ipEvent.isAltGraphDown();
		// check consumption of event
		down = ipEvent.isConsumed();
		// check ctrl modifier
		down = ipEvent.isControlDown();
		// check meta modifier
		down = ipEvent.isMetaDown();
		// check shift modifier
		down = ipEvent.isShiftDown();
		
		// some inherited methods
	}
	//---------
}
