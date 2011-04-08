/**
 * A Camera is used as a point of perspective when rendering objects within the game.
 * 
 * @author Bjorn Tegelund
 */
public class Camera extends GameObject {
	private double rotationX, rotationY, rotationZ;
	
	/**
	 * Creates a new Camera which is used to see objects in 3D space within the game.
	 * @param pos the position of the camera.
	 * @param rotX the X-rotation of the camera.
	 * @param rotY the Y-rotation of the camera.
	 * @param rotZ the Z-rotation of the camera.
	 */
	public Camera(Vector3D pos, double rotX, double rotY, double rotZ) {
		super(pos);
		rotationX = rotX;
		rotationY = rotY;
		rotationZ = rotZ;
	}
	
	/**
	 * @return the Camera's X-rotation.
	 */
	public double getRotX() {
		return rotationX;
	}
	/**
	 * @return the Camera's Y-rotation.
	 */
	public double getRotY() {
		return rotationY;
	}
	/**
	 * @return the Camera's Z-rotation.
	 */
	public double getRotZ() {
		return rotationZ;
	}
}
