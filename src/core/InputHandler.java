package core;
import game.GameController;
import inputListeners.*;
import inputListeners.CubeRotationKeyboard.Rotation;

import java.util.ArrayList;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import cube.CubeController;
import cube.Direction;

/**
 * Used to get and change things using input from a keyboard.
 * @author Björn Tegelund
 */
public class InputHandler {
	private Input input;
	private CubeController cc;
	private GameController gc;
	
	ArrayList<KeyListener> activeKeyListeners;
	private boolean primaryKeySet;
	
	/**
	 * Creates a new InputHandler.
	 * 
	 * @param input The Input the listeners should be added to.
	 * @param cc The CubeController used to control input directed towards the Cube.
	 */
	public InputHandler(Input input, CubeController cc, GameController gc) {
		this.cc = cc;
		this.gc = gc;
		this.input = input;
		activeKeyListeners = new ArrayList<KeyListener>();
		keySetPrimary();
		enableKeySetSwitching();
	}
	
	/**
	 * Makes it possible to switch between keysets.
	 * TODO Enable this only after the game has begun (when there is a menu).
	 */
	private void enableKeySetSwitching() {
		input.addKeyListener(new SwapKeysKeyboard(cc, Input.KEY_K, this));
	}
	
	/**
	 * Activates the primary key set.
	 */
	public void keySetPrimary() {
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_S, Rotation.Y, true, false));
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_W, Rotation.Y, false, false));
		
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_A, Rotation.Z, false, false));
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_D, Rotation.Z, true, false));
		
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_UP, Direction.UP));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_DOWN, Direction.DOWN));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_LEFT, Direction.LEFT));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_RIGHT, Direction.RIGHT));
		
		activateListeners();
		primaryKeySet = true;
	}
		
	/**
	 * Activates the secondary key set.
	 */
	public void keySetSecondary() {
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_S, Rotation.Y, true, true));
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_W, Rotation.Y, false, true));
		
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_A, Rotation.Z, false, true));
		activeKeyListeners.add(new CubeRotationKeyboard(cc, Input.KEY_D, Rotation.Z, true, true));
		
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_UP, Direction.UP));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_DOWN, Direction.DOWN));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_LEFT, Direction.LEFT));
		activeKeyListeners.add(new SquareChangeKeyboard(gc, Input.KEY_RIGHT, Direction.RIGHT));
		
		activateListeners();
		primaryKeySet = false;
	}
	
	/**
	 * Swap key sets.
	 */
	public void swapKeySet() {
		deactivateListeners();
		if(primaryKeySet)
			keySetSecondary();
		else
			keySetPrimary();
	}
	
	/**
	 * Activates all the listeners in the activeKeyListeners ArrayList.
	 */
	private void activateListeners() {
		for(int i = 0; i < activeKeyListeners.size(); i++) {
			input.addKeyListener(activeKeyListeners.get(i));
		}
	}
	
	/**
	 * Deactivates all the listeners in the activeKeyListeners ArrayList.
	 */
	private void deactivateListeners() {
		for(int i = 0; i < activeKeyListeners.size(); i++) {
			input.removeKeyListener(activeKeyListeners.get(i));
		}
		activeKeyListeners = new ArrayList<KeyListener>();
	}
	
	/**
	 * Used to determine whether the arrows should be rendered or not.
	 */
	public boolean usingPrimaryKeySet() {
		return primaryKeySet;
	}
}
