/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.containers;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.beans.*;
import java.io.*;
import java.text.AttributedCharacterIterator;
import java.util.*;

/**
 *
 * @author Hossam
 */
public class ContainerTutorial {
    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // new container
    public static Container cont = new Container();
    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // append component to end of container
        cont.add(new Label("Label"));
        // add component @ specified position
        cont.add(new Button("Button"), 0);
        // add component w/ constraints
        cont.add(new Scrollbar(), new GridLayout(1, 2));
        // add component w/ constraints @ position
        cont.add(new Canvas(), new FlowLayout(), 4);
        // add container listener
        cont.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // make container displayable 
        cont.addNotify();
        // add property change listener
        cont.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // add property change listener to specific property
        cont.addPropertyChangeListener("Listen Up", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // set component orientation
        cont.applyComponentOrientation(ComponentOrientation.UNKNOWN);
        // check definition of set of focus of traversal keys 
        boolean focus = cont.areFocusTraversalKeysSet(8);
        // layout components of this container
        cont.doLayout();
        // find component @ coordinates
        Component comp = cont.findComponentAt(16, 32);
        // find component @ point
        comp = cont.findComponentAt(new Point(64, 128));
        // get x alignment
        float align = cont.getAlignmentX();
        System.out.println(align);
        // get y alignment
        align = cont.getAlignmentY();
        // get component @ index
        comp = cont.getComponent(256);
        // get component @ coordinates
        comp = cont.getComponentAt(64, 128);
        // get component @ point
        comp = cont.getComponentAt(new Point(16, 32));
        // get # components
        int num = cont.getComponentCount();
        System.out.println(num);
        // get array of components
        Component[] comps = cont.getComponents();
        // get index of component
        num = cont.getComponentZOrder(comp);
        // get array of container listeners
        ContainerListener[] cListeners = cont.getContainerListeners();
        // get set of focus traversal keys
        Set<AWTKeyStroke> setAWT = cont.getFocusTraversalKeys(num);
        // get focus traversal policy 
        FocusTraversalPolicy ftPolicy = cont.getFocusTraversalPolicy();
        // get insets of container
        Insets insets = cont.getInsets();
        // get layout manager of container
        LayoutManager lManager = cont.getLayout();
        // get list of all listeners
        cont.getListeners(null);
        // get max size
        Dimension size = cont.getMaximumSize();
        // get min size
        size = cont.getMinimumSize();
        // get mouse position
        Point position = cont.getMousePosition();
        // get preferred size
        size = cont.getPreferredSize();
        // invalidate container
        cont.invalidate();
        // check ancesity
        focus = cont.isAncestorOf(new Button("Button"));
        // check root of focus cycle
        focus = cont.isFocusCycleRoot();
        focus = cont.isFocusCycleRoot(new Frame());
        // check provider for focus traversal policy
        focus = cont.isFocusTraversalPolicyProvider();
        // check setting of focus traversal policy
        focus = cont.isFocusTraversalPolicySet();
        // print listing of container to o/p stream
        cont.list(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }
        }), 0);
        // print list of container to print writer
        cont.list(new PrintWriter(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }
        }), 0);
        // paint the container
        Graphics gDummy = null;
        cont.paint(gDummy);
        // paint all components
        cont.paintComponents(gDummy);
        // print the container
        cont.print(gDummy);
        // print all components
        cont.printComponents(gDummy);
        // remove component from container
        cont.remove(new Label("Lable"));
        // remove component by index
        cont.remove(64);
        // remove all components
        cont.removeAll();
        // reomve container listener
        cont.removeContainerListener(null);
        // make container undisplayable
        cont.removeNotify();
        // move component to certain order 
        cont.setComponentZOrder(new Scrollbar(), 1024);
        // set focus cycle root
        cont.setFocusCycleRoot(focus);
        // set focus traversal keys
        cont.setFocusTraversalKeys(num, setAWT);
        // set focus traversal policy
        cont.setFocusTraversalPolicy(ftPolicy);
        // set focus traversal policy provider
        cont.setFocusTraversalPolicyProvider(focus);
        // set font of container
        cont.setFont(new Font("Name", num, num));
        // set layout for container
        cont.setLayout(lManager);
        // transfer focus to previous component
        cont.transferFocusBackward();
        // transfer focus down one traversal cycle
        cont.transferFocusDownCycle();
        // update the container
        cont.update(gDummy);
        // validate container & its components
        cont.validate();
        
        // some protected & inherited methods
    }
    //---------
}
