package menu;

import inputListeners.MenuClickMouse;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Menu {
	private ArrayList<MenuItem> menuItems;
	private boolean active;
	private Input input;
	private MenuClickMouse mouseListener;
	
	public Menu(Input input) throws SlickException {
		this.input = input;
		menuItems = new ArrayList<MenuItem>();
		MenuItem play = new MenuItem(new Image("data/play.jpg"), 300, 200);
		menuItems.add(play);
		mouseListener = new MenuClickMouse(this);
		
		active = true;
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	public void enableMenuClick() {
		input.addMouseListener(mouseListener);
	}
	
	public void disableMenuClick() {
		input.removeMouseListener(mouseListener);
	}
	
	public void clicked (MenuItem mi) {
		if(mi == menuItems.get(0))
			active = false;
	}
	
	public boolean getActive() {
		return active;
	}
}
