package game;

import cube.Cube;
import cube.Direction;

/**
 * Used to implement changes into the Game as a result of keyboard input.
 * 
 * @author Björn Tegelund
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
	
	public void directionKeyPressed (Direction d) {
		g.movePlayer(d);
	}
	
}
