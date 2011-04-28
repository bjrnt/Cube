package ui;

import inputListeners.ButtonClickMouse;
import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * The UI class is used to load and use clickable buttons in the menu and in-game UI.
 * @author Björn Tegelund
 */
public class UI {
	private ArrayList<UIButton> buttons;
	private boolean menuActive;
	private Input input;
	private ButtonClickMouse mouseListener;
	
	private UIButton play;
	
	private UIButton restart;
	private UIButton levels;
	
	/**
	 * Creates a new UI used to load and use clickable buttons in the menu and in-game UI.
	 * @param input The Input onto which the MouseListener will be added.
	 */
	public UI(Input input) throws SlickException {
		this.input = input;
		mouseListener = new ButtonClickMouse(this);
	}
	
	/**
	 * Loads the buttons used in the menu.
	 * @throws SlickException If an Image cannot be found/opened.
	 */
	public void loadMenuButtons() throws SlickException {
		buttons = new ArrayList<UIButton>();
		
		play = new UIButton(new Image("data/play.jpg"), 300, 200);
		
		buttons.add(play);
		
		menuActive = true;
	}
	
	/**
	 * Loads the button used in the in-game UI.
	 * @throws SlickException If an Image cannot be found/opened.
	 */
	public void loadIngameButtons() throws SlickException {
		buttons = new ArrayList<UIButton>();
		
		levels = new UIButton(new Image("data/levels.jpg"), 10, 50);
		restart = new UIButton(new Image("data/restart.jpg"), 100, 50);
		
		buttons.add(levels);
		buttons.add(restart);
	}
	
	/**
	 * Gets all the active buttons currently in the UI.
	 * @return All the active buttons currently in the UI.
	 */
	public ArrayList<UIButton> getButtons() {
		return buttons;
	}
	
	/**
	 * Enables the user to press buttons within the UI.
	 */
	public void enableClick() {
		input.addMouseListener(mouseListener);
	}
	
	/**
	 * Disables the user to press buttons within the UI.
	 */
	public void disableClick() {
		input.removeMouseListener(mouseListener);
	}
	
	/**
	 * Called when a button is clicked.
	 * @param mi The clicked button.
	 */
	public void clicked (UIButton mi) {
		if(mi == play)
			menuActive = false;
		else if(mi == restart) {
			// TODO Restart current level
		}
		else if(mi == levels) {
			// TODO Go to levels screenS
		}
	}
	
	/**
	 * @return A boolean containing a value as to whether the menu is active.
	 */
	public boolean getMenuActive() {
		return menuActive;
	}
}
