package playMaker;

import java.awt.Point;

public class QuarterBack extends Player {
	
	public QuarterBack(int speed, boolean hasBall, Vector2D location, Team team) {
		super(speed,hasBall,location, team);
	}
	
	// Sets the target for the ball to an open receiver
	public void throwBall(Ball ball, Team offense) {
		
	}
	
	// This may be taken care of with a "throw" to a halfback/fullback
	public void handOff() {
		
	}

	
}
