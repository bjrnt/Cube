
/**
 * represents a 3x3 Matrix used for calculations in 3-space
 * Also an immutable class
 * @author Johan
 *
 */
public final class Matrix3x3 {
	Vector3D[] rows=new Vector3D[3];
	Vector3D[] columns=new Vector3D[3];
	public Matrix3x3(Vector3D row1,Vector3D row2,Vector3D row3){
		rows[0]=row1;
		rows[1]=row2;
		rows[2]=row3;
		calculateColumns();
	}
	public Matrix3x3(float a11,float a12,float a13,float a21,float a22,float a23,float a31,float a32,float a33){
		this(new Vector3D(a11,a12,a13 ),new Vector3D(a21,a22,a23 ),new Vector3D(a31,a32,a33 ));
	}
	private void calculateColumns(){
			columns[0]=new Vector3D(rows[0].getX(), rows[1].getX(), rows[2].getX());
			columns[1]=new Vector3D(rows[0].getY(), rows[1].getY(), rows[2].getY());
			columns[2]=new Vector3D(rows[0].getZ(), rows[1].getZ(), rows[2].getZ());
	}
	/**
	 * 
	 * @param i 0<=i<=2
	 * @return row nr i
	 */
	public Vector3D getRow(int i){
		return rows[i];
	}
	public Vector3D getCol(int i){
		return columns[i];
	}
	/**
	 * Projects the Vector according to the matrix into a space with at most 3 dimensions
	 * This is equivalent to matrix multiplication where the vector is the right 3x1 matrix
	 * and the matrix is the translation matrix
	 * @return the translated vector
	 */
	public Vector3D translateVector(Vector3D v){
		return new Vector3D(Vector3D.dotProduct(getRow(0), v), Vector3D.dotProduct(getRow(1), v), Vector3D.dotProduct(getRow(2), v));
	}
	public String toString(){
		return rows[0]+"\n"+rows[1]+"\n"+rows[2];
	}
	//STATIC METHODS
	
	/**
	 * Multiplies the two matrices like this: [left]*[right]
	 * @return the product of the multiplication
	 */
	public static Matrix3x3 multiply(Matrix3x3 left,Matrix3x3 right){
		Vector3D row1=new Vector3D(Vector3D.dotProduct(left.getRow(0), right.getCol(0)), Vector3D.dotProduct(left.getRow(0), right.getCol(1)), Vector3D.dotProduct(left.getRow(0), right.getCol(2)));
		Vector3D row2=new Vector3D(Vector3D.dotProduct(left.getRow(1), right.getCol(0)), Vector3D.dotProduct(left.getRow(1), right.getCol(1)), Vector3D.dotProduct(left.getRow(1), right.getCol(2)));
		Vector3D row3=new Vector3D(Vector3D.dotProduct(left.getRow(2), right.getCol(0)), Vector3D.dotProduct(left.getRow(2), right.getCol(1)), Vector3D.dotProduct(left.getRow(2), right.getCol(2)));
		return new Matrix3x3(row1, row2, row3);
	}
	
	
	/**
	 * Multiplies the matrices in the following order
	 * [matrices[0]]*[matrices[1]]*[matrices[2]]...[matrices[n]]
	 * That is, the last matrix is multiplied from the left by the second last.
	 * The product of these is multiplied by the third last and so on
	 * @param matrices must have length>1
	 * @return
	 */
	public static Matrix3x3 multiplyMany(Matrix3x3[] matrices){
		if (matrices.length<2) {
			throw new IllegalArgumentException("The number of matrices to multiply must be larger than 1");
		}
		Matrix3x3 currentMatrix=matrices[matrices.length-1];
		for (int i = matrices.length-2; i >=0 ; i--) {
			currentMatrix=Matrix3x3.multiply(matrices[i], currentMatrix);
		}
		return currentMatrix;
	}
	
	
	
}
