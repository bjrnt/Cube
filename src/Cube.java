import java.util.ArrayList;

/**
 * The graphical interpretation of a Cube in three dimensions
 * @author Johan
 *
 */
public class Cube {
	//This is not measured in actual pixels!
	private static final float SIDEWIDTH=200.0f;
	private Side[] sides=new Side[]{new Side( new Vector3D(1, 0, 0), new Vector3D(0, 0, 1))};
	private int squaresPerSide;
	/**
	 * Initailizes the cube divided into 6 sides with 
	 * sideWidth*sideWidth number of squares on each side
	 * @param sideWidth The number of squares 
	 */
	public Cube(int squaresPerSide){
		this.squaresPerSide=squaresPerSide;
	}
	/**
	 * Returns all renderable objects on the cube which are visible from the viewers perspective
	 * @return An ArrayList of Renderables 
	 */
	public ArrayList<Vector3D[]> getGrid(){
		return sides[0].getGrid();
	}
	
	/**
	 * A representation of a side
	 * 
	 * _____________________
	 *|                     |
	 *|                     |
	 *|                     |
	 *|                     |
	 *|  /|\     ________\  |
	 *|   |      _|  n   /  |
	 *|   |up               |
	 *|                     |
	 *|                     |
	 *|_____________________|
	 * 
	 * 
	 */
	private class Side{
		Vector3D n,up,cross;
		
		/**
		 * Initializes a side in the Cube
		 * @param sideWidth
		 * @param normal MUST HAVE THE FORMAT (0 or 1,0 or 1,0 or 1) and have length 1
		 * @param upDirection MUST HAVE SAME FORMAT AS NORMAL
		 */
		private Side(Vector3D normal, Vector3D upDirection){
			checkVector(normal);
			checkVector(upDirection);
			
			n=normal;
			up=upDirection;
			cross=Vector3D.crossProduct(n, up);
		}
		/**
		 * Returns pairs of vector coordinates. Each of which represents a straight line defining the 
		 * edge of the side
		 * @return a list containing Vector3D[] arrays with two elements per array
		 */
		public ArrayList<Vector3D[]> getGrid(){
			ArrayList<Vector3D[]> lines=new ArrayList<Vector3D[]>();
			//Calculates the position of one corner of the side
			Vector3D startVector=Vector3D.add(Vector3D.scalarMultiplication(cross, SIDEWIDTH/2),Vector3D.add(Vector3D.scalarMultiplication(n, SIDEWIDTH/2),Vector3D.scalarMultiplication(up, SIDEWIDTH/2)));
			//Calculates the opposite corner
			Vector3D opposite=Vector3D.subtract(startVector,Vector3D.scalarMultiplication(cross, SIDEWIDTH));
			//Adding the top line
			lines.add(new Vector3D[]{startVector,opposite});
			//This vector represents the space between lines in the grid
			Vector3D space=Vector3D.scalarMultiplication(up, SIDEWIDTH/squaresPerSide);
			for (int i = 1; i <= squaresPerSide; i++) {
				lines.add(new Vector3D[]{Vector3D.subtract(startVector, Vector3D.scalarMultiplication(space, i)),Vector3D.subtract(opposite, Vector3D.scalarMultiplication(space, i))});
			}
			//Starting on "vertical" lines
			//startVector can be reused but space must change direction
			space=Vector3D.scalarMultiplication(cross, SIDEWIDTH/squaresPerSide);
			//Changing opposite to "vertical" alignment
			opposite=Vector3D.subtract(startVector, Vector3D.scalarMultiplication(up, SIDEWIDTH));
			//Adding "side-line"
			lines.add(new Vector3D[]{startVector,opposite});
			for (int i = 1; i <=squaresPerSide ; i++) {
				lines.add(new Vector3D[]{Vector3D.subtract(startVector, Vector3D.scalarMultiplication(space, i)),Vector3D.subtract(opposite, Vector3D.scalarMultiplication(space, i))});
			}
			return lines;
		}
		private void checkVector(Vector3D v){
			if (v.length()!=1) {
				throw new IllegalArgumentException("The vector must have the format (a,b,c) where a,b,c kan be 0 or 1 and have length 1");
			}
		}
	}
	
	
}
