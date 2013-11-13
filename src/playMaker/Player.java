package playMaker;

import java.awt.Point;

public abstract class Player extends MovableObject {
	private int speed;
	private boolean hasBall;
	
	// This allows for one turn, we can add more if needed
	private Point routeDirection1;
	private Point routeDirection2;
	
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
