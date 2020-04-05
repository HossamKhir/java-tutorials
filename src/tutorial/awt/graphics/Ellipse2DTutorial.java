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
public class Ellipse2DTutorial extends Frame {
    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // abstract class cannot instantiate
    public static Ellipse2D e2d = null; // new Ellipse2D
    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // check if coordinates inside a shape
        boolean contain = e2d.contains(0.0, 0.0);
        // check if rectangle contained inside shape
        contain = e2d.contains(0.0, 0.0, 0.0, 0.0);
        // check if an object equals this ellipse
        contain = e2d.equals(new Object());
        // get iterator defining boundary of ellipse
        PathIterator pIterate = e2d.getPathIterator(new AffineTransform());
        // get hashcode of ellipse
        int hash = e2d.hashCode();
        // check if intersection happened between ellipse & rectangle
        contain = e2d.intersects(0.0, 0.0, 0.0, 0.0);
        
        // some inherited methods
    }
    //---------
    // @example
    //---------
    public Ellipse2DTutorial(){
      super("Java AWT Examples");
      prepareGUI();
   }

   public static void main(String[] args){
      Ellipse2DTutorial  ellipse2DTutorial = new Ellipse2DTutorial();  
      ellipse2DTutorial.setVisible(true);
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
      Ellipse2D shape = new Ellipse2D.Float();
      shape.setFrame(100, 150, 200,100);
      Graphics2D g2 = (Graphics2D) g; 
      g2.draw (shape);
      Font font = new Font("Serif", Font.PLAIN, 24);
      g2.setFont(font);
      g.drawString("Welcome to TutorialsPoint", 50, 70);
      g2.drawString("Ellipse2D.Oval", 100, 120); 
   }
    //---------
}
