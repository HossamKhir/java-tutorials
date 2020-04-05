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
public class Line2DTutorial extends Frame {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // abstract class cannot be instantiated
    public static Line2D l2d = null;    // new Line2D();
    //--------------
    // @methods
    //---------

    public static void vMethods() {
        // get new object from same class
        Object clone = l2d.clone();
        // check if coordinate is inside boundary of line
        boolean contain = l2d.contains(0.0, 0.0);
        // check if rectangle inside boundary of line
        contain = l2d.contains(0.0, 0.0, 0.0, 0.0);
        Rectangle2D r2d = null;
        contain = l2d.contains(r2d);
        // check if point inside boundary of line
        Point2D p2d = null;
        contain = l2d.contains(p2d);
        // get rectangle enclosing line
        Rectangle rect = l2d.getBounds();
        // get start point
        p2d = l2d.getP1();
        // get end point
        p2d = l2d.getP2();
        // get iterator defining boundary of line
        PathIterator pIterate = l2d.getPathIterator(new AffineTransform());
        // get iterator defining flattened boundary of line
        pIterate = l2d.getPathIterator(new AffineTransform(), 0.0);
        // get x coordinate of start point
        double xcor = l2d.getX1();
        // get x coordinate of end point
        xcor = l2d.getX2();
        // get y coordinate of start point
        xcor = l2d.getY1();
        // get y coordinate of end point
        xcor = l2d.getY2();
        // check if rectangle intersects line
        contain = l2d.intersects(xcor, xcor, xcor, xcor);
        contain = l2d.intersects(r2d);
        // check if line intersects line
        contain = l2d.intersectsLine(xcor, xcor, xcor, xcor);
        contain = l2d.intersectsLine(l2d);
        contain = Line2D.linesIntersect(xcor, xcor, xcor, xcor, xcor, xcor, xcor, xcor);
        // get distance of point from line
        xcor = l2d.ptLineDist(xcor, xcor);
        xcor = Line2D.ptLineDist(xcor, xcor, xcor, xcor, xcor, xcor);
        xcor = l2d.ptLineDist(p2d);
        // get square distance of point from line
        xcor = l2d.ptLineDistSq(xcor, xcor);
        xcor = Line2D.ptLineDistSq(xcor, xcor, xcor, xcor, xcor, xcor);
        xcor = l2d.ptLineDistSq(p2d);
        // get distance of point from segment
        xcor = l2d.ptSegDist(xcor, xcor);
        xcor = Line2D.ptSegDist(xcor, xcor, xcor, xcor, xcor, xcor);
        xcor = l2d.ptSegDist(p2d);
        // get square distance of point from segment
        xcor = l2d.ptSegDistSq(xcor, xcor);
        xcor = Line2D.ptSegDistSq(xcor, xcor, xcor, xcor, xcor, xcor);
        xcor = l2d.ptSegDist(p2d);
        // indicate where point lies wrt line
        int lie = l2d.relativeCCW(xcor, xcor);
        lie = Line2D.relativeCCW(xcor, xcor, xcor, xcor, xcor, xcor);
        lie = l2d.relativeCCW(p2d);
        // set end points of line to coordinates
        l2d.setLine(xcor, xcor, xcor, xcor);
        // set end points of line from line
        l2d.setLine(l2d);
        // set end points of line w/ points
        l2d.setLine(p2d, p2d);

        // some inherited methods
    }

    //---------
    // @example
    //---------
    public Line2DTutorial() {
        super("Java AWT Examples");
        prepareGUI();
    }

    public static void main(String[] args) {
        Line2DTutorial line2DTutorial = new Line2DTutorial();
        line2DTutorial.setVisible(true);
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
        Line2D shape = new Line2D.Double();
        shape.setLine(250D, 250D, 150D, 150D);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(shape);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 70);
        g2.drawString("Line2D.Line", 100, 120);
    }
    //---------
}
