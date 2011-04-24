package menu;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class MenuItem {
	private Image image;
	private int x;
	private int y;
	
	public MenuItem(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
