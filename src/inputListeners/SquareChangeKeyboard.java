package inputListeners;

import game.GameController;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import cube.Direction;

public class SquareChangeKeyboard implements KeyListener {
	private boolean isAccepting;
	private int keyCode;
	private Direction dir;
	private GameController gc;
	
	public SquareChangeKeyboard(GameController gc, int keyCode, Direction d) {
		this.keyCode = keyCode;
		this.gc = gc;
		dir = d;
		isAccepting = true;
	}
	
	@Override
	public void keyPressed(int keyI, char keyC) {
		if(keyI != keyCode)
			return;
		
		gc.directionKeyPressed(dir);
	}

	@Override
	public void keyReleased(int keyI, char keyC) {
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
}
