package inputListeners;

import cube.CubeController;

/**
 * This class is used to send commands to rotate the Cube to the Cube controller as a result of keyboard input.
 * @author Björn Tegelund
 */
public class CubeRotationKeyboard extends AbstractKeyboardListener {
	public enum Rotation {
		X,
		Y,
		Z
	}
	
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
	public CubeRotationKeyboard(CubeController cc, int keyCode, Rotation r, boolean increase, boolean flip) {
		super(keyCode);
		this.r = r;
		this.cc = cc;
		this.flip = flip;
		this.increase = increase;
	}

	@Override
	public void pressed() {
		float multiplier = 1;
		if(!increase) {
			multiplier *= -1;
		}
		
		if(!flip) {
			if(r == Rotation.Y) {
				cc.rotateY(0.015f * multiplier);
			}
			else if(r == Rotation.X) {
				cc.rotateX(0.015f * multiplier);
			}
			else {
				cc.rotateZ(0.015f * multiplier);
			}
		}
		else {
			if(r == Rotation.Y) {
				cc.rotateY(1.4551f * multiplier);
			}
			else if(r == Rotation.X) {
				cc.rotateX(1.4551f * multiplier);
			}
			else {
				cc.rotateZ(1.4551f * multiplier);
			}
		}
	}
	
	@Override
	public void released() {
		if(!flip) {
			if(r == Rotation.Y) {
				cc.rotateY(0f);
			}
			if(r == Rotation.X) {
				cc.rotateX(0f);
			}
			else {
				cc.rotateZ(0f);
			}
		}
	}
}
