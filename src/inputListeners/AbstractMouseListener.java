package inputListeners;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

public abstract class AbstractMouseListener implements MouseListener {
	private boolean isAccepting;
	private int keyCode;
	
	protected AbstractMouseListener(int keyCode) {
		this.keyCode = keyCode;
		isAccepting = true;
	}
	
	@Override
	public void mouseClicked(int pressed, int x, int y, int clickCount) {
		if(pressed != keyCode)
			return;
		
		clicked(x, y);
	}
	
	public abstract void clicked(int x, int y);
	
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
