package game;

import org.newdawn.slick.Color;

import cube.Direction;
import cube.Square;

public class Game {
	private Square selectedSquare;
	private Color previousColor;
	
	public Game(Square startSquare) {
		selectedSquare = startSquare;
	}
	
	public void update(int delta) {
		if(selectedSquare.getBackColor() == previousColor)
			selectedSquare.setBackColor(Color.yellow);
		else
			selectedSquare.setBackColor(previousColor);
	}
	
	public void setSquare(Square s) {
		selectedSquare.setBackColor(previousColor);
		selectedSquare = s;
		previousColor = selectedSquare.getBackColor();
	}
	/**
	 * Moves the player, if possible
	 * @param d
	 */
	public void movePlayer(Direction d){
		
	}
	
	public Square getSquare() {
		if(selectedSquare.getBackColor() != previousColor)
			selectedSquare.setBackColor(previousColor);
		
		return selectedSquare;
	}
}
