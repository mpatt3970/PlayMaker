package playMaker;

import java.awt.Graphics;
import java.awt.Point;





public abstract class MovableObject {
	/**
	 * My idea for this class is to provide basic move functions that Player and Ball can extend and use for themselves with a common syntax
	 * 
	 * Since anything that moves, also should be drawn, i put draw in here
	 */
	
	protected Vector2D location;
	protected Vector2D initialLocation;
	
	public void move(Vector2D direction, int speed) {
		// This works with collision blocking
		if(direction.getMagnitude() < .1) {
			
		} else {
		// This is for all other movement
		// vector along direction
		Vector2D unit = direction.getUnitVector();
		// add to current position
		location.x += speed*unit.x;
		location.y += speed*unit.y;
		}
		
	}

	public Vector2D getLocation() {
		return location;
	}

	public void setLocation(Vector2D location) {
		this.location = location;
	}

	public Vector2D getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(Vector2D initialLocation) {
		this.initialLocation = initialLocation;
	}
	
	// Sets initialLocation as well as location
	public void setAbsoluteLocation(Vector2D position) {
		setInitialLocation(position);
		Vector2D copy = new Vector2D();
		copy.x = position.x;
		copy.y = position.y;
		setLocation(copy);
	}
	
	
	public abstract void draw(Graphics g);
	
}
