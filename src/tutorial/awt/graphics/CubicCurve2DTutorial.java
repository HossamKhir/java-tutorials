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
public class CubicCurve2DTutorial extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// abstract class cannot be instantiated
	public static CubicCurve2D cc2d = null;
	//--------------
	// @methods
	//---------
	public static void vMethods() {
		// create new object as this
		Object cloned = cc2d.clone();
		// check if coordinates inside shape boundary
		boolean contained = cc2d.contains(0.0, 0.0);
		// check if rectangle inside shape boundary
		contained = cc2d.contains(0.0, 0.0, 0.0, 0.0);
		// check if point inside shape boundary
		Point2D p2d = null;
		contained = cc2d.contains(p2d);
		// check if rectangle inside shape boundary
		Rectangle2D r2d = null;
		contained = cc2d.contains(r2d);
		// get rectangle enclosing the shape
		Rectangle rect = cc2d.getBounds();
		// get 1st control point
		p2d = cc2d.getCtrlP1();
		// get 2nd control point
		p2d = cc2d.getCtrlP2();
		// get x coordinate of 1st control point
		double xcor = cc2d.getCtrlX1();
		// get x coordinate of 2nd control point
		xcor = cc2d.getCtrlX2();
		// get y coordinate of 1st control point
		xcor = cc2d.getCtrlY1();
		// get y coordinate of 2nd control point
		xcor = cc2d.getCtrlY2();
		// get flatness of curve
		xcor = cc2d.getFlatness();
		// get flatness of curve @ control point w/ index
		xcor = CubicCurve2D.getFlatness(new double[0], 1);
		// get flatness of curve w/ control point
		xcor = CubicCurve2D.getFlatness(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		// get square of flatness of curve
		xcor = cc2d.getFlatnessSq();
		// get square of flatness of curve @ control point w/ index
		xcor = CubicCurve2D.getFlatnessSq(new double[2], 4);
		// get square of flatness of curve w/ control point
		xcor = CubicCurve2D.getFlatnessSq(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		// get start point
		p2d = cc2d.getP1();
		// get end point
		p2d = cc2d.getP2();
		// get iterator object defining boundary of the shape
		PathIterator pIterate = cc2d.getPathIterator(new AffineTransform());
		// get iterator object defining boundary of flattened shape
		pIterate = cc2d.getPathIterator(new AffineTransform(), xcor);
		// get x coordinate of starting point
		xcor = cc2d.getX1();
		// get x coordinate of end point
		xcor = cc2d.getX2();
		// get y coordinate of starting point
		xcor = cc2d.getY1();
		// get y coordinate of end point
		xcor = cc2d.getY2();
		// check intersection of curve w/ rectangle
		contained = cc2d.intersects(xcor, xcor, xcor, xcor);
		contained = cc2d.intersects(r2d);
		// set location of end & control points to specified curve
		cc2d.setCurve(cc2d);
		// set location of end & control points to offset coordinates
		cc2d.setCurve(new double[8], 16);
		// set location of end & control points w/ coordinates
		cc2d.setCurve(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		// set location of end & control points to offset point
		cc2d.setCurve(new Point2D[32], 64);
		// set location of end & control points to coordinates
		cc2d.setCurve(p2d, p2d, p2d, p2d);
		// solve cubic w/ coefficients, place non-complex roots in given array, return # roots
		int solved = CubicCurve2D.solveCubic(new double[128]);
		System.out.println(solved);
		// solve cubic w/ coefficients, place non-complex roots to the other array, return # roots
		solved = CubicCurve2D.solveCubic(new double[256], new double[512]);
		// subdivide curve & store it as left & right
		cc2d.subdivide(cc2d, cc2d);
		// subdivide source curve to left & right
		CubicCurve2D.subdivide(cc2d, cc2d, cc2d);
		// subdivide source curve @ index to left @ index & right @ index
		CubicCurve2D.subdivide(new double[1024], 2048, new double[4096], 8192, new double[4096], 2048);
	}
	//---------
	// @example
	//---------
	public CubicCurve2DTutorial(){
		super("Java AWT Examples");
		prepareGUI();
	}

	public static void main(String[] args){
		CubicCurve2DTutorial  cubicCurve2DTutorial = new CubicCurve2DTutorial();  
		cubicCurve2DTutorial.setVisible(true);
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
		CubicCurve2D shape = new CubicCurve2D.Float();
		shape.setCurve(250F,250F,20F,90F,140F,100F,350F,330F);       
		Graphics2D g2 = (Graphics2D) g; 
		g2.draw (shape);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g2.setFont(font);
		g.drawString("Welcome to TutorialsPoint", 50, 70);
		g2.drawString("CubicCurve2D.Curve", 100, 120);
	}
	//---------
}
