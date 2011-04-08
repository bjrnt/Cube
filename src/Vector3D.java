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
	public float length(){
		return (float)Math.sqrt(x*x+y*y+z*z);
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
	public String toString(){
		return "("+x+","+y+","+z+")";
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
	 * Multiplies the vector v with the scalar f
	 * @param v
	 * @param f
	 * @return
	 */
	public static Vector3D scalarMultiplication(Vector3D v, float f){
		nullCheck(v);
		return new Vector3D(v.x*f,v.y*f, v.z*f);
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
	 * Returns a vector that is orthogonal to the Vectors v and w
	 * @param v
	 * @param w
	 * @return
	 */
	public static Vector3D crossProduct(Vector3D v,Vector3D w){
		nullCheck(v);
		nullCheck(w);
		return new Vector3D(v.y*w.z-v.z*w.y,v.z*w.x-v.x*w.z,v.x*w.y-v.y*w.x);
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
