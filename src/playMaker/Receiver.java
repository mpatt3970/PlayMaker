package playMaker;

import java.awt.Point;

public class Receiver extends Player {
	// I figure the running back can be represented as a receiver
	
	public Receiver(Vector2D location, Team team, PlayMaker playMaker) {
		super(location, team, playMaker);
		this.speed = 4;
		this.hasBall = false;
	}

	
}
