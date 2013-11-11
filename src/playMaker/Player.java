package playMaker;

import java.awt.Point;

public abstract class Player {
	private int speed;
	private boolean hasBall;
	private Point location;
	
	public Player(int speed, boolean hasBall, Point location) {
		this.speed = speed;
		this.hasBall = hasBall;
		this.location = location;
	}
	
	public abstract void move();
	
	public abstract void draw();
}
