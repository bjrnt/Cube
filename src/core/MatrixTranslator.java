package core;

import objectTypes.Matrix3x3;
import objectTypes.Vector2D;
import objectTypes.Vector3D;

import org.newdawn.slick.geom.Polygon;


import cube.Square;

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
	Vector3D c=new Vector3D(300,0,0),e=new Vector3D(1000, 0, 0);
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
		//transMat=Matrix3x3.multiplyMany(new Matrix3x3[]{xMat,yMat,zMat});
		transMat=Matrix3x3.multiply(yMat, zMat);
		transMat=Matrix3x3.multiply(xMat, transMat);
	}
	/**
	 * Translates a 3-dimensional vector into another according to the specifications stated earlier
	 * @param v
	 * @return the new vector
	 */
	public Vector3D translate(Vector3D v){
		return transMat.translateVector(v);
	}
	/**
	 * Translates a vector through rotations and specifications and projects it on the screen
	 * which is the yz-plane
	 * @param v
	 * @return A 2D-vector that describes the vectors projection on the screen
	 */
	public Vector2D screenTranslate(Vector3D v){
		Vector2D v2D=translate2D(v);
		//System.out.println(w);

		return new Vector2D(v2D.getX()+SCREEN_WIDTH/2, v2D.getY()+SCREEN_HEIGHT/2);
	}
	public Vector2D translate2D(Vector3D v){
		Vector3D trans = translate(v);

		float w = -trans.getX()/(e.getX()-300) + 1;
		float y = -(trans.getZ() - e.getZ())/w;
		float x = (trans.getY() - e.getY())/w;
		return new Vector2D(x, y);
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
	
	
	
	/**
	 * Determines whether a side in a cube is visible at this present time by examining 
	 * the squares four corners
	 * 
	 * This is a very long and complicated solution but it works!
	 * @param vectorInPlane MUST be a vector in the plane that constitutes 
	 * @param normal The sides normal since in some cases the corners aren't enough
	 * @return Whether this side is visible or not
	 */
	public boolean sideVisible(Vector3D vectorInPlane,Vector3D normal){
		float dot1=Vector3D.dotProduct(translate(normal), translate(vectorInPlane));
		float dot2=Vector3D.dotProduct(translate(normal), Vector3D.subtract(e, c));
		//System.out.println(dot1+" and "+ dot2);
		if (dot1<dot2) {
			return true;
		}else{
			return false;
		}
	}

}
