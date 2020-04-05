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
public class AdjustmentEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		AdjustmentEvent.ADJUSTMENT_FIRST,
		AdjustmentEvent.ADJUSTMENT_LAST,
		AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED,
		AdjustmentEvent.BLOCK_DECREMENT,
		AdjustmentEvent.BLOCK_INCREMENT,
		AdjustmentEvent.TRACK,
		AdjustmentEvent.UNIT_DECREMENT,
		AdjustmentEvent.UNIT_INCREMENT,
	};
	//--------
	// @constructors
	//--------------
	// adjustment event w/ source, event type, adjustment type, & value
	public static AdjustmentEvent aeNew = new AdjustmentEvent(new Scrollbar(), 0, AdjustmentEvent.ADJUSTMENT_FIRST, 1);
	// adjustment event w/ source, event type, adjustment type, value & flag
	public static AdjustmentEvent aeFlag = new AdjustmentEvent(new Scrollbar(), 2, AdjustmentEvent.ADJUSTMENT_LAST, 4, true);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get source
		Adjustable adjustable = aeNew.getAdjustable();
		// get adjustment type
		int adjustmentType = aeFlag.getAdjustmentType();
		System.out.println(adjustmentType);
		// get value
		adjustmentType = aeNew.getValue();
		// check adjusting flag
		boolean adjusting = aeFlag.getValueIsAdjusting();
		
		// some protected & inherited methods
	}
	//---------
}
