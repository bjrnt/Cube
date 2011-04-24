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
	
	public void changeSquare(Direction d) {
		selectedSquare.setBackColor(previousColor);
		selectedSquare = selectedSquare.getNeighbor(d);
		previousColor = selectedSquare.getBackColor();
	}
	
	public void update(int delta) {
		if(selectedSquare.getBackColor() == previousColor)
			selectedSquare.setBackColor(Color.yellow);
		else
			selectedSquare.setBackColor(previousColor);
	}
}
