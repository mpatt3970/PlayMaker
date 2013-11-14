package playMaker;

import java.awt.Point;

public class Ball extends MovableObject {
	private Vector2D targetLocation;
	
	public Ball(Vector2D locationNow, Vector2D locationEnd) {
		this.location = locationNow;
		this.targetLocation = locationEnd;
	}
	
	public void draw() {
		
	}

	/*
	 * Getters and Setters
	 */
	
	public Vector2D getCurrentLocation() {
		return location;
	}

	public void setCurrentLocation(Vector2D currentLocation) {
		this.location = currentLocation;
	}

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
