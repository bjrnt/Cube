package game;


import org.newdawn.slick.Color;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cube.Cube;

public class Level {
	private static int resetLevel=0;
	private static final int SQUARES_PER_SIDE=10; 
	private static final Color[] colors=new Color[]{Color.green, Color.red, Color.blue, Color.orange, Color.pink,Color.magenta};
	private static CubePoint[][][] endpoints= new CubePoint[][][]{
			new CubePoint[][]{//Contains pairs of cube points
					new CubePoint[]{new CubePoint(0, 2, 7),new CubePoint(0, 1, 1)}
			}
			
			
	}; 
	private static CubePoint[][] intraversables=new CubePoint[][]{
			new CubePoint[]{new CubePoint(0, 2, 3),new CubePoint(0, 5, 7),new CubePoint(0, 1, 8),}
			
	};
	public static Cube getLevel(int level){
		Cube c=new Cube(SQUARES_PER_SIDE);
		int l= intraversables[level].length;
		CubePoint cPoint;
		for (int i = 0; i < l; i++) {
			cPoint=intraversables[level][i];
			c.getSquare(cPoint.getSide(), cPoint.getX(), cPoint.getY()).makeIntraversable();
		}
		l=endpoints[level].length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < endpoints[level][i].length; j++) {
				cPoint=endpoints[level][i][j];
				c.getSquare(cPoint.getSide(), cPoint.getX(), cPoint.getY()).setEndSquare(colors[i]);
			}
		}
		return c;
	}
	public static int maxpoint(int level){
		return endpoints[level].length;
	}
	public static int numberOfLevels(){
		return endpoints.length;
	}
	
	
	private static class CubePoint{
		private int side;
		private int x;
		private int y;
		public CubePoint(int side,int x, int y) {
			this.side=side;
			this.x=x;
			this.y=y;
		}
		
		/**
		 * @return the side
		 */
		public int getSide() {
			return side;
		}
		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}
		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}
	}
	
}
