/**
 * 
 */
package tutorial.awt.components;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.text.AttributedCharacterIterator;

import javax.accessibility.AccessibleContext;

/**
 * @author hossam
 *
 */
public class CanvasTutorial {
	// @fields
	//--------
	//--------
	// @constructors
	//--------------
	// new canvas
	public static Canvas cnvNew = new Canvas();
	// canvas w/ graphics configuration
	public static Canvas cnvGraphConfig = new Canvas(new GraphicsConfiguration() {

		@Override
		public AffineTransform getNormalizingTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GraphicsDevice getDevice() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AffineTransform getDefaultTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ColorModel getColorModel(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ColorModel getColorModel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Rectangle getBounds() {
			// TODO Auto-generated method stub
			return null;
		}
	});
	//--------------
	// @methods
	//---------
	public static void vMethods() throws AWTException {
		// create peer for canvas
		cnvNew.addNotify();
		// create strategy for multi-buffering
		cnvGraphConfig.createBufferStrategy(8);
		// create strategy for multi-buffering w/ certain capabilities
		// either surround this with try/catch or apply throws statement to the method that contains it
		cnvNew.createBufferStrategy(8, new BufferCapabilities(null, null, null));
		// get accessible context
		AccessibleContext acCanvas = cnvNew.getAccessibleContext();
		// get buffer strategy 
		BufferStrategy bsCanvas = cnvNew.getBufferStrategy();
		// paint the canvas
		cnvNew.paint(new Graphics() {

			@Override
			public void translate(int arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setXORMode(Color arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub

			}

			@Override
			public void setFont(Font arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setColor(Color arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setClip(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setClip(Shape arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public FontMetrics getFontMetrics(Font arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void fillRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillRect(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillPolygon(int[] arg0, int[] arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillOval(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawString(String arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawPolyline(int[] arg0, int[] arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawPolygon(int[] arg0, int[] arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawOval(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawLine(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
					Color arg9, ImageObserver arg10) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
					ImageObserver arg9) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, Color arg5, ImageObserver arg6) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, ImageObserver arg5) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void copyArea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void clipRect(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void clearRect(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}
		});
		// update the canvas
		cnvNew.update(new Graphics() {

			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub

			}

			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub

			}

			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}

			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}

			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub

			}

			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}

			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub

			}
		});

		// some inherited methods
	}
	//---------
	// @example
	//---------
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public CanvasTutorial(){
		prepareGUI();
	}

	public static void main(String[] args){
		CanvasTutorial  canvasTutorial = new CanvasTutorial();
		canvasTutorial.showCanvasDemo();
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

	private void showCanvasDemo(){
		headerLabel.setText("Control in action: Canvas"); 

		controlPanel.add(new MyCanvas());
		mainFrame.setVisible(true);  
	} 

	class MyCanvas extends Canvas {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8112318704223823781L;

		public MyCanvas () {
			setBackground (Color.GRAY);
			setSize(300, 300);
		}

		public void paint (Graphics g) {
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.drawString ("It is a custom canvas area", 70, 70);
		}
	}
	//---------
}
