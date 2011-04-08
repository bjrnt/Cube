

/**
 * The graphical interpretation of a Cube in three dimensions
 * @author Johan
 *
 */
public class Cube {
	private Side[] sides=new Side[6];
	private int sideWidth;
	private static final int SIDEWIDTH_IN_PIXELS=0;
	/**
	 * Initailizes the cube divided into 6 sides with 
	 * sideWidth*sideWidth number of squares on each side
	 * @param sideWidth The number of squares 
	 */
	public Cube(int sideWidth){
		
	}
	/**
	 * A representation of a side
	 *    _____________________
	 *   |                     |
	 *   |                     |
	 *   |                     |
	 *   |                     |
	 *   |  /|\     ________\  |
	 *   |   |      _|  n   /  |
	 *   |   |up               |
	 *   |                     |
	 *   |                     |
	 *   |_____________________|
	 *   
	 * 
	 */
	private class Side{
		Vector3D n,up;
		
		/**
		 * Initializes a side in the Cube
		 * @param sideWidth
		 * @param normal Indicates the 
		 * @param upDirection
		 */
		private Side(int sideWidth,Vector3D normal, Vector3D upDirection){
			n=normal;
			up=upDirection;
		}
		
	}
	
	
}
