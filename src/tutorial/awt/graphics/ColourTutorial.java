/**
 * 
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

/**
 * @author hossam
 *
 */
public class ColourTutorial extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	public static Color[] fields = {
			Color.black,
			Color.blue,
			Color.cyan,
			Color.darkGray,
			Color.gray,
			Color.green,
			Color.lightGray,
			Color.magenta,
			Color.orange,
			Color.pink,
			Color.red,
			Color.white,
			Color.yellow,
	};
	public static Color[] FIELDS = {
			Color.BLACK,
			Color.BLUE,
			Color.CYAN,
			Color.DARK_GRAY,
			Color.GRAY,
			Color.GREEN,
			Color.LIGHT_GRAY,
			Color.MAGENTA,
			Color.ORANGE,
			Color.PINK,
			Color.RED,
			Color.WHITE,
			Color.YELLOW,
	};
	//--------
	// @constructors
	//--------------
	// create colour in colour space, w/ colour component & alpha
	private static ColorSpace cSpace;
	//	public static Color clrSpace = new Color(cSpace, new float[0], 0.0f);
	// create opaque colour w/ red, green, blue floats
	public static Color clrRGB = new Color(0.0f, 0.5f, 1.0f);
	// create colour w/ red, green, blue, alpha floats
	public static Color clrAlpha = new Color(1.0f, 0.5f, 0.0f, 0.5f);
	// create opaque colour w/ combined blue (bit 0:7), green (bit 8:15), red (bit 16:23)
	public static Color clrCombined = new Color(0 + (1 << 8) + (2 << 16));
	// create colour w/ combined blue (bit 0:7), green (bit 8:15), red (bit 16:23), alpha (bit 24:31)
	public static Color clrAlComp = new Color(4 + (8 << 8) + (16 << 16) + (32 << 24), true);
	// create opaque colour w/ red, green, blue integers
	public static Color clrInt = new Color(64, 128, 64);
	// create colour w/ red, green, blue, alpha integers
	public static Color clrAlInt = new Color(32, 16, 8, 4);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		Color clrSpace;
		// get brighter colour from current one
		clrSpace = clrRGB.brighter();
		// get paint context for solid colour pattern
		ColorModel cModel = null;
		Rectangle2D r2d = null;
		RenderingHints rHints = null;
		PaintContext pContext 
		= clrAlpha.createContext(cModel, new Rectangle(), r2d, new AffineTransform(), rHints);
		// get darker colour from current one
		clrCombined = clrAlComp.darker();
		// convert string to integer & get specified opaque colour
		clrInt = Color.decode("String");
		// check equality of an object to colour
		boolean equal = clrAlInt.equals(new Object());
		// get alpha component in integer
		int alpha = clrSpace.getAlpha();
		System.out.println(alpha);
		// get blue component in integer
		alpha = clrRGB.getBlue();
		// find colour in system properties
		clrAlpha = Color.getColor("System");
		clrCombined = Color.getColor("Colur", clrInt);
		clrAlInt = Color.getColor("Integer", 2);
		// get colour components
		float[] components = clrSpace.getColorComponents(cSpace, new float[1]);
		components = clrRGB.getColorComponents(components);
		// get colour space
		cSpace = clrAlpha.getColorSpace();
		// get colour & alpha components
		components = clrCombined.getComponents(cSpace, components);
		components = clrInt.getComponents(components);
		// get green component in integer
		alpha = clrAlInt.getGreen();
		// create colour w/ HSB colour model
		clrSpace = Color.getHSBColor(components[0], components[1], components[2]);
		// get red component in integer
		alpha = clrRGB.getRed();
		// get combined rgb color components in integer
		alpha = clrAlpha.getRGB();
		// get RGB colour components in floats
		components = clrCombined.getRGBColorComponents(components);
		// get RGB colour & alpha components in floats
		components = clrInt.getRGBComponents(components);
		// get transparency mode
		alpha = clrAlInt.getTransparency();
		// compute hash code for colour
		alpha = clrSpace.hashCode();
		// convert HSB to RGB
		alpha = Color.HSBtoRGB(components[4], components[8], components[16]);
		// convert RGB to HSB
		components = Color.RGBtoHSB(alpha, alpha, alpha, components);
		System.out.println(clrRGB.toString());

		// some inherited methods
	}
	//---------
	// @example
	//---------
	public ColourTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		ColourTutorial  colourTutorial = new ColourTutorial();  
		colourTutorial.setVisible(true);
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
		g2.setColor(Color.red);
		g2.drawString("Welcome to TutorialsPoint", 50, 70); 
		g2.setColor(Color.GRAY);
		g2.drawString("Welcome to TutorialsPoint", 50, 120);  
	}
	//---------
}
