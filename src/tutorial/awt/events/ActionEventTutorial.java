/**
 * 
 */
package tutorial.awt.events;

import java.awt.event.*;

/**
 * @author hossam
 *
 */
public class ActionEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
		ActionEvent.ACTION_FIRST,
		ActionEvent.ACTION_LAST,
		ActionEvent.ACTION_PERFORMED,
		ActionEvent.ALT_MASK,
		ActionEvent.CTRL_MASK,
		ActionEvent.META_MASK,
		ActionEvent.SHIFT_MASK,
	};
	//--------
	// @constructors
	//--------------
	// ActionEvent w/ source & command
	public static ActionEvent aeNew = new ActionEvent(new Object(), 0, "New");
	// ActionEvent w/ source, command & modifier
	public static ActionEvent aeAlt = new ActionEvent(new Object(), 1, "ALT", ActionEvent.ALT_MASK);
	// ActionEvent w/ source, command, modifier & time stamp
	public static ActionEvent aeTimeStamp = new ActionEvent(new Object(), 2, "Time", 4, ActionEvent.CTRL_MASK);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get action command 
		String strActionCommand = aeNew.getActionCommand();
		System.out.println(strActionCommand);
		// get modifier for ActionEvent
		int actionModifier = aeAlt.getModifiers();
		System.out.println(actionModifier);
		// get time stamp of ActionEvent
		long timeStamp = aeTimeStamp.getWhen();
		System.out.println(timeStamp);
		
		// some protected & inherited methods
	}
	//---------
}
