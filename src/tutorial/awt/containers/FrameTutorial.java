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
public class FrameTutorial {
    // @fields
    //--------
    public static float fltField = Frame.BOTTOM_ALIGNMENT;
    public static int[] intFields = {
        Frame.ICONIFIED,        // frame is iconified
        Frame.MAXIMIZED_BOTH,   // max horizontal + vertical
        Frame.MAXIMIZED_HORIZ,  // max horizontal
        Frame.MAXIMIZED_VERT,   // max vertical
        
    };
    //--------
    // @constructors
    //--------------
    // invisible frame w/ border layout
    public static Frame frmInvisible = new Frame();
    // frame w/ graphics configuration
    private final static GraphicsConfiguration gConfig = null;
    public static Frame frmGraphConfig = new Frame(gConfig);
    // invisible frame w/ title & border layout
    public static Frame frmTitle = new Frame("Title");
    // frame w/ graphics configuration & title
    public static Frame frmTitledGraphConfig = new Frame("Graph", gConfig);
    //--------------
    // @methods
    //---------
    public static void vMethod() {
        // make fram displayable
        frmInvisible.addNotify();
        // get accessible context
        AccessibleContext aContext = frmGraphConfig.getAccessibleContext();
        // get state of frame
        int state = frmTitle.getExtendedState();
        System.out.println(state);
        // get list of frames created by application
        Frame[] frames = frmTitledGraphConfig.getFrames();
        // get icon image 
        Image img = frmInvisible.getIconImage();
        // get maximized bounds for frame
        Rectangle rect = frmGraphConfig.getMaximizedBounds();
        // get menu bar of frame
        MenuBar mBar = frmTitle.getMenuBar();
        // get title of frame
        String title = frmTitledGraphConfig.getTitle();
        // check resizability
        boolean resizable = frmInvisible.isResizable();
        // check decoration
        resizable = frmGraphConfig.isUndecorated();
        // remove menu bar from frame
        frmTitle.remove(mBar);
        // make frame undisplayable
        frmTitledGraphConfig.removeNotify();
        // set state for frame 
        frmInvisible.setExtendedState(state);
        // set icon image
        frmGraphConfig.setIconImage(img);
        // set max bounds
        frmTitle.setMaximizedBounds(rect);
        // set menu bar
        frmTitledGraphConfig.setMenuBar(mBar);
        // determine resizability of frame
        frmInvisible.setResizable(resizable);
        // set title for frame
        frmGraphConfig.setTitle(title);
        // control decoration of frame
        frmTitle.setUndecorated(resizable);
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public FrameTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        FrameTutorial frameTutorial = new FrameTutorial();
        frameTutorial.showFrameDemo();
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

    private void showFrameDemo() {
        headerLabel.setText("Container in action: Frame");

        final Frame frame = new Frame();
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.add(msglabel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                frame.dispose();
                statusLabel.setText("A frame is closed");
            }
        });
        Button okButton = new Button("Open a Frame");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("A Frame shown to the user.");
                frame.setVisible(true);
            }
        });
        controlPanel.add(okButton);

        mainFrame.setVisible(true);
    }
    //---------
}
