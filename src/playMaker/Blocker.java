package playMaker;

import java.awt.Point;

public class Blocker extends Player {
	
	
	
	public Blocker(Vector2D location, Team team) {
		super(location, team);
		this.speed = 1;
		this.hasBall = false;
	}

	
	
}
