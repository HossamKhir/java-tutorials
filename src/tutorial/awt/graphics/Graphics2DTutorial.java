/**
 * 
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.RenderingHints.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.image.renderable.*;
import java.text.AttributedCharacterIterator;

/**
 * @author hossam
 *
 */
public class Graphics2DTutorial extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// new graphics 2d
	public static Graphics2D graph2 = null;	// new Graphics2D(); 
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// set preferences for rendering algorithms
		Key key = null;
		graph2.addRenderingHints(new RenderingHints(key, new Object()));
		// intersect current clip w/ shape
		Shape shape = null;
		graph2.clip(shape);
		// draw 
		graph2.draw(shape);
		// draw 3D rectangle
		graph2.draw3DRect(0, 1, 2, 4, true);
		// render text
		GlyphVector gVector = null;
		graph2.drawGlyphVector(gVector, 0.0f, 0.0f);
		// render filtered buffered image
		BufferedImageOp biOp = null;
		graph2.drawImage(new BufferedImage(8, 16, 32), biOp, 64, 128);
		// render transformed image
		Image img = null;
		ImageObserver iObserve = null;
		boolean drawen = graph2.drawImage(img, new AffineTransform(), iObserve);
		// render transformed renderable image
		RenderableImage reImage = null;
		graph2.drawRenderableImage(reImage, new AffineTransform());
		// render transformed rendered image
		RenderedImage rdImage = null;
		graph2.drawRenderedImage(rdImage, new AffineTransform());
		// render text
		AttributedCharacterIterator acIterator = null;
		graph2.drawString(acIterator, 0.0f, 0.0f);
		graph2.drawString(acIterator, 256, 512);
		graph2.drawString("Float", 0.0f, 0.0f);
		graph2.drawString("Integer", 1024, 2048);
		// fill interior of shape
		graph2.fill(shape);
		// paint 3D rectangle
		graph2.fill3DRect(4096, 8192, 4096, 2048, true);
		// get colour
		Color colour = graph2.getBackground();
		// get composite
		Composite composite = graph2.getComposite();
		// get device configuration
		GraphicsConfiguration gConfig = graph2.getDeviceConfiguration();
		// get font rendering context
		FontRenderContext frContext = graph2.getFontRenderContext();
		// get paint
		Paint paint = graph2.getPaint();
		// get value of preference of rendering algorithm 
		Object hint = graph2.getRenderingHint(key);
		// get preferences of rendering algorithm
		RenderingHints rHints = graph2.getRenderingHints();
		// get current stroke
		Stroke stroke = graph2.getStroke();
		// get transform
		AffineTransform aTransform = graph2.getTransform();
		// check if shape intersects rectangel
		drawen = graph2.hit(new Rectangle(), shape, drawen);
		// concatenate transform w/ rotation
		graph2.rotate(0.0);
		// concatenate transform w/ translated rotation
		graph2.rotate(0.0, 0.0, 0.0);
		// concatenate transform w/ scale
		graph2.scale(0.0, 0.0);
		// set background colour
		graph2.setBackground(colour);
		// set composite
		graph2.setComposite(composite);
		// set paint
		graph2.setPaint(paint);
		// set value for preference for rendering algorithm
		graph2.setRenderingHint(key, hint);
		// replace preferences for rendering algorithm
		graph2.setRenderingHints(rHints);
		// set stroke
		graph2.setStroke(stroke);
		// set transform 
		graph2.setTransform(aTransform);
		// concatenate transform w/ shear
		graph2.shear(0.0, 0.0);
		// transform
		graph2.transform(aTransform);
		// concatenate transform w/ translation
		graph2.translate(0.0, 0.0);
		// translate origin
		graph2.translate(1024, 512);
	}
	//---------
	// @example
	//---------
	public Graphics2DTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		Graphics2DTutorial  graphics2DTutorial = new Graphics2DTutorial();  
		graphics2DTutorial.setVisible(true);
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
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(font);
		g2.drawString("Welcome to TutorialsPoint", 50, 70); 
	}
	//---------
}
