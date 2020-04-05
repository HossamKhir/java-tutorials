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
public class Rectangle2DTutorial extends Frame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @fields
    //--------
    public static int[] fields = {
        Rectangle2D.OUT_BOTTOM,
        Rectangle2D.OUT_LEFT,
        Rectangle2D.OUT_RIGHT,
        Rectangle2D.OUT_TOP,};
    //--------
    // @constructors
    //--------------
    // abstract class cannot instantiate
    public static Rectangle2D r2d = null;   // new Rectangle2D();
    //--------------
    // @methods
    //---------

    public static void vMethods() {
        // add point to rectangle
        r2d.add(0.0, 0.0);
        Point2D p2d = null;
        r2d.add(p2d);
        // add rectangle to rectangle
        r2d.add(r2d);
        // check coordinate inside rectangle boundary
        boolean contain = r2d.contains(0.0, 0.0);
        // check rectangle inside boundary
        contain = r2d.contains(0.0, 0.0, 0.0, 0.0);
        // get intersected rectangle w/ rectangle
        Rectangle2D intersect = r2d.createIntersection(r2d);
        // get union of rectangle w/ rectangle
        intersect = r2d.createUnion(r2d);
        // check if object equals rectangle
        contain = r2d.equals(new Object());
        // get bounds of rectangle
        intersect = r2d.getBounds2D();
        // get iterator defining rectangle
        PathIterator pIterate = r2d.getPathIterator(new AffineTransform());
        // get hashcode for rectangle
        int hash = r2d.hashCode();
        System.out.println(hash);
        // intersect rectangles & store resulting rectangle
        Rectangle2D.intersect(r2d, intersect, intersect);
        // check intersection of line w/ rectangle
        contain = r2d.intersectsLine(0.0, 0.0, 0.0, 0.0);
        Line2D l2d = null;
        contain = r2d.intersectsLine(l2d);
        // get position wrt rectangle
        hash = r2d.outcode(0.0, 0.0);
        hash = r2d.outcode(p2d);
        // set location & size of bounds
        r2d.setFrame(0.0, 0.0, 0.0, 0.0);
        // set location & size of rectangle
        r2d.setRect(0.0, 0.0, 0.0, 0.0);
        r2d.setRect(intersect);
        // union 2 rectangles & store resulting shape
        Rectangle2D.union(r2d, intersect, intersect);

        // some inherited methods
    }

    //---------
    // @example
    //---------
    public Rectangle2DTutorial() {
        super("Java AWT Examples");
        prepareGUI();
    }

    public static void main(String[] args) {
        Rectangle2DTutorial rectangle2DTutorial = new Rectangle2DTutorial();
        rectangle2DTutorial.setVisible(true);
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
        Rectangle2D shape = new Rectangle2D.Float();
        shape.setFrame(100, 150, 200, 100);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(shape);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 70);
        g2.drawString("Rectangle2D.Rectangle", 100, 120);
    }
    //---------
}
