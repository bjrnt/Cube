package inputListeners;

import core.InputHandler;
import cube.CubeController;

/**
 * Used to listen for keyboard input, and then swaps the key set used in the InputHandler.
 * @author Björn Tegelund
 */
public class SwapKeysKeyboard extends AbstractKeyboardListener {
	@SuppressWarnings("unused")
	private CubeController cc;
	private InputHandler ih;
	
	/**
	 * Creates a new SwapKeysKeyboard keyboard listener, which listens to keyboard input and then swaps the key set used in the InputHandler.
	 * @param cc The CubeController used to make sure the Cube is at a right angle before swapping to another key set.
	 * @param keyCode The code of the key that should activate this listener.
	 * @param ih The InputHandler which key set will be swapped.
	 */
	public SwapKeysKeyboard(CubeController cc, int keyCode, InputHandler ih) {
		super(keyCode);
		this.cc = cc;
		this.ih = ih;
	}

	@Override
	public void pressed() {
		ih.swapKeySet();
		// TODO Use CubeController to make sure the Cube is at a right angle before swapping key sets.
	}

	@Override
	public void released() {
		// TODO Auto-generated method stub
		
	}

}
