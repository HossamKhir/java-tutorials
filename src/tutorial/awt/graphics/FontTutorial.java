/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Hossam
 */
public class FontTutorial extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	public static int[] intFields = {
			Font.BOLD,
			Font.CENTER_BASELINE,
			Font.HANGING_BASELINE,
			Font.ITALIC,
			Font.LAYOUT_LEFT_TO_RIGHT,
			Font.LAYOUT_NO_LIMIT_CONTEXT,
			Font.LAYOUT_NO_START_CONTEXT,
			Font.LAYOUT_RIGHT_TO_LEFT,
			Font.PLAIN,
			Font.ROMAN_BASELINE,
			Font.TRUETYPE_FONT,
			Font.TYPE1_FONT,
	};
	public static String[] strFields = {
			Font.DIALOG,
			Font.DIALOG_INPUT,
			Font.MONOSPACED,
			Font.SANS_SERIF,
			Font.SERIF,
	};
	//--------
	// @constructors
	//--------------
	// new font from specified font
	public static Font fntNew = new Font("Font", 0, 1);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// check if font has glyph for character
		boolean glyph = fntNew.canDisplay('H');
		glyph = fntNew.canDisplay(2);
		// find ability of font to display text w/ index
		int display = fntNew.canDisplayUpTo(new char[4], 8, 16);
		System.out.println(display);
		// check ability of font to display text w/ iterator
		CharacterIterator cIterate = null;
		display = fntNew.canDisplayUpTo(cIterate, 32, 64);
		// check ability of font to display string
		String strText = "String";
		display = fntNew.canDisplayUpTo(strText);
		// create font using font type & font file
		try {
			Font fntFile = Font.createFont(Font.BOLD, new File(strText));
		} catch (FontFormatException ex) {
			Logger.getLogger(FontTutorial.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FontTutorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		// create font using font type & i/p data
		InputStream iStream = null;
		try {
			Font fntInput = Font.createFont(Font.ITALIC, iStream);
		} catch (FontFormatException ex) {
			Logger.getLogger(FontTutorial.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FontTutorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		// create gylph vector, mapping characters to glyphs 1 to 1 using cmap
		FontRenderContext frContext = null;
		GlyphVector gVector = fntNew.createGlyphVector(frContext, new char[128]);
		gVector = fntNew.createGlyphVector(frContext, cIterate);
		gVector = fntNew.createGlyphVector(frContext, new int[256]);
		gVector = fntNew.createGlyphVector(frContext, strText);
		// get font described by string
		Font decoded = Font.decode(strText);
		// get new font by applying transform on current font
		decoded = fntNew.deriveFont(new AffineTransform());
		// get new font by resizing current font
		decoded = fntNew.deriveFont(0.0f);
		// get new font by changing style of current font
		decoded = fntNew.deriveFont(Font.PLAIN);
		// get new font by changing style, & transform current form
		decoded = fntNew.deriveFont(Font.BOLD, new AffineTransform());
		// get new font by changing style & size of current form
		decoded = fntNew.deriveFont(Font.ITALIC, 0);
		// get new font by applying new attributes to current form
		decoded = fntNew.deriveFont(new HashMap<>());
		// compare font to object
		glyph = fntNew.equals(new Object());
		// get map of font attributes
		Map<TextAttribute, ?> mpAttributes = fntNew.getAttributes();
		// get array of keys of attributes
		AttributedCharacterIterator.Attribute[] attributes = fntNew.getAvailableAttributes();
		// get baseline of character
		byte baseline = fntNew.getBaselineFor(' ');
		// get family name of font
		strText = fntNew.getFamily();
		// get family name of localised font
		strText = fntNew.getFamily(new Locale(strText));
		// get font by attributes
		decoded = Font.getFont(mpAttributes);
		// get font from system properties list
		decoded = Font.getFont(strText);
		// get specific font from system properties list
		decoded = Font.getFont(strText, decoded);
		// get font face name
		strText = fntNew.getFontName();
		// get localised font face name
		strText = fntNew.getFontName(new Locale(strText));
		// get italic angle
		double angle = fntNew.getItalicAngle();
		// get line metrics w/ specified arguments
		LineMetrics lMetrics = fntNew.getLineMetrics(new char[512], 1024, 2048, frContext);
		lMetrics = fntNew.getLineMetrics(cIterate, 4096, 8192, frContext);
		lMetrics = fntNew.getLineMetrics(strText, 4096, 2048, frContext);
		// get line metrics w/ specific string & context
		lMetrics = fntNew.getLineMetrics(strText, frContext);
		// get max bounds for character 
		Rectangle2D bound = fntNew.getMaxCharBounds(frContext);
		// get missing glyph code
		display = fntNew.getMissingGlyphCode();
		// get logical name of font
		strText = fntNew.getName();
		// get # glyphs in font
		display = fntNew.getNumGlyphs();
		// get post script name of font
		strText = fntNew.getPSName();
		// get point size of font as integer
		display = fntNew.getSize();
		// get point size of font as float
		float fltPoint = fntNew.getSize2D();
		// get bounds for array of characters
		bound = fntNew.getStringBounds(new char[1024], 512, 256, frContext);
		// get bounds for character iterator
		bound = fntNew.getStringBounds(cIterate, 128, 64, frContext);
		// get bounds of string
		bound = fntNew.getStringBounds(strText, frContext);
		bound = fntNew.getStringBounds(strText, 32, 16, frContext);
		// get style of font
		display = fntNew.getStyle();
		// get transform associated w/ font
		AffineTransform aTrans = fntNew.getTransform();
		// get hash code for font
		display = fntNew.hashCode();
		// check requirement of extra layout processing
		glyph = fntNew.hasLayoutAttributes();
		// check presence of uniform line metrics
		glyph = fntNew.hasUniformLineMetrics();
		// check if font's style is bold
		glyph = fntNew.isBold();
		// check if font's style is italic
		glyph = fntNew.isItalic();
		// check if font's style is plain
		glyph = fntNew.isPlain();
		// check if font has transform
		glyph = fntNew.isTransformed();
		// get glyph vector performing full layout of text
		gVector = fntNew.layoutGlyphVector(frContext, new char[8], 4, 2, 1);
		// convert font to string representation
		strText = fntNew.toString();

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	public FontTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		FontTutorial fontTutorial = new FontTutorial();  
		fontTutorial.setVisible(true);
	}

	private void prepareGUI(){
		setSize(400,400);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		}); 
	}    

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;        
		Font plainFont = new Font("Serif", Font.PLAIN, 24);        
		g2.setFont(plainFont);
		g2.drawString("Welcome to TutorialsPoint", 50, 70); 
		Font italicFont = new Font("Serif", Font.ITALIC, 24);        
		g2.setFont(italicFont);
		g2.drawString("Welcome to TutorialsPoint", 50, 120); 
		Font boldFont = new Font("Serif", Font.BOLD, 24);        
		g2.setFont(boldFont);
		g2.drawString("Welcome to TutorialsPoint", 50, 170); 
		Font boldItalicFont = new Font("Serif", Font.BOLD+Font.ITALIC, 24);        
		g2.setFont(boldItalicFont);
		g2.drawString("Welcome to TutorialsPoint", 50, 220); 
	}
	//---------
}
