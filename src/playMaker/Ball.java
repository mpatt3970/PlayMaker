package playMaker;

import java.awt.Point;

public class Ball extends MovableObject {
	private Vector2D targetLocation;
	
	public Ball(Vector2D location, Vector2D targetLocation) {
		this.location = location;
		
		Vector2D copy = new Vector2D(location.x,location.y);
		initialLocation = copy;
		this.targetLocation = targetLocation;
	}
	
	@Override
	public void draw() {
		
	}

	/*
	 * Getters and Setters
	 */

	public Vector2D getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Vector2D targetLocation) {
		this.targetLocation = targetLocation;
	}
	
	/*
	 * 
	 */
	
	
}
