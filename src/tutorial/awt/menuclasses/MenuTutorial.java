/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.menuclasses;

import java.awt.*;
import java.awt.event.*;
import javax.accessibility.*;

/**
 *
 * @author Hossam
 */
public class MenuTutorial {

    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // menu w/ empty label
    public static Menu mNew = new Menu();
    // menu w/ label
    public static Menu mLabel = new Menu("Lable");
    // menu w/ label & tear off state
    public static Menu mTear = new Menu("Tear", true);

    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // add menu item
        MenuItem mItem = mNew.add(new MenuItem());
        // add item w/ label
        mLabel.add("Label");
        // create menu peer
        mTear.addNotify();
        // add separator line or hyphen
        mNew.addSeparator();
        // get accessible context
        AccessibleContext aContext = mLabel.getAccessibleContext();
        // get item @ index
        mItem = mTear.getItem(0);
        // get # items
        int num = mNew.getItemCount();
        // insert menu item @ index
        mLabel.insert(mItem, num);
        // insert item w/ label @ index
        mTear.insert("Item", num);
        // insert separator @ index
        mNew.insertSeparator(num);
        // check tear off property of menu
        boolean tearoff = mLabel.isTearOff();
        // remove menu item @ index
        mTear.remove(num);
        // remove menu item
        mNew.remove(mItem);
        // remove all items from menu
        mLabel.removeAll();
        // remove menu peer
        mTear.removeNotify();

        // some protected & inherited methods
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public MenuTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        MenuTutorial menuTutorial = new MenuTutorial();
        menuTutorial.showMenuDemo();
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

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setActionCommand("Open");

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setActionCommand("Save");

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");

        MenuItem cutMenuItem = new MenuItem("Cut");
        cutMenuItem.setActionCommand("Cut");

        MenuItem copyMenuItem = new MenuItem("Copy");
        copyMenuItem.setActionCommand("Copy");

        MenuItem pasteMenuItem = new MenuItem("Paste");
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
