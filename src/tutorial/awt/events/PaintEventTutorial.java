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
public class PaintEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		PaintEvent.PAINT,
		PaintEvent.PAINT_FIRST,
		PaintEvent.PAINT_LAST,
		PaintEvent.UPDATE,
	};
	//--------
	// @constructors
	//--------------
	// paint event w/ source & type
	public static PaintEvent peNew = new PaintEvent(new Frame(), 0, new Rectangle());
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get rectangular area to repaint
		Rectangle rect = peNew.getUpdateRect();
		// set rectangular area to repaint
		peNew.setUpdateRect(rect);
		
		// some protected & inherited methods
	}
	//---------
}
