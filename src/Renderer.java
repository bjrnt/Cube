import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer {
	private JFrame frame;
	private Canvas canvas;
	
	public Renderer() {
		canvas = new Canvas();
		frame = new JFrame("CUBE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void render() {
		canvas.repaint();
	}
}

class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final Color black = new Color(0,0,0);
	private static final Color white = new Color(255,255,255);
	private static final int defaultScreenWidth = 800;
	private static final int defaultScreenHeight = 600;
	
	private double widthScaleFactor;
	private double heightScaleFactor;
	
	public Canvas() {
		super(true);
		setPreferredSize(new Dimension(defaultScreenWidth, defaultScreenHeight));
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		widthScaleFactor = (double)this.getWidth()/defaultScreenWidth;
		heightScaleFactor = (double)this.getHeight()/defaultScreenHeight;
		
		g.setColor(Canvas.white);
		for(int i = 0; i < this.getHeight(); i++) {
			g.drawLine(0, i, this.getWidth(), i);
		}
	}
}