package playMaker;

import java.awt.Point;

public abstract class Player {
	private int speed;
	private boolean hasBall;
	private Point location;
	
	public abstract void move();
	
	public abstract void draw();
}
