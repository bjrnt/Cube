package cube;
import java.util.EnumMap;
import objectTypes.Vector3D;
import org.newdawn.slick.Color;

/**
 * Represents a square in 3-space. Or more precise any figure with 
 * four corners in 3-space 
 * This class is semi-immutable. The corners cannot be changed, but other properties can.
 * 
 * @author Johan
 */
public class Square {
	private Vector3D[] corners=new Vector3D[4];
	//On a cube or in a grid, each Square has four neighbors
	
	private EnumMap<Direction, Square> neighbors=new EnumMap<Direction, Square>(Direction.class);
	private Color
	backColor= Color.white;
	
	/**
	 * 
	 * @param c1 The vector representing the first corner
	 * @param c2 The vector representing the second corner
	 * @param c3 The vector representing the third corner
	 * @param c4 The vector representing the fourth corner
	 */
	public Square(Vector3D c1,Vector3D c2,Vector3D c3,Vector3D c4){
		corners[0]=c1;
		corners[1]=c2;
		corners[2]=c3;
		corners[3]=c4;
	}
	/**
	 * Gets corner i
	 * @param i 0<=i<=3
	 * @return
	 */
	public Vector3D getCorner(int i){
		if (i<0||i>3) {
			throw new IllegalArgumentException("You must specify a corner indexed between 0 and 3");
		}
		return corners[i];
	}
	
	public void setBackColor(Color c){
		backColor=c;
	}
	
	public Color getBackColor(){
		return backColor;
	}
	
	/**
	 * Sets a neighboring Square 
	 * @param d the direction left,right,up or down to which the new neighbor is attached
	 * @param neighbor the new neighbor
	 * @param the direction left,right,up or down to which this Square is attached to the neigbor
	 *      ______________ ______________
	 *     | this Square  | new neighbor |
	 *     |              |              |
	 *     |    d(right)  |neighborD left|
	 *     |    ------>   | <------      |
	 *     |              |              |
	 *     |______________|______________|
	 */
	public void setNeighbor(Direction d,Square neighbor,Direction neighborD) {
		neighbors.put(d, neighbor);
		neighbor.neighbors.put(neighborD, this);
		
	}
	
	public Square getNeighbor(Direction d){
		return neighbors.get(d);
	}
	
	/**
	 * Returns a random Neighbor
	 * @return
	 */
	public Square randomNeighbor(){
		return neighbors.get(Direction.randomDirection());
	}
}

