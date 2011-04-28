package ui;

import game.GameController;
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
	private GameController gc;
	
	private UIButton play;
	private UIButton logo;
	private UIButton help;
	private UIButton helpText;
	
	private UIButton restart;
	private UIButton levels;
	
	/**
	 * Creates a new UI used to load and use clickable buttons in the menu and in-game UI.
	 * @param input The Input onto which the MouseListener will be added.
	 */
	public UI(Input input, GameController gc) throws SlickException {
		this.input = input;
		this.gc = gc;
		mouseListener = new ButtonClickMouse(this);
	}
	
	/**
	 * Loads the buttons used in the menu.
	 * @throws SlickException If an Image cannot be found/opened.
	 */
	public void loadMenuButtons() throws SlickException {
		buttons = new ArrayList<UIButton>();
		
		logo = new UIButton(new Image("data/logo.jpg"), 240, 25);
		play = new UIButton(new Image("data/play.jpg"), 300, 200);
		help = new UIButton(new Image("data/help.jpg"), 300, 300);
		helpText = new UIButton(new Image("data/helpText.png"), 100, 100);
		
		buttons.add(logo);
		buttons.add(play);
		buttons.add(help);
		
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
			gc.resetLevel();
		}
		else if(mi == levels) {
			// TODO Go to levels screen
		}
		else if(mi == help) {
			buttons.add(helpText);
			buttons.remove(help);
			buttons.remove(play);
		}
		else if(mi == helpText) {
			buttons.remove(helpText);
			buttons.add(help);
			buttons.add(play);
		}
	}
	
	/**
	 * @return A boolean containing a value as to whether the menu is active.
	 */
	public boolean getMenuActive() {
		return menuActive;
	}
}
