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
public class WindowEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		WindowEvent.WINDOW_ACTIVATED,
		WindowEvent.WINDOW_CLOSED,
		WindowEvent.WINDOW_CLOSING,
		WindowEvent.WINDOW_DEACTIVATED,
		WindowEvent.WINDOW_DEICONIFIED,
		WindowEvent.WINDOW_FIRST,
		WindowEvent.WINDOW_GAINED_FOCUS,
		WindowEvent.WINDOW_ICONIFIED,
		WindowEvent.WINDOW_LAST,
		WindowEvent.WINDOW_LOST_FOCUS,
		WindowEvent.WINDOW_OPENED,
		WindowEvent.WINDOW_STATE_CHANGED,
	};
	//--------
	// @constructors
	//--------------
	// new window event
	public static Window window = null;
	public static WindowEvent weNew = new WindowEvent(window, 0);
	// window event w/ previous & following states
	public static WindowEvent weStates = new WindowEvent(window, 1, WindowEvent.WINDOW_CLOSING, WindowEvent.WINDOW_CLOSED);
	// window event w/ opposite window 
	public static WindowEvent weOpposite = new WindowEvent(window, 2, window);
	// window event w/ opposite window & states
	public static WindowEvent weOppositeStates = new WindowEvent(window, 4, window, WindowEvent.WINDOW_ACTIVATED, WindowEvent.WINDOW_FIRST);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get new state
		int state = weNew.getNewState();
		System.out.println(state);
		// get old state
		state = weStates.getOldState();
		// get opposite window
		Window opposite = weOpposite.getOppositeWindow();
		// get window originating the event
		opposite = weOppositeStates.getWindow();
		
		// some protected & inherited methods
	}
	//---------
}
