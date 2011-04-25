package inputListeners;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public abstract class AbstractKeyboardListener implements KeyListener{
	private boolean isAccepting;
	private int keyCode;
	
	public AbstractKeyboardListener(int keyCode) {
		this.keyCode = keyCode;
		isAccepting = true;
	}
	
	@Override
	public void keyPressed(int keyI, char keyC) {
		if(keyI != keyCode)
			return;
		
		pressed();
	}
	
	@Override
	public void keyReleased(int keyI, char keyC) {
		if(keyI != keyCode)
			return;
		
		released();
	}
	
	public abstract void pressed();
	public abstract void released();
	
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
}
