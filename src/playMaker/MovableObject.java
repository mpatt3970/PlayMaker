package playMaker;

import java.awt.Point;





public abstract class MovableObject {
	/**
	 * My idea for this class is to provide basic move functions that Player and Ball can extend and use for themselves with a common syntax
	 * 
	 * @param start
	 * @param speed
	 * @return
	 */
	
	public Point moveForward(Point start, int speed) {
		return new Point(5, 5);
	}
	
	public Point moveBackwards(Point start, int speed) {
		return new Point(5, 5);
	}
	
	public Point moveLeft90degrees(Point start, int speed) {
		return new Point(5, 5);
	}
	
	public Point moveLeft30degrees(Point start, int speed) {
		return new Point(5, 5);
	}
	
	public Point moveLeft45degrees(Point start, int speed) {
		return new Point(0, 0);
	}
	
	public Point moveLeft60degrees(Point start, int speed) {
		return new Point(0, 0);
	}
	
	public Point moveRight90degrees(Point start, int speed) {
		return new Point(0,0);
	}
	
	public Point moveRight30degrees(Point start, int speed) {
		return new Point(5, 5);
	}
	
	public Point moveRight45degrees(Point start, int speed) {
		return new Point(0, 0);
	}
	
	public Point moveRight60degrees(Point start, int speed) {
		return new Point(0, 0);
	}
}
