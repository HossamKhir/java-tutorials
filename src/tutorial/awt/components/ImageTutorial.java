/**
 * 
 */
package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author hossam
 *
 */
public class ImageTutorial {
	// @fields
	//--------
	public static int[] fields = {
			Image.SCALE_AREA_AVERAGING,
			Image.SCALE_DEFAULT,
			Image.SCALE_FAST,
			Image.SCALE_REPLICATE,
			Image.SCALE_SMOOTH,
	};
	public static Object objField = Image.UndefinedProperty;
	//--------
	// @constructors
	//--------------
	//--------------
	// @methods
	//---------
	public static void vMethods() {

	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public ImageTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		ImageTutorial  imageTutorial = new ImageTutorial();
		imageTutorial.showImageDemo();
	}

	private void prepareGUI(){
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();        
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);  
	}

	private void showImageDemo(){
		headerLabel.setText("Control in action: Image"); 
		
		controlPanel.add(new ImageComponent("resources/java.jpg"));
		
		mainFrame.setVisible(true);  
	}

	class ImageComponent extends Component {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6843507336534694397L;
		BufferedImage img;

		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

		public ImageComponent(String path) {
			try {
				img = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(100,100);
			} else {
				return new Dimension(img.getWidth(), img.getHeight());
			}
		}
	}
	//---------
}
