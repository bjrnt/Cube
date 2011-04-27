package inputListeners;

import game.GameController;

public class StartTrailKeyboard extends AbstractKeyboardListener{
	private GameController gc;
	
	public StartTrailKeyboard(GameController gc, int keyCode) {
		super(keyCode);
		this.gc = gc;
	}

	@Override
	public void pressed() {
		gc.startTrail();
	}

	@Override
	public void released() {
	}

}
