/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.menuclasses;

import java.awt.*;
import java.awt.event.*;
import javax.accessibility.AccessibleContext;

/**
 *
 * @author Hossam
 */
public class PopupMenuTutorial {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // popup menu w/ empty name
    public static PopupMenu pmEmpty = new PopupMenu();
    // popup menu w/ name
    public static PopupMenu pmName = new PopupMenu("Name");

    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // create peer for popup menu
        pmEmpty.addNotify();
        // get accessible context 
        AccessibleContext aContext = pmName.getAccessibleContext();
        // get parent container
        MenuContainer mContainer = pmEmpty.getParent();
        // show popup menu at position (x, y) relative to component
        pmName.show(new Checkbox(), 0, 1);

        // some inherited methods
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public PopupMenuTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        PopupMenuTutorial popupMenuTutorial = new PopupMenuTutorial();
        popupMenuTutorial.showPopupMenuDemo();
    }

    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showPopupMenuDemo() {
        final PopupMenu editMenu = new PopupMenu("Edit");

        MenuItem cutMenuItem = new MenuItem("Cut");
        cutMenuItem.setActionCommand("Cut");

        MenuItem copyMenuItem = new MenuItem("Copy");
        copyMenuItem.setActionCommand("Copy");

        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setActionCommand("Paste");

        MenuItemListener menuItemListener = new MenuItemListener();

        cutMenuItem.addActionListener(menuItemListener);
        copyMenuItem.addActionListener(menuItemListener);
        pasteMenuItem.addActionListener(menuItemListener);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        controlPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editMenu.show(controlPanel, e.getX(), e.getY());
            }
        });
        controlPanel.add(editMenu);

        mainFrame.setVisible(true);
    }

    class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusLabel.setText(e.getActionCommand()
                    + " MenuItem clicked.");
        }
    }
    //---------
}
