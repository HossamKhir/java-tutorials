/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.containers;

import java.awt.*;
import java.awt.event.*;
import javax.accessibility.*;

/**
 *
 * @author Hossam
 */
public class PanelTutorial {
    // @fields
    //--------
    //---------
    // @constructors
    //--------------
    // new panel w/ default flow layout
    public static Panel pnlDefault = new Panel();
    // new panel w/ specific layout
    public static Panel pnlLayout = new Panel(new GridBagLayout());
    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // create panel peer
        pnlDefault.addNotify();
        // get accessible context
        AccessibleContext aContext = pnlLayout.getAccessibleContext();
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public PanelTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        PanelTutorial panelTutorial = new PanelTutorial();
        panelTutorial.showPanelDemo();
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

        msglabel = new Label();
        msglabel.setAlignment(Label.CENTER);
        msglabel.setText("Welcome to TutorialsPoint AWT Tutorial.");

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showPanelDemo() {
        headerLabel.setText("Container in action: Panel");

        Panel panel = new Panel();
        panel.setBackground(Color.magenta);
        panel.setLayout(new FlowLayout());
        panel.add(msglabel);

        controlPanel.add(panel);

        mainFrame.setVisible(true);
    }
    //---------
}
