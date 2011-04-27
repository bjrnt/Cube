package game;

import cube.Direction;

/**
 * Used to implement changes into the Game as a result of keyboard input.
 * 
 * @author Björn Tegelund
 */
public class GameController {
	private Game g;

	/**
	 * Creates a new GameController. It is used to implement changes into the Game as a result of keyboard input.
	 * @param g The Game instance.
	 */
	public GameController(Game g) {
		this.g = g;
	}
	
	public void directionKeyPressed (Direction d) {
		g.movePlayer(d);
	}
	
}
