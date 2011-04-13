import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

/**
 * An attempt to solve the problem of translation
 * @author Johan
 *
 */
public class MatrixTranslator {
	private float cosAx,sinAx,cosAy,sinAy,cosAz,sinAz;
	private static final int SCREEN_WIDTH=800;
	private static final int SCREEN_HEIGHT=600;
	//Where c is the cameras position and e is the viewers distance from the screen
	Vector3D c=new Vector3D(0,0,0),e=new Vector3D(1000, 0, 0);
	Matrix3x3 transMat;
	public MatrixTranslator(double angleX,double angleY,double angleZ){
		cosAx=(float)Math.cos(angleX);
		sinAx=(float)Math.sin(angleX);
		cosAy=(float)Math.cos(angleY);
		sinAy=(float)Math.sin(angleY);
		cosAz=(float)Math.cos(angleZ);
		sinAz=(float)Math.sin(angleZ);
		
		Matrix3x3 xMat=new Matrix3x3(1, 0, 0, 0,cosAx, -sinAx, 0, sinAx, cosAx);
		Matrix3x3 yMat=new Matrix3x3(cosAy, 0, sinAy, 0, 1, 0, -sinAy, 0, cosAy);
		Matrix3x3 zMat=new Matrix3x3(cosAz, -sinAz, 0, sinAz, cosAz, 0, 0, 0, 1);
		transMat=Matrix3x3.multiplyMany(new Matrix3x3[]{xMat,yMat,zMat});
	}
	/**
	 * Translates a 3-dimensional vector into another according to the specifications stated earlier
	 * @param v
	 * @return the new vector
	 */
	public Vector3D translate(Vector3D v){
		return transMat.translateVector(Vector3D.subtract(v, c));
	}
	/**
	 * Translates a vector through rotations and specifications an projects it on the screen
	 * which is the yz-plane
	 * @param v
	 * @return A 2D-vector that describes the vectors projection on the screen
	 */
	public Vector2D screenTranslate(Vector3D v){
		Vector3D trans = translate(v);

		float w = -trans.getX()/(e.getX()-300) + 1;
		float x = (trans.getZ() - e.getZ())/w;
		float y = (trans.getY() - e.getY())/w;
		
		//System.out.println(w);
		
		return new Vector2D(x+SCREEN_WIDTH/2, y+SCREEN_HEIGHT/2);
	}
	/**
	 * Translates a Square-object into screen coordinates by translating its corners through
	 * all rotations and translations and projecting them on the screen
	 * @return A Polygon object that represents the square's projection and is ready for drawing
	 */
	public Polygon translateSquare(Square s){
		Polygon p=new Polygon();
		Vector2D point;
		for (int i = 0; i < 4; i++) {
			point=screenTranslate(s.getCorner(i));
			p.addPoint(point.getX(), point.getY());
		}
		return p;
	}
	
}
