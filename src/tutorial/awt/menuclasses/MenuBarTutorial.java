/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.menuclasses;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.accessibility.*;

/**
 *
 * @author Hossam
 */
public class MenuBarTutorial {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // new menu bar 
    public static MenuBar mbNew = new MenuBar();

    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // dispatch event
        AWTEvent awtEvent = null;
        mbNew.dispatchEvent(awtEvent);
        // add menu to menu bar
        Menu added = mbNew.add(new Menu());
        // create peer for menu bar
        mbNew.addNotify();
        // delete shortcut
        mbNew.deleteShortcut(null);
        // get accessible context
        AccessibleContext aContext = mbNew.getAccessibleContext();
        // get help menu of menu bar
        added = mbNew.getHelpMenu();
        // get menu by index
        added = mbNew.getMenu(0);
        // get # menus on menu bar
        int num = mbNew.getMenuCount();
        // get menu item by menu shortcut
        MenuItem mItem = mbNew.getShortcutMenuItem(new MenuShortcut(1));
        // remove menu by index
        mbNew.remove(num);
        // remove specific menu component
        mbNew.remove(mItem);
        // remove peer of menu bar
        mbNew.removeNotify();
        // set help menu for menu bar
        mbNew.setHelpMenu(added);
        // get enum of all menu shortcuts
        Enumeration e = mbNew.shortcuts();

        // some inherited methods
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public MenuBarTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        MenuBarTutorial menuBarTutorial = new MenuBarTutorial();
        menuBarTutorial.showMenuDemo();
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

    private void showMenuDemo() {
        //create a menu bar
        final MenuBar menuBar = new MenuBar();

        //create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        final Menu aboutMenu = new Menu("About");

        //create menu items
        MenuItem newMenuItem
                = new MenuItem("New", new MenuShortcut(KeyEvent.VK_N));
        newMenuItem.setActionCommand("New");

        MenuItem openMenuItem = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
        openMenuItem.setActionCommand("Open");

        MenuItem saveMenuItem = new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
        saveMenuItem.setActionCommand("Save");

        MenuItem exitMenuItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_Q));
        exitMenuItem.setActionCommand("Exit");

        MenuItem cutMenuItem = new MenuItem("Cut", new MenuShortcut(KeyEvent.VK_X));
        cutMenuItem.setActionCommand("Cut");

        MenuItem copyMenuItem = new MenuItem("Copy", new MenuShortcut(KeyEvent.VK_C));
        copyMenuItem.setActionCommand("Copy");

        MenuItem pasteMenuItem = new MenuItem("Paste", new MenuShortcut(KeyEvent.VK_V));
        pasteMenuItem.setActionCommand("Paste");

        MenuItemListener menuItemListener = new MenuItemListener();

        newMenuItem.addActionListener(menuItemListener);
        openMenuItem.addActionListener(menuItemListener);
        saveMenuItem.addActionListener(menuItemListener);
        exitMenuItem.addActionListener(menuItemListener);
        cutMenuItem.addActionListener(menuItemListener);
        copyMenuItem.addActionListener(menuItemListener);
        pasteMenuItem.addActionListener(menuItemListener);

        final CheckboxMenuItem showWindowMenu
                = new CheckboxMenuItem("Show About", true);
        showWindowMenu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (showWindowMenu.getState()) {
                    menuBar.add(aboutMenu);
                } else {
                    menuBar.remove(aboutMenu);
                }
            }
        });

        //add menu items to menus
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(showWindowMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        //add menu to menubar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //add menubar to the frame
        mainFrame.setMenuBar(menuBar);
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
