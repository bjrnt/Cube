package inputListeners;

import java.util.ArrayList;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import menu.Menu;
import menu.MenuItem;

/**
 * Used to listen after clicks on MenuItems in the Menu.
 * @author Björn Tegelund
 */
public class MenuClickMouse implements MouseListener {
	private Menu menu;
	private boolean isAccepting;
	private ArrayList<MenuItem> menuItems;

	/**
	 * Creates a new mouse listener listening for clicks on MenuItems in the Menu.
	 */
	public MenuClickMouse(Menu menu) {
		this.menu = menu;
		this.menuItems = menu.getMenuItems();
		isAccepting = true;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if(button != Input.MOUSE_LEFT_BUTTON)
			return;
		
		for(int i = 0; i < menuItems.size(); i++) { //Checks to see which item has been clicked
			if(menuItems.get(i).getRect().contains(x, y)) { 
				menu.clicked(menuItems.get(i));
				return;
			}
		}
	}
	
	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public boolean isAcceptingInput() {
		return isAccepting;
	}

	@Override
	public void setInput(Input arg0) {
	}

	

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
	}

	@Override
	public void mouseWheelMoved(int arg0) {
	}
}
