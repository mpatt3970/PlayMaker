package playMaker;

import java.awt.Point;

public class Ball {
	private Point currentLocation;
	private Point targetLocation;
	
	public Ball(Point locationNow, Point locationEnd) {
		this.currentLocation = locationNow;
		this.targetLocation = locationEnd;
	}
	
	public void draw() {
		
	}
	
	public void move() {
		
	}

	/*
	 * Getters and Setters
	 */
	
	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
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
