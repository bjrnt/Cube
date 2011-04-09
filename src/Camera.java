/**
 * The Camera's position is used as the projection plane.
 * 
 * @author Bjorn Tegelund
 */
public class Camera extends GameObject {
	/**
	 * Creates a new Camera which is used to see objects in 3D space within the game.
	 * @param pos the position of the camera.
	 */
	public Camera(Vector3D pos) {
		super(pos);
	}
	
}
