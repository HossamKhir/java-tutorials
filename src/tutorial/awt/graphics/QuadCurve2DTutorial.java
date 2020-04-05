/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 *
 * @author Hossam
 */
public class QuadCurve2DTutorial extends Frame {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // abstract class cannot be instantiated
    public static QuadCurve2D qc2d = null;  // new QuadCurve2D
    //--------------
    // @methods
    //---------

    public static void vMethods() {
        // create new object w/ same content
        Object obj = qc2d.clone();
        // check if coordinates inside boundary
        boolean contain = qc2d.contains(0.0, 0.0);
        // check if rectangle inside boundary
        contain = qc2d.contains(0.0, 0.0, 0.0, 0.0);
        Rectangle2D r2d = null;
        contain = qc2d.contains(r2d);
        // check if point inside boundary
        Point2D p2d = null;
        contain = qc2d.contains(p2d);
        // get rectangle enclosing shape
        Rectangle rect = qc2d.getBounds();
        // get control point
        p2d = qc2d.getCtrlPt();
        // get x coordinate of control point
        double xcor = qc2d.getCtrlX();
        // get y coordinate of control point
        xcor = qc2d.getCtrlY();
        // get flatness
        xcor = qc2d.getFlatness();
        // get flatness from offset control points
        xcor = QuadCurve2D.getFlatness(new double[0], 1);
        // get flatness from control points
        xcor = QuadCurve2D.getFlatness(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        // get square flatness
        xcor = qc2d.getFlatnessSq();
        // get square flatness from offset control points
        xcor = QuadCurve2D.getFlatnessSq(new double[2], 4);
        // get square flatness from control points
        xcor = QuadCurve2D.getFlatnessSq(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        // get start point
        p2d = qc2d.getP1();
        // get end point
        p2d = qc2d.getP2();
        // get iterator defining boundary of curve
        PathIterator pIterate = qc2d.getPathIterator(new AffineTransform());
        // get iterator defining flattened boundary of curve
        pIterate = qc2d.getPathIterator(new AffineTransform(), xcor);
        // get x coordinate of start point
        xcor = qc2d.getX1();
        // get x coordinate of end point
        xcor = qc2d.getX2();
        // get y coordinate of start point
        xcor = qc2d.getY1();
        // get y coordinate of end point
        xcor = qc2d.getY2();
        // check intersection of rectangle w/ shape
        contain = qc2d.intersects(xcor, xcor, xcor, xcor);
        contain = qc2d.intersects(r2d);
        // set location of end & control points w/ offset coordinates
        qc2d.setCurve(new double[8], 16);
        // set location of end & control points w/ coordinates
        qc2d.setCurve(xcor, xcor, xcor, xcor, xcor, xcor);
        // set location of end & control points w/ offset points
        qc2d.setCurve(new Point2D[32], 64);
        // set location of end & control points w/ points
        qc2d.setCurve(p2d, p2d, p2d);
        // set location of end & control points from quad curve
        qc2d.setCurve(qc2d);
        // solve quadratic w/ coefficients, place non-complex roots into i/p array & get # roots
        int roots = QuadCurve2D.solveQuadratic(new double[128]);
        // solve quadratic w/ coefficients, place non-complex roots into other array & get # roots
        roots = QuadCurve2D.solveQuadratic(new double[256], new double[512]);
        // subdivide curve into 2 curves
        QuadCurve2D.subdivide(new double[1024], 2048, new double[4096], 8192, new double[4096], 2048);
        QuadCurve2D.subdivide(qc2d, qc2d, qc2d);
        // subdivid into 2 curves
        qc2d.subdivide(qc2d, qc2d);

        // some inherited methods
    }

    //---------
    // @example
    //---------
    public QuadCurve2DTutorial() {
        super("Java AWT Examples");
        prepareGUI();
    }

    public static void main(String[] args) {
        QuadCurve2DTutorial quadCurve2DTutorial = new QuadCurve2DTutorial();
        quadCurve2DTutorial.setVisible(true);
    }

    private void prepareGUI() {
        setSize(400, 400);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        QuadCurve2D shape = new QuadCurve2D.Double();
        shape.setCurve(250D, 250D, 100D, 100D, 200D, 150D);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(shape);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 70);
        g2.drawString("QuadCurve2D.Curve", 100, 120);
    }
    //---------
}
