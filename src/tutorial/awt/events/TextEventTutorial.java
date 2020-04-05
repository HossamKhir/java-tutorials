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
public class TextEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		TextEvent.TEXT_FIRST,
		TextEvent.TEXT_LAST,
		TextEvent.TEXT_VALUE_CHANGED,
	};
	//--------
	// @constructors
	//--------------
	// new text event object
	public static TextEvent teNew = new TextEvent(new Frame(), 0);
	//--------------
	// @methods
	//---------
	// protected & inherited methods
	//---------
}
