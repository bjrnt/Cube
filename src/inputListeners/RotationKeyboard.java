package inputListeners;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import cube.CubeController;

/**
 * This class is used to send commands to rotate the Cube to the Cube controller using keyboard input.
 * @author Björn Tegelund
 */
public class RotationKeyboard implements KeyListener {
	/**
	 * Used to control what directions of rotation are possible.
	 */
	public enum Rotation {
		Y,
		Z
	}
	
	private int keyCode;
	private boolean isAcceptingInput;
	private boolean increase;
	private boolean flip;
	private Rotation r;
	private CubeController cc;
	
	/**
	 * Creates a new Rotation keyboard listener. It is used to send commands to the Cube controller to rotate the Cube when a key is pressed.
	 * 
	 * @param keyCode The code of the key the listener should listen for.
	 * @param r The axis of rotation the Cube should be rotated around.
	 * @param increase Determines whether to increase or decrease the rotation.
	 * @param flip Determines whether the Cube "flips" the sides, i.e. one button push leads to a 90 degree rotation, or if a button push leads to a much smaller one.
	 */
	public RotationKeyboard (CubeController cc, int keyCode, Rotation r, boolean increase, boolean flip) {
		this.keyCode = keyCode;
		this.r = r;
		this.increase = increase;
		this.cc = cc;
		this.flip = flip;
		
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
		if(keyI != keyCode)
			return;
		
		float multiplier = 1;
		if(!increase) {
			multiplier *= -1;
		}
		
		if(!flip) {
			if(r == Rotation.Y) {
				cc.rotateY(0.015f * multiplier);
			}
			else {
				cc.rotateZ(0.015f * multiplier);
			}
		}
		else {
			if(r == Rotation.Y) {
				cc.rotateY(1.4551f * multiplier);
			}
			else {
				cc.rotateZ(1.4551f * multiplier);
			}
		}
	}

	@Override
	public void keyReleased(int keyI, char keyC) {
		if(keyI != keyCode)
			return;
		
		if(!flip) {
			if(r == Rotation.Y) {
				cc.rotateY(0f);
			}
			else {
				cc.rotateZ(0f);
			}
		}
	}
}
