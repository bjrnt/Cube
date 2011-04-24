package cube;
import java.util.Random;

public enum Direction {
	//Declared in counterclockwise order to allow the turn-method to work
     RIGHT,UP,LEFT,DOWN;
     private static Random randomizer=new Random();
     
     /**
      * Returns the direction you get if you turn the current direction counter-clockwise
      * a specified number of quartercircles. Angle is measured in 90 degrees at a time since there
      * are only four directions
      * @param quarterCirclesTurned The number of quartercircles turned. That is if the
      * parameter is 0, turn 0 degrees counterclockwise. If its 3 turn 270 degrees counterclockwise and so on.
      * @return the new direction
      */
     public Direction turn(int quarterCirclesTurned){
    	 //Adding new quartercircles to the current value
    	 quarterCirclesTurned+=this.ordinal();
    	//mod 4 since there are only four directions
    	 quarterCirclesTurned%=4;
    	 return values()[quarterCirclesTurned];
     }
     
     public static Direction randomDirection(){
    	 return values()[randomizer.nextInt(4)];
     }
     
     public static Direction opposite(Direction d){
    	 return values()[(d.ordinal()+2)%4];
     }
}
