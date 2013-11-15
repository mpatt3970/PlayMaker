package playMaker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Ball extends MovableObject {
	public final static int BALL_SIZE = 15;
	
	private Image ballDraw;
	private Vector2D targetLocation;
	
	public Ball(Vector2D location, Vector2D targetLocation) {
		this.location = location;
		
		Vector2D copy = new Vector2D(location.x,location.y);
		initialLocation = copy;
		this.targetLocation = targetLocation;
		loadImage();
	}
	
	public void loadImage() {
		URL url = getClass().getResource("/images/ball.png");
		ballDraw = Toolkit.getDefaultToolkit().getImage(url);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(ballDraw, (int)location.x, (int)location.y, null);
	}

	/*
	 * Getters and Setters
	 */

	public Vector2D getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Vector2D targetLocation) {
		this.targetLocation = targetLocation;
	}
	
	/*
	 * 
	 */
	
	
}
