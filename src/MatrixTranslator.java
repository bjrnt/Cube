/**
 * An attempt to solve the problem of translation
 * @author Johan
 *
 */
public class MatrixTranslator {
	float cosAx,sinAx,cosAy,sinAy,cosAz,sinAz;
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
	
	public Vector3D translate(Vector3D v){
		return transMat.translateVector(Vector3D.subtract(v, c));
	}
	public Vector2D screenTranslate(Vector3D v){
		Vector3D trans = translate(v);
		float x=trans.getZ()-e.getZ();
		float y=trans.getY()-e.getY();
//		float x=(trans.getZ()-e.getZ())/((c.getX()+e.getX())/(c.getX()+e.getX()-trans.getX()));
//		float y=(trans.getY()-e.getY())/((c.getX()+e.getX())/(c.getX()+e.getX()-trans.getX()));
		return new Vector2D(x, y);
	}
	
	
}
