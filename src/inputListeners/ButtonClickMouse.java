package inputListeners;

import java.util.ArrayList;
import org.newdawn.slick.Input;
import ui.UI;
import ui.UIButton;

/**
 * Used to listen after clicks on buttons in the UI.
 * @author Björn Tegelund
 */
public class ButtonClickMouse extends AbstractMouseListener {
	private UI ui;
	private ArrayList<UIButton> buttons;

	/**
	 * Creates a new mouse listener listening for clicks on buttons in the UI.
	 */
	public ButtonClickMouse(UI ui) {
		super(Input.MOUSE_LEFT_BUTTON);
		this.ui = ui;
	}

	@Override
	public void clicked(int x, int y) {
		this.buttons = ui.getButtons();
		
		for(int i = 0; i < buttons.size(); i++) { //Checks to see which item has been clicked
			if(buttons.get(i).getRect().contains(x, y)) { 
				ui.clicked(buttons.get(i));
				return;
			}
		}
	}
	
	
}
