package ui;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Used to describe (visual) buttons in the in-game UI/menu.
 * @author Björn Tegelund
 */
public class UIButton {
	private Image image;
	private int x;
	private int y;

	/**
	 * Creates a new UIButton.
	 * @param image The Image of the button.
	 * @param x The buttons X position.
	 * @param y The buttons Y position.
	 */
	public UIButton(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return The buttons Image.
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * @return A rectangle around the buttons Image. Used to check whether a button has been clicked or not.
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	/**
	 * @return The buttons X position.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return The buttons Y position.
	 */
	public int getY() {
		return y;
	}
}
