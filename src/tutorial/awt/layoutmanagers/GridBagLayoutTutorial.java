/**
 *
 */
package tutorial.awt.layoutmanagers;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author hossam
 *
 */
public class GridBagLayoutTutorial {
    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // new grid bag layout
    public static GridBagLayout gblNew = new GridBagLayout();
    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // add component to layout w/ constraints
        gblNew.addLayoutComponent(new Button(), new GridBagLayout());
        // add component to layout w/ string
        gblNew.addLayoutComponent("Lable", new Label("label"));
        // get constraints on component within layout
        GridBagConstraints gbConstraints = gblNew.getConstraints(new Button("Button"));
        // get x alignment
        float align = gblNew.getLayoutAlignmentX(new Frame());
        // get y alignment
        align = gblNew.getLayoutAlignmentY(new Frame());
        // get column width & row height
        int[][] dimensions = gblNew.getLayoutDimensions();
        // get origin of layout area
        Point point = gblNew.getLayoutOrigin();
        // get weights of columns & rows
        double[][] weights = gblNew.getLayoutWeights();
        // invalidate layout
        gblNew.invalidateLayout(new Frame());
        // layout a container w/ this layout
        gblNew.layoutContainer(new Frame());
        // get cell corresponding to a point
        point = gblNew.location(1, 2);
        // get max size
        Dimension size = gblNew.maximumLayoutSize(new Frame());
        // get min size
        size = gblNew.minimumLayoutSize(new Frame());
        // get preferred size
        size = gblNew.preferredLayoutSize(new Frame());
        // remove component from layout
        gblNew.removeLayoutComponent(null);
        // set constraints for component within layout
        gblNew.setConstraints(new Button("Button"), gbConstraints);
        // get layout as string
        System.out.println(gblNew.toString());
        
        // some protected & inherited methods
    }
    //---------
    // @example
    //---------
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Label msglabel;

    public GridBagLayoutTutorial() {
        prepareGUI();
    }

    public static void main(String[] args) {
        GridBagLayoutTutorial gridBagLayoutTutorial = new GridBagLayoutTutorial();
        gridBagLayoutTutorial.showGridBagLayoutDemo();
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

    private void showGridBagLayoutDemo() {
        headerLabel.setText("Layout in action: GridBagLayout");

        Panel panel = new Panel();
        panel.setBackground(Color.darkGray);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new Button("Button 1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new Button("Button 2"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new Button("Button 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new Button("Button 4"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new Button("Button 5"), gbc);

        controlPanel.add(panel);

        mainFrame.setVisible(true);
    }
    //---------
}
