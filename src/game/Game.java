package game;

import org.newdawn.slick.Color;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import cube.Direction;
import cube.Square;

public class Game {
	private static final Color DEFAULT_BACK_COLOR=Color.white;
	private static final Color DEFAULT_COLOR=Color.yellow;
	private Color selectColor=DEFAULT_COLOR;
	private Square selectedSquare;
	private boolean leaveTrail=false;
	private int points=0;
	private Color previousColor=Color.white;
	
	public Game(Square startSquare, int maxPoints) {
		selectedSquare = startSquare;
		selectedSquare.setBackColor(selectColor);
	}
	
	public void update(int delta) {
		
	}
	
	public void setSquare(Square s) {
		if (leaveTrail) {
			if (s.isEndSquare()) {
			points++;
			}
		}
		else{
			
			selectedSquare.setBackColor(previousColor);
		}
		
		selectedSquare = s;
		previousColor = selectedSquare.getBackColor();
		s.setBackColor(selectColor);
	}
	/**
	 * Moves the player, if possible
	 * @param d
	 */
	public void movePlayer(Direction d){
		Square neighbor=selectedSquare.getNeighbor(d);
		if (neighbor.isTraversable()&&!leaveTrail||(leaveTrail&&neighbor.getBackColor()==DEFAULT_BACK_COLOR&&(!neighbor.isEndSquare()||neighbor.getBackColor()==selectColor))) {
			setSquare(neighbor);
		}
	}
	
	public Square getSquare() {
		if(selectedSquare.getBackColor() != previousColor)
			selectedSquare.setBackColor(previousColor);
		
		return selectedSquare;
	}
	
	public void startTrail(){
		if (selectedSquare.isEndSquare()) {
			leaveTrail=true;
			selectColor=selectedSquare.getBackColor();
		}
	}
	private void youWin(){
		System.out.println("YOU WON THIS LEVEL");
	}
}
