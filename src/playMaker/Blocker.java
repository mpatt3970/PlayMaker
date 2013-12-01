package playMaker;

import java.awt.Point;

public class Blocker extends Player {
	
	
	
	public Blocker(Vector2D location, Team team, PlayMaker playMaker) {
		super(location, team, playMaker);
		this.speed = 1;
		this.hasBall = false;
	}

	@Override
	public boolean isReceiver() {
		// because it aren't allowed to catch
		return false;
	}
	
	
}
