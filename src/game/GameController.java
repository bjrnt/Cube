package game;

import cube.Cube;
import cube.Direction;

/**
 * Used to implement changes into the Game as a result of keyboard input.
 * 
 * @author Bj�rn Tegelund
 */
public class GameController {
	private Game g;
	private Cube c;
	private final float pi = (float) Math.PI;

	/**
	 * Creates a new GameController. It is used to implement changes into the Game as a result of keyboard input.
	 * @param g The Game instance.
	 */
	public GameController(Game g, Cube c) {
		this.g = g;
		this.c = c;
	}
	
	public void startTrail() {
		g.startTrail();
	}
	
	public void directionKeyPressed (Direction d, boolean primaryKeySet) {
		/*if(c.getRotY() >= pi/3 && c.getRotY() <= 4/3 * pi && !primaryKeySet) {
			int n = Math.round(c.getRotZ()/(pi/2)) % 4;
			System.out.println(n + " Z: " + c.getRotZ());
			int m = directionToInt(d) + n;
			
			g.movePlayer(intToDirection(m));
		}
		else if(c.getRotY() <= -pi/3 && c.getRotY() >= -4/3 * pi && !primaryKeySet) {
			int n = Math.round(c.getRotZ()/(pi/2)) % 4;
			System.out.println(n + " Z: " + c.getRotZ());
			int m = directionToInt(d) - n;
			
			g.movePlayer(intToDirection(m));
		}*/
		
	       g.movePlayer(d);
	}
	
	public void resetLevel() {
		 
		g.reset();
	}
	
	private int directionToInt(Direction d) {
		switch(d) {
		case UP:
			return 0;
		case RIGHT:
			return 1;
		case DOWN:
			return 2;
		case LEFT:
			return 3;
		}
		throw new IllegalArgumentException("BUG");
	}
	
	private Direction intToDirection(int n) {
		System.out.println("n: " + n);
		if(n<0)
			n+=4;
		if(n>3)
			n-=4;
		if(n == 0)
			return Direction.UP;
		if(n == 1)
			return Direction.RIGHT;
		if(n == 2)
			return Direction.DOWN;
		if(n == 3)
			return Direction.LEFT;
		throw new IllegalArgumentException("BUG");
	}
	
	public void switchCube(Cube newCube){
		c=newCube;
	}
}
