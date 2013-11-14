package playMaker;

import java.awt.Point;





public abstract class MovableObject {
	/**
	 * My idea for this class is to provide basic move functions that Player and Ball can extend and use for themselves with a common syntax
	 * 
	 * 
	 */
	
	protected Vector2D location;
	protected Vector2D initialLocation;
	
	public void move(Vector2D direction, int speed) {
		// vector along direction
		Vector2D unit = direction.getUnitVector();
		// add to current position
		location.x += speed*unit.x;
		location.y += speed*unit.y;
		
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
	
	
}
