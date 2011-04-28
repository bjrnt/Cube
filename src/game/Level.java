package game;


import org.newdawn.slick.Color;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cube.Cube;

public class Level {
	private static final int SQUARES_PER_SIDE=5; 
	private static final Color[] colors=new Color[]{Color.green, Color.magenta, Color.blue, Color.orange, Color.pink,Color.cyan};
	private static CubePoint[][][] endpoints= new CubePoint[][][]{
			new CubePoint[][]{//Contains pairs of cube points
					new CubePoint[]{new CubePoint(0, 2, 2),new CubePoint(0, 1, 1)}
			},
			new CubePoint[][]{//Level 2
					new CubePoint[]{new CubePoint(4,2,3), new CubePoint(5, 2, 2)},
					new CubePoint[]{new CubePoint(0,1,2), new CubePoint(0, 4, 4)},
					new CubePoint[]{new CubePoint(0,2,4), new CubePoint(0 ,2 ,1)}
			},
			new CubePoint[][]{//Level 3
					new CubePoint[]{new CubePoint(0,2,1), new CubePoint(2, 2, 2)},
					new CubePoint[]{new CubePoint(0,4,0), new CubePoint(5, 3, 2)},
					new CubePoint[]{new CubePoint(0,1,2), new CubePoint(5, 4, 1)},
					new CubePoint[]{new CubePoint(0,2,2), new CubePoint(1, 1, 4)},
					new CubePoint[]{new CubePoint(1,3,3), new CubePoint(3, 3, 3)},
					new CubePoint[]{new CubePoint(2,0,3), new CubePoint(4, 1, 3)}
			}
			
			
	}; 
	private static CubePoint[][] intraversables=new CubePoint[][]{
			new CubePoint[]{new CubePoint(0, 2, 3),new CubePoint(0, 1, 0),new CubePoint(0, 3, 4),},
			new CubePoint[]{//Level 2
				new CubePoint(0, 0, 1),new CubePoint(0, 0, 2),new CubePoint(0, 0, 3),new CubePoint(0, 0, 4),new CubePoint(0, 1, 0),new CubePoint(0, 1, 4),new CubePoint(0, 1, 1),new CubePoint(0, 2, 2),new CubePoint(0, 3, 4),new CubePoint(0, 4, 0),new CubePoint(0, 4, 1),new CubePoint(0, 4, 2),new CubePoint(0, 4, 3),
				new CubePoint(1, 0, 2),new CubePoint(1, 2, 2),new CubePoint(1, 3, 2),new CubePoint(1, 4, 2),
				new CubePoint(2, 0, 2),new CubePoint(2, 1, 2),new CubePoint(2, 3, 2),new CubePoint(2, 4, 2),
				new CubePoint(3, 0, 2),new CubePoint(3, 1, 2),new CubePoint(3, 2, 2),new CubePoint(3, 3, 2),
				new CubePoint(4, 4, 4),
				new CubePoint(5, 0, 2),new CubePoint(5, 1, 2),new CubePoint(5, 3, 2),new CubePoint(5, 4, 2)
			},
			new CubePoint[]{//Level 3
				new CubePoint(0, 0, 3),new CubePoint(0, 1, 1),new CubePoint(0, 2, 3),new CubePoint(0, 2, 4),new CubePoint(0, 3, 0),new CubePoint(0, 4, 1),new CubePoint(0, 4, 4),
				new CubePoint(1, 0, 1),new CubePoint(1, 0, 3),new CubePoint(1, 3, 2),new CubePoint(1, 4, 2),
				new CubePoint(2, 1, 1),new CubePoint(2, 2, 1),new CubePoint(2, 3, 1),new CubePoint(2, 4, 1),new CubePoint(2, 4, 3),new CubePoint(2, 4, 4),
				new CubePoint(3, 0, 1),new CubePoint(3, 1, 1),new CubePoint(3, 2, 4),new CubePoint(3, 3, 2),new CubePoint(3, 3, 4),new CubePoint(3, 4, 2),
				new CubePoint(4, 2, 2),new CubePoint(4, 3, 2),new CubePoint(4, 4, 4),
				new CubePoint(5, 0, 4),new CubePoint(5, 1, 0),new CubePoint(5, 1, 4),new CubePoint(5, 2, 4),new CubePoint(5, 3, 1),new CubePoint(5, 3, 4),new CubePoint(5, 4, 1),new CubePoint(5, 4, 4)
			}
			
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
