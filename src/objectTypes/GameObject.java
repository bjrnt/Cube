package objectTypes;

public class GameObject {
private Vector3D position;
	
	public GameObject(Vector3D pos) {
		position = pos;
	}
	
	/**
	 * @return the GameObject's X-position
	 */
	public float getX() {
		return position.getX();
	}
	/**
	 * @return the GameObject's Y-position
	 */
	public float getY() {
		return position.getY();
	}
	/**
	 * @return the GameObject's Z-position
	 */
	public float getZ() {
		return position.getZ();
	}
}
