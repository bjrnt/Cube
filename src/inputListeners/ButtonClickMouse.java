package inputListeners;

import java.util.ArrayList;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import ui.UI;
import ui.UIButton;

/**
 * Used to listen after clicks on MenuItems in the Menu.
 * @author Björn Tegelund
 */
public class ButtonClickMouse implements MouseListener {
	private UI ui;
	private boolean isAccepting;
	private ArrayList<UIButton> buttons;

	/**
	 * Creates a new mouse listener listening for clicks on MenuItems in the Menu.
	 */
	public ButtonClickMouse(UI ui) {
		this.ui = ui;
		isAccepting = true;
	}

	@Override
	public void mouseClicked(int pressed, int x, int y, int clickCount) {
		if(pressed != Input.MOUSE_LEFT_BUTTON)
			return;
		
		this.buttons = ui.getButtons();
		
		for(int i = 0; i < buttons.size(); i++) { //Checks to see which item has been clicked
			if(buttons.get(i).getRect().contains(x, y)) { 
				ui.clicked(buttons.get(i));
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
