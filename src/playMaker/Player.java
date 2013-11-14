package playMaker;

import java.awt.Point;

public abstract class Player extends MovableObject {
	private int speed;
	private boolean hasBall;
	
	// This allows for one turn, we can add more if needed
	private Point routeDirection1;
	private Point routeDirection2;
	
	// Determines how far from initial location player is before they run the second
	// half of their route
	private int routeUpdateDistance;
	
	public Player(int speed, boolean hasBall, Point location) {
		this.speed = speed;
		this.hasBall = hasBall;
		this.location = location;
		routeDirection1 = null;
		routeDirection2 = null;
	}
	
	public abstract void draw();

	/*
	 * Getters and Setters
	 */
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isHasBall() {
		return hasBall;
	}

	public void setHasBall(boolean hasBall) {
		this.hasBall = hasBall;
	}

	// returns the correct direction based on if the route should be update or not
	public Point getDirection() {
		Point distanceVector = new Point();
		distanceVector.x = location.x - initialLocation.x;
		distanceVector.y = location.y - initialLocation.y;
		
		int distance = (int) Math.sqrt((distanceVector.x)^2+(distanceVector.y)^2);
		
		if (distance > routeUpdateDistance)
			return routeDirection2;
		else
			return routeDirection1;
	}
	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getRouteDirection1() {
		return routeDirection1;
	}
	
	public Point getRouteDirection2() {
		return routeDirection2;
	}
	
	public void setRouteDirection1(Point direction) {
		 routeDirection1 = direction;
	}
	public void setRouteDirection2(Point direction) {
		routeDirection2 = direction;
	}
	
	/*
	 * 
	 */
	
}
