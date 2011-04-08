/**
 * Representing a methematical vector in threespace
 * THIS IS AN IMMUTABLE CLASS
 * @author Johan
 *
 */
public final class Vector3D {
	private float x,y,z;
	
	public Vector3D(float x,float y,float z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getZ(){
		return z;
	}
	
	//STATIC METHODS
	/**
	 * Adds two vectors
	 * @param v first vector
	 * @param w second vector
	 * @return The resulting vector
	 */
	public static Vector3D add(Vector3D v,Vector3D w){
		nullCheck(v);
		nullCheck(w);
		return new Vector3D(v.x+w.x, v.y+w.y, v.z+w.z);
	}
	/**
	 * Substracts w from v that is v-w
	 * @param v first vector
	 * @param w second vector
	 * @return the resulting vector
	 */
	public static Vector3D subtract(Vector3D v,Vector3D w){
		nullCheck(v);
		nullCheck(w);
		return new Vector3D(v.x-w.x, v.y-w.y, v.z-w.z);
	}
	/**
	 * Calculates the dot product of the two vectors
	 * @param v first vector
	 * @param w second vector
	 * @return A scalar representing the dot product
	 */
	public static float dotProduct(Vector3D v,Vector3D w){
		nullCheck(v);
		nullCheck(w);
		return v.x*w.x+v.y*w.y+v.z*w.z;
	}

	/**
	 * Checks and throws exceptions if input is null;
	 */
	private static void nullCheck(Object input){
		if (input==null) {
			throw new NullPointerException();
		}
	}
}
