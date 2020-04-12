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
public class MouseEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		MouseEvent.BUTTON1,
		MouseEvent.BUTTON2,
		MouseEvent.BUTTON3,
		MouseEvent.MOUSE_CLICKED,
		MouseEvent.MOUSE_DRAGGED,
		MouseEvent.MOUSE_ENTERED,
		MouseEvent.MOUSE_EXITED,
		MouseEvent.MOUSE_FIRST,
		MouseEvent.MOUSE_LAST,
		MouseEvent.MOUSE_MOVED,
		MouseEvent.MOUSE_PRESSED,
		MouseEvent.MOUSE_RELEASED,
		MouseEvent.MOUSE_WHEEL,
		MouseEvent.NOBUTTON,
	};
	//--------
	// @constructors
	//--------------
	// mouse event w/ source, type, modifiers, coordinates, & click count
	public static MouseEvent meNew = new MouseEvent(new Frame(), 0, 1, InputEvent.ALT_DOWN_MASK, 2, 4, 8, true);
	// 
	public static MouseEvent meButton = new MouseEvent(new Frame(), 16, 32, InputEvent.CTRL_DOWN_MASK, 64, 256, 512, false, MouseEvent.BUTTON2);
	// mouse event w/ source, type, modifiers, coordinates, absolute coordinates, & click count
	public static MouseEvent meAbsolute = new MouseEvent(new Frame(), 1024, 2048, InputEvent.SHIFT_DOWN_MASK, 4096, 8192, 4096, 8192, 2048, true, MouseEvent.BUTTON1);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get which button changed state
		int button = meNew.getButton();
		System.out.println(button);
		// get click counts 
		button = meButton.getClickCount();
		// get absolute x, y positions
		Point absPosition = meAbsolute.getLocationOnScreen();
		// get modifiers as string
		// must be called statically
		String strModifiers = MouseEvent.getModifiersExText(button);
		System.out.println(strModifiers);
		// get relative x, y positions
		absPosition = meNew.getPoint();
		// get relative x position
		button = meButton.getX();
		// get absolute x position
		button = meAbsolute.getXOnScreen();
		// get relative y position
		button = meNew.getY();
		// get absolute y position
		button = meButton.getYOnScreen();
		// check pop up trigger
		boolean isPopUp = meAbsolute.isPopupTrigger();
		// translate to a new position
		meNew.translatePoint(absPosition.x, absPosition.y);
		
		// some protected & inherited methods
	}
	//---------
}
