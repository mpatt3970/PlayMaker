package playMaker;

import java.awt.Point;

public class Receiver extends Player {
	// I figure the running back can be represented as a receiver
	
	private boolean isOpen;
	
	public Receiver(int speed, boolean hasBall, Point location) {
		super(speed,hasBall,location);
	}
	
	public void grabBall() {
		
	}

	@Override
	public boolean move() {
		return isOpen;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
