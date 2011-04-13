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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vector3D)) {
			return false;
		}
		Vector3D other = (Vector3D) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z)) {
			return false;
		}
		return true;
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
