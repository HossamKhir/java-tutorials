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
public class Arc2DTutorial extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	public static int[] fields = {
			Arc2D.CHORD,
			Arc2D.OPEN,
			Arc2D.PIE,
	};
	//--------
	// @constructors
	//--------------
	// abstract class, cannot be instantiated
	public static Arc2D arc2 = null;
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// check if a point is inside boundaries of arc
		boolean contained = arc2.contains(0.0, 0.0);
		// check if boundary of arc contains rectangle
		contained = arc2.contains(0.0, 0.0, 0.0, 0.0);
		Rectangle2D rect2 = null;
		contained = arc2.contains(rect2);
		// check if an angle is inside angular extent of arc
		contained = arc2.containsAngle(0.0);
		// check equality of an object to arc
		contained = arc2.equals(new Object());
		// get angular extent
		double extent = arc2.getAngleExtent();
		System.out.println(extent);
		// get starting angle
		extent = arc2.getAngleStart();
		// get closure type of arc
		int type = arc2.getArcType();
		System.out.println(type);
		// get high precision framing rectangle of arc
		rect2 = arc2.getBounds2D();
		// get ending point of arc
		Point2D end = arc2.getEndPoint();
		// get iteration object to define arc boundary
		PathIterator pIterate = arc2.getPathIterator(new AffineTransform());
		// get starting point of arc
		end = arc2.getStartPoint();
		// get hash code for arc
		type = arc2.hashCode();
		// check intersection of rectangle with interior of arc
		contained = arc2.intersects(extent, extent, extent, extent);
		// set angular extent
		arc2.setAngleExtent(extent);
		// set starting angle & angular extent
		arc2.setAngles(extent, extent, extent, extent);
		arc2.setAngles(end, end);
		// set starting angle by value
		arc2.setAngleStart(extent);
		// set starting angle by point relative to centre of arc
		arc2.setAngleStart(end);
		// set an arc to be same as another arc
		arc2.setArc(arc2);
		// set location, size, angular extent, & closure type
		arc2.setArc(extent, extent, extent, extent, extent, extent, Arc2D.OPEN);
		Dimension2D dimension2 = null;
		arc2.setArc(end, dimension2, 0.0, 0.0, Arc2D.PIE);
		arc2.setArc(rect2, extent, extent, Arc2D.CHORD);
		// set position, bounds, angular extent, & closure type
		arc2.setArcByCenter(extent, extent, extent, extent, extent, Arc2D.OPEN);
		// set position, bounds, & angular extent
		arc2.setArcByTangent(end, end, end, extent);
		// set closure type
		arc2.setArcType(type);
		// set framing rectangle
		arc2.setFrame(extent, extent, extent, extent);

		// some protected & inherited methods
	}
	//---------
	// @example
	//---------
	public Arc2DTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		Arc2DTutorial  arc2DTutorial = new Arc2DTutorial();  
		arc2DTutorial.setVisible(true);
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
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setFrame(70, 200, 150, 150);
		arc.setAngleStart(0);
		arc.setAngleExtent(145);
		Graphics2D g2 = (Graphics2D) g; 
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.CYAN);
		g2.fill(arc);
		g2.setColor(Color.black);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(font);
		g.drawString("Welcome to TutorialsPoint", 50, 70);
		g2.drawString("Arc2D.PIE", 100, 120); 
	}
	//---------
}
