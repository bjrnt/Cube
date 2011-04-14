/**
 * Represents a vector in euclidean 2-space
 * @author Johan
 *
 */
public final class Vector2D {
	private float x,y;
	public Vector2D(float x,float y){
		this.x=x;
		this.y=y;
	}

	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	/**
	 * @return the length of this vector
	 */
	public float length(){
		return (float)Math.sqrt(x*x+y*y);
	}
	public String toString() {
		return "("+x+","+y+")";
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
		if (!(obj instanceof Vector2D)) {
			return false;
		}
		Vector2D other = (Vector2D) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		return true;
	}


	//STATIC METHODS
	/**
	 * Adds two vectors
	 * @param v first vector
	 * @param w second vector
	 * @return The resulting vector
	 */
	public static Vector2D add(Vector2D v,Vector2D w){
		nullCheck(v);
		nullCheck(w);
		return new Vector2D(v.x+w.x, v.y+w.y);
	}
	/**
	 * Substracts w from v that is v-w
	 * @param v first vector
	 * @param w second vector
	 * @return the resulting vector
	 */
	public static Vector2D subtract(Vector2D v,Vector2D w){
		nullCheck(v);
		nullCheck(w);
		return new Vector2D(v.x-w.x, v.y-w.y);
	}
	/**
	 * Calculates the dot product of the two vectors
	 * @param v first vector
	 * @param w second vector
	 * @return A scalar representing the dot product
	 */
	public static float dotProduct(Vector2D v,Vector2D w){
		nullCheck(v);
		nullCheck(w);
		return v.x*w.x+v.y*w.y;
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
