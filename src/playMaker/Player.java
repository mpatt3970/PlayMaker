package playMaker;

import java.awt.Point;

public abstract class Player extends MovableObject {
	private int speed;
	private boolean hasBall;
	private Point direction;
	
	public Player(int speed, boolean hasBall, Point location) {
		this.speed = speed;
		this.hasBall = hasBall;
		this.location = location;
		direction = null;
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
	
	public Point getDirection() {
		return direction;
	}
	
	public void setDirection(Point direction) {
		this.direction = direction;
	}
	
	/*
	 * 
	 */
	
}
