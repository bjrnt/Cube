package core;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import objectTypes.Matrix3x3;
import objectTypes.Vector2D;
import objectTypes.Vector3D;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

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
	private Vector2D translate2D(Vector3D v){
		Vector3D trans = translate(v);

		float w = -trans.getX()/(e.getX()-300) + 1;
		float x = (trans.getZ() - e.getZ())/w;
		float y = (trans.getY() - e.getY())/w;
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
	 * @param corners Must be four and must contain Vectors representing the corners of the side
	 * @param normal The sides normal since in some cases the corners aren't enough
	 * @return Whether this side is visible or not
	 */
	public boolean sideVisible(Vector3D[] corners,Vector3D normal){
		//The very longest side is the crucial one
		//If that side renders closer to origo than the second longest, then the side is visible
		Vector2D[] corners2D=new Vector2D[4];
		for (int i = 0; i < corners2D.length; i++) {
			corners2D[i]=translate2D(corners[i]);
		}
		//Will contain the longest 2D edge and its endpoints
		Vector2D[] longest=new Vector2D[]{Vector2D.subtract(corners2D[1], corners2D[0]),corners2D[0],corners2D[1]};
		//Will contain the second longest edge and its endpoints
		Vector2D[] secondLongest=new Vector2D[3];
		//temp will temporarily contain the edges of the side
		Vector2D temp;
		for (int i = 1; i < corners2D.length; i++) {//Finding the two longest sides...
			temp=Vector2D.subtract(corners2D[i], corners2D[(i+1)%4]);
			if (temp.length()>longest[0].length()) {//if this edge is longer than the current longest
				secondLongest=Arrays.copyOf(longest, longest.length);
				longest[0]=temp;
				longest[1]=corners2D[i];
				longest[2]=corners2D[(i+1)%4];
			}else if(secondLongest[0]==null||temp.length()>secondLongest[0].length()){//If we've found a new second longest 2D vector
				secondLongest[0]=temp;
				secondLongest[1]=corners2D[i];
				secondLongest[2]=corners2D[(i+1)%4];
			}
		}
		//If the longest and the shortest sides have any corner in common,
		//that means the side is either the side pointing directly forwards or directly backwards
		//which in turn means that we must use the sides normal to find out which 
		//alternative is right
		for (int i = 1; i < secondLongest.length; i++) {//comparing corners
			if (secondLongest[i].equals(longest[1])||secondLongest[i].equals(longest[2])) {
				if (translate(normal).getX()>0) {
					return true;
				}else{
					return false;
				}
			}
		}
		//If this is neither the closest nor the farthest side
		//Then we know that if the longest side is closer to origo compared to
		//the second longest, then it should be visible
		float difference= Vector2D.add(longest[1], longest[2]).length()-Vector2D.add(secondLongest[1], secondLongest[2]).length();  
		if (difference<0) {
			return true;
		}else{
			return false;
		}

	}

}
