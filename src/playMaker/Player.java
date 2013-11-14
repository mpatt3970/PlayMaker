package playMaker;

import java.awt.Point;

public abstract class Player extends MovableObject {
	private int speed;
	private boolean hasBall;

	// This allows for one turn, we can add more if needed
	private Vector2D routeDirection1;
	private Vector2D routeDirection2;

	// Determines how far from initial location player is before they run the second
	// half of their route
	private double routeUpdateDistance;

	public Player(int speed, boolean hasBall, Vector2D location) {
		this.speed = speed;
		this.hasBall = hasBall;
		this.location = location;
		
		Vector2D copy = new Vector2D(location.x,location.y);
		initialLocation = copy;
		
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

	// returns the correct unit direction based on if the route should be update or not
	public Vector2D getDirection() {
		Vector2D displacement = new Vector2D();
		displacement.x = location.x - initialLocation.x;
		displacement.y = location.y - initialLocation.y;

		double magnitude = displacement.getMagnitude();

		if (magnitude > routeUpdateDistance) {
			return routeDirection2.getUnitVector();
		}
		else {
			return routeDirection1.getUnitVector();
		}

	}
	
	// Setters and Getters

	public Vector2D getRouteDirection1() {
		return routeDirection1;
	}

	public void setRouteDirection1(Vector2D routeDirection1) {
		this.routeDirection1 = routeDirection1;
	}

	public Vector2D getRouteDirection2() {
		return routeDirection2;
	}

	public void setRouteDirection2(Vector2D routeDirection2) {
		this.routeDirection2 = routeDirection2;
	}

	public double getRouteUpdateDistance() {
		return routeUpdateDistance;
	}

	public void setRouteUpdateDistance(double routeUpdateDistance) {
		this.routeUpdateDistance = routeUpdateDistance;
	}


}
