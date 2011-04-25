package inputListeners;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import core.InputHandler;
import cube.CubeController;

/**
 * Used to listen for keyboard input, and then swaps the key set used in the InputHandler.
 * @author Björn Tegelund
 */
public class SwapKeysKeyboard implements KeyListener {
	private int keyCode;
	private boolean isAcceptingInput;
	private InputHandler ih;
	private CubeController cc;
	
	/**
	 * Creates a new SwapKeysKeyboard keyboard listener, which listens to keyboard input and then swaps the key set used in the InputHandler.
	 * @param cc The CubeController used to make sure the Cube is at a right angle before swapping to another key set.
	 * @param keyCode The code of the key that should activate this listener.
	 * @param ih The InputHandler which key set will be swapped.
	 */
	public SwapKeysKeyboard(CubeController cc, int keyCode, InputHandler ih) {
		this.keyCode = keyCode;
		this.ih = ih;
		this.cc = cc;
		
		isAcceptingInput = true;
	}
	
	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public boolean isAcceptingInput() {
		return isAcceptingInput;
	}

	@Override
	public void setInput(Input arg0) {
	}

	@Override
	public void keyPressed(int keyI, char keyC) {
		if(keyI == keyCode) {
			ih.swapKeySet(); 
		}
		// TODO Make sure the cube is at a right angle before swapping keysets.
	}

	@Override
	public void keyReleased(int keyI, char keyC) {
	}

}
