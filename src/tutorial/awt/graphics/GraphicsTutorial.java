/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author Hossam
 */
public class GraphicsTutorial extends Frame {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // new graphics object
    public static Graphics graphics = null; // new Graphics() { // TODO implement all abstract classes}
    //--------------
    // @methods
    //---------

    public static void vMethods() {
        // clear rectangle by filling it w/ background colour of drawing surface
        graphics.clearRect(0, 1, 2, 4);
        // intersect clip with rectangle
        graphics.clipRect(8, 16, 32, 64);
        // copy area of component by distance
        graphics.copyArea(128, 256, 512, 1024, 2048, 4096);
        // create copy of current graphics
        Graphics copy = graphics.create();
        // create copy of current graphics w/ new translation & clipping area
        copy = graphics.create(8192, 4096, 2048, 1024);
        // dispose of graphics context & release system resources
        graphics.dispose();
        // draw 3D highlighted outline
        graphics.draw3DRect(512, 256, 128, 64, true);
        // draw outline of arc to cover a rectangle
        graphics.drawArc(32, 16, 8, 4, 2, 1);
        // draw text by bytes
        graphics.drawBytes(new byte[0], 1, 2, 4, 8);
        // draw text by chars
        graphics.drawChars(new char[16], 32, 64, 128, 256);
        // draw image
        ImageObserver iObserve = null;
        Image image = null;
        boolean img = graphics.drawImage(image, 512, 1024, Color.RED, iObserve);
        img = graphics.drawImage(image, 512, 1024, iObserve);
        // draw image w/ scale
        img = graphics.drawImage(image, 2048, 4096, 8192, 4096, Color.BLUE, iObserve);
        img = graphics.drawImage(image, 2048, 1024, 512, 256, iObserve);
        // draw image w/ scale on the fly
        img = graphics.drawImage(image, 128, 64, 32, 16, 8, 4, 2, 1, Color.CYAN, iObserve);
        img = graphics.drawImage(image, 2, 4, 8, 16, 32, 64, 128, 256, iObserve);
        // draw line
        graphics.drawLine(512, 1024, 2048, 4096);
        // draw outline of oval
        graphics.drawOval(8192, 4096, 2048, 1024);
        // draw a polygon
        graphics.drawPolygon(new int[512], new int[256], 128);
        graphics.drawPolygon(new Polygon());
        // draw polyline
        graphics.drawPolyline(new int[64], new int[32], 16);
        // draw outline of rectangle
        graphics.drawRect(8, 4, 2, 1);
        // draw rectangle w/ round corners
        graphics.drawRoundRect(2, 4, 8, 16, 32, 64);
        // draw string 
        AttributedCharacterIterator acIterator = null;
        graphics.drawString(acIterator, 128, 256);
        // draw 3D colour filled rectangle 
        graphics.fill3DRect(512, 1024, 2048, 4096, img);
        // fill arc 
        graphics.fillArc(8192, 4096, 2048, 1024, 512, 256);
        // fill oval
        graphics.fillOval(128, 64, 32, 16);
        // fill polygon
        graphics.fillPolygon(new int[8], new int[4], 2);
        graphics.fillPolygon(new Polygon());
        // fill rectangle
        graphics.fillRect(1, 2, 4, 8);
        // fill rounded corner rectangle
        graphics.fillRoundRect(16, 32, 64, 128, 256, 512);
        // dispose of graphics context when it is no longer referenced
        graphics.finalize();
        // get current clip area
        Shape clip = graphics.getClip();
        // get bounding rectangle of clipping area
        Rectangle bounds = graphics.getClipBounds();
        bounds = graphics.getClipBounds(bounds);
        // get current colour
        Color colour = graphics.getColor();
        // get current font
        Font font = graphics.getFont();
        // get font metrics
        FontMetrics fMetrics = graphics.getFontMetrics();
        // get font metrics of font
        fMetrics = graphics.getFontMetrics(font);
        // check if certain area might intersect clipping area
        img = graphics.hitClip(1024, 2048, 4096, 8192);
        // set current clip 
        graphics.setClip(4096, 2048, 1024, 512);
        graphics.setClip(clip);
        // set colour
        graphics.setColor(colour);
        // set font
        graphics.setFont(font);
        // instruct graphic context to overwrite destination w/ colour
        graphics.setPaintMode();
        // set graphics context to alternate colours
        graphics.setXORMode(colour);
        // get graphics object as string
        System.out.println(graphics.toString());
        // translate origin of graphics to new point
        graphics.translate(256, 128);
    }

    //---------
    // @example
    //---------
    public GraphicsTutorial() {
        super("Java AWT Examples");
        prepareGUI();
    }

    public static void main(String[] args) {
        GraphicsTutorial graphicsTutorial = new GraphicsTutorial();
        graphicsTutorial.setVisible(true);
    }

    private void prepareGUI() {
        setSize(400, 400);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 150);
    }
    //---------

}
