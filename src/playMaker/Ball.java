package playMaker;

import java.awt.Point;

public class Ball extends MovableObject {
	private Point targetLocation;
	
	public Ball(Point locationNow, Point locationEnd) {
		this.location = locationNow;
		this.targetLocation = locationEnd;
	}
	
	public void draw() {
		
	}

	/*
	 * Getters and Setters
	 */
	
	public Point getCurrentLocation() {
		return location;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public Point getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Point targetLocation) {
		this.targetLocation = targetLocation;
	}
	
	/*
	 * 
	 */
	
	
}
