/**
 * 
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * @author hossam
 *
 */
public class BasicStrokeTutorial extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	public static int[] fields = {
			BasicStroke.CAP_BUTT,
			BasicStroke.CAP_ROUND,
			BasicStroke.CAP_SQUARE,
			BasicStroke.JOIN_BEVEL,
			BasicStroke.JOIN_MITER,
			BasicStroke.JOIN_ROUND,
	};
	//--------
	// @constructors
	//--------------
	// default basic stroke
	public static BasicStroke bsDefault = new BasicStroke();
	// basic stroke w/ line width
	public static BasicStroke bsWidth = new BasicStroke(0.0f);
	// solid basic stroke w/ attributes
	public static BasicStroke bsSolid = new BasicStroke(0.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	public static BasicStroke bsLimit = new BasicStroke(0.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f);
	public static BasicStroke bsDash 
	= new BasicStroke(0.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 1.0f, new float[] {1.0f}, 0.0f);
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// get shape w/ stroked outline interior
		Shape shape = null;
		shape = bsDefault.createStrokedShape(shape);
		// check if an object equals a basic stroke
		boolean equals = bsWidth.equals(new Object());
		// get array of dash segments lengths
		float[] dash = bsSolid.getDashArray();
		System.out.println(dash);
		// get current dash phase
		dash[1] = bsLimit.getDashPhase();
		// get end cap style
		int end = bsDash.getEndCap();
		System.out.println(end);
		// get line join style
		end = bsDefault.getLineJoin();
		// get line width
		dash[2] = bsWidth.getLineWidth();
		// get limit of miter join
		dash[4] = bsSolid.getMiterLimit();
		// get hash code of basic stroke
		end = bsLimit.hashCode();

		// some inherited methods
	}
	//---------
	// @example
	//---------
	public BasicStrokeTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		BasicStrokeTutorial  basicStrokeTutorial = new BasicStrokeTutorial();  
		basicStrokeTutorial.setVisible(true);
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
		g2.setStroke(new BasicStroke(3.0f));
		g2.setPaint(Color.blue);

		Rectangle2D shape = new Rectangle2D.Float();
		shape.setFrame(100, 150, 200,100);
		g2.draw(shape);

		Rectangle2D shape1 = new Rectangle2D.Float();
		shape1.setFrame(110, 160, 180,80);
		g2.setStroke(new BasicStroke(1.0f));

		g2.draw(shape1);
		Font plainFont = new Font("Serif", Font.PLAIN, 24);        
		g2.setFont(plainFont);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString("TutorialsPoint", 130, 200);
	}
	//---------
}
