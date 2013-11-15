package playMaker;

import java.awt.Point;

public class Defender extends Player {
	
	
	public Defender(int speed, boolean hasBall, Vector2D location, Team team) {
		super(speed, hasBall, location, team);
	}

	public void grabBall() {
		// get the ball if it is nearby
	}
	
	public void rush() {
		// moving forward to make a play in the backfield
	}
	
	public void cover() {
		// running with a reciever to prevent him catching the ball
	}
	
	public void reactToBall() {
		// try to tackle the ball carrier
		// could be some weird trigonometry
	}



	
}
