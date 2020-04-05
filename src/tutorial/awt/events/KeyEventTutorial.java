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
public class KeyEventTutorial {
	// @fields
	//--------
	public static int[] fields = {
			KeyEvent.CHAR_UNDEFINED,
			KeyEvent.KEY_FIRST,
			KeyEvent.KEY_LAST,
			KeyEvent.KEY_LOCATION_LEFT,
			KeyEvent.KEY_LOCATION_NUMPAD,
			KeyEvent.KEY_LOCATION_RIGHT,
			KeyEvent.KEY_LOCATION_STANDARD,
			KeyEvent.KEY_LOCATION_UNKNOWN,
			KeyEvent.KEY_PRESSED,
			KeyEvent.KEY_RELEASED,
			KeyEvent.KEY_TYPED,
			// VK_0 -> VK_9 == ASCII [0, 9]
			KeyEvent.VK_0,
			KeyEvent.VK_9,
			// VK_A -> VK_Z == ASCII [A, Z]
			KeyEvent.VK_A,
			KeyEvent.VK_ACCEPT,
			KeyEvent.VK_ADD,
			KeyEvent.VK_AGAIN,
			KeyEvent.VK_ALL_CANDIDATES,
			KeyEvent.VK_ALPHANUMERIC,
			KeyEvent.VK_ALT,
			KeyEvent.VK_ALT_GRAPH,
			KeyEvent.VK_AMPERSAND,	// &
			KeyEvent.VK_ASTERISK,	// *
			KeyEvent.VK_AT,			// @
			KeyEvent.VK_BACK_QUOTE,
			KeyEvent.VK_BACK_SLASH,	// \
			KeyEvent.VK_BACK_SPACE,
			KeyEvent.VK_BEGIN,
			KeyEvent.VK_BRACELEFT,
			KeyEvent.VK_BRACERIGHT,
			KeyEvent.VK_CANCEL,
			KeyEvent.VK_CAPS_LOCK,
			KeyEvent.VK_CIRCUMFLEX,	// ^
			KeyEvent.VK_CLEAR,
			KeyEvent.VK_CLOSE_BRACKET,	// ]
			KeyEvent.VK_CODE_INPUT,
			KeyEvent.VK_COLON,	// :
			KeyEvent.VK_COMMA,	// ,
			KeyEvent.VK_COMPOSE,
			KeyEvent.VK_CONTEXT_MENU, // MS windows context menu key
			KeyEvent.VK_CONTROL,
			KeyEvent.VK_CONVERT,
			KeyEvent.VK_COPY,
			KeyEvent.VK_CUT,
			KeyEvent.VK_DEAD_ABOVEDOT,
			KeyEvent.VK_DEAD_ABOVERING,
			KeyEvent.VK_DEAD_ACUTE,
			KeyEvent.VK_DEAD_BREVE,
			KeyEvent.VK_DEAD_CARON,
			KeyEvent.VK_DEAD_CEDILLA,
			KeyEvent.VK_DEAD_CIRCUMFLEX,
			KeyEvent.VK_DEAD_DIAERESIS,
			KeyEvent.VK_DEAD_DOUBLEACUTE,
			KeyEvent.VK_DEAD_GRAVE,
			KeyEvent.VK_DEAD_IOTA,
			KeyEvent.VK_DEAD_MACRON,
			KeyEvent.VK_DEAD_OGONEK,
			KeyEvent.VK_DEAD_SEMIVOICED_SOUND,
			KeyEvent.VK_DEAD_TILDE,
			KeyEvent.VK_DEAD_VOICED_SOUND,
			KeyEvent.VK_DECIMAL,
			KeyEvent.VK_DELETE,
			KeyEvent.VK_DIVIDE,
			KeyEvent.VK_DOLLAR,	// $
			KeyEvent.VK_DOWN,
			KeyEvent.VK_END,
			KeyEvent.VK_ENTER,
			KeyEvent.VK_EQUALS,	// =
			KeyEvent.VK_ESCAPE,
			KeyEvent.VK_EURO_SIGN,
			KeyEvent.VK_EXCLAMATION_MARK,	// !
			// VK_F1 -> VK_F24 == buttons [F1, F24]
			KeyEvent.VK_F1,
			KeyEvent.VK_F24,
			KeyEvent.VK_FINAL,
			KeyEvent.VK_FIND,
			KeyEvent.VK_FULL_WIDTH,
			KeyEvent.VK_GREATER,
			KeyEvent.VK_HALF_WIDTH,
			KeyEvent.VK_HELP,
			KeyEvent.VK_HIRAGANA,
			KeyEvent.VK_HOME,
			KeyEvent.VK_INPUT_METHOD_ON_OFF,
			KeyEvent.VK_INSERT,
			KeyEvent.VK_INVERTED_EXCLAMATION_MARK,
			KeyEvent.VK_JAPANESE_HIRAGANA,
			KeyEvent.VK_JAPANESE_KATAKANA,
			KeyEvent.VK_JAPANESE_ROMAN,
			KeyEvent.VK_KANA,
			KeyEvent.VK_KANA_LOCK,
			KeyEvent.VK_KANJI,
			KeyEvent.VK_KATAKANA,
			KeyEvent.VK_KP_DOWN,	// numeric keypad down
			KeyEvent.VK_KP_LEFT,	// numeric keypad left
			KeyEvent.VK_KP_RIGHT,	// numeric keypad right
			KeyEvent.VK_KP_UP,		// numeric keypad up
			KeyEvent.VK_LEFT,	// left arrow key
			KeyEvent.VK_LEFT_PARENTHESIS, // (
			KeyEvent.VK_LESS,
			KeyEvent.VK_META,
			KeyEvent.VK_MINUS,	// -
			KeyEvent.VK_MODECHANGE,
			KeyEvent.VK_MULTIPLY,
			KeyEvent.VK_NONCONVERT,
			KeyEvent.VK_NUM_LOCK,
			KeyEvent.VK_NUMBER_SIGN,
			// VK_NUMPAD0 -> VK_NUMPAD9 == numpad [0, 9]
			KeyEvent.VK_NUMPAD0,
			KeyEvent.VK_NUMPAD9,
			KeyEvent.VK_OPEN_BRACKET,	// [
			KeyEvent.VK_PAGE_DOWN,
			KeyEvent.VK_PAGE_UP,
			KeyEvent.VK_PASTE,
			KeyEvent.VK_PAUSE,
			KeyEvent.VK_PERIOD,	// .
			KeyEvent.VK_PLUS,	// +
			KeyEvent.VK_PREVIOUS_CANDIDATE,
			KeyEvent.VK_PRINTSCREEN,
			KeyEvent.VK_PROPS,
			KeyEvent.VK_QUOTE,
			KeyEvent.VK_QUOTEDBL,
			KeyEvent.VK_RIGHT,	// right arrow key
			KeyEvent.VK_RIGHT_PARENTHESIS,	// )
			KeyEvent.VK_ROMAN_CHARACTERS,
			KeyEvent.VK_SCROLL_LOCK,
			KeyEvent.VK_SEMICOLON,	// ;
			KeyEvent.VK_SEPARATOR,
			KeyEvent.VK_SHIFT,
			KeyEvent.VK_SLASH,	// /
			KeyEvent.VK_SPACE,
			KeyEvent.VK_STOP,
			KeyEvent.VK_SUBTRACT,
			KeyEvent.VK_TAB,
			KeyEvent.VK_UNDEFINED,
			KeyEvent.VK_UNDERSCORE,	// _
			KeyEvent.VK_UNDO,
			KeyEvent.VK_UP,
			KeyEvent.VK_WINDOWS, // windows key
	};
	//--------
	// @constructors
	//--------------
	// KeyEvent object
	public static KeyEvent keNew = new KeyEvent(new Frame(), 0, 1, InputEvent.ALT_DOWN_MASK, KeyEvent.VK_WINDOWS, 'c');
	// 
	public static KeyEvent keLocation = new KeyEvent(new Frame(), 2, 4, InputEvent.CTRL_DOWN_MASK, KeyEvent.VK_ASTERISK, '*', 8);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get associated character to the key event
		char associate = keNew.getKeyChar();
		System.out.println(associate);
		// get key code associated with key event
		int code = keLocation.getKeyCode();
		System.out.println(code);
		// get key location that originated the key event
		code = keNew.getKeyLocation();
		// get key modifiers
		// should be called statically 
		String strModifiers = KeyEvent.getModifiersExText(code);
		System.out.println(strModifiers);
		// get key code as string
		// should be called statically
		strModifiers = KeyEvent.getKeyText(code);
		// check if action key or not
		boolean isAction = keLocation.isActionKey();
		// set key character
		keNew.setKeyChar(associate);
		// set key code
		keLocation.setKeyCode(code);
		
		// some protected & inherited methods
	}
	//---------

}
