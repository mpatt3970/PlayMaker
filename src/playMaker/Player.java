package playMaker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public abstract class Player extends MovableObject {
	public static final int PLAYER_SIZE_X = 30;
	public static final int PLAYER_SIZE_Y = 40;

	protected int speed;
	protected boolean hasBall;
	private Team team;
	private boolean isOpen;

	// store the buffered images, using static to save space
	public static Image offensiveDraw;
	public static Image defensiveDraw;
	public static Image offensiveDrawBall;
	public static Image defensiveDrawBall;

	// This allows for one turn, we can add more if needed
	private Vector2D routeDirection1;
	private Vector2D routeDirection2;

	// Determines how far from initial location player is before they run the second
	// half of their route
	private double routeUpdateDistance = 50;

	public Player(Vector2D location, Team team) {
		this.location = location;
		this.team = team;

		Vector2D copy = new Vector2D(location.x,location.y);
		initialLocation = copy;

		routeDirection1 = null;
		routeDirection2 = null;

		isOpen = true;

		loadImages();
	}

	public void loadImages() {
		offensiveDraw = loadDraw("/images/offensePlayer.png");
		defensiveDraw = loadDraw("/images/defensivePlayer.png");
		offensiveDrawBall = loadDraw("/images/offensePlayerBall.png");
		defensiveDrawBall = loadDraw("/images/defensePlayerBall.png");
	}

	public Image loadDraw(String fileLocale) {
		URL url = getClass().getResource(fileLocale);
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	@Override
	public void draw(Graphics g) {
		if (hasBall) {
			if (team.isOffense()) {
				//draw offense with the ball player
				g.drawImage(offensiveDrawBall, (int)location.x, (int)location.y, null);
			} else {
				//draw defense with the ball player
				g.drawImage(defensiveDrawBall, (int)location.x, (int)location.y, null);
			}
		} else {

			// draw different colors for different teams
			if (team.isOffense()) {
				g.drawImage(offensiveDraw, (int)location.x, (int)location.y, null);
			} else {
				g.drawImage(defensiveDraw, (int)location.x, (int)location.y, null);
			}
		}
	}

	// Returns true if this player catches the ball
	public boolean catchBall(Ball ball) {
		if(ball != null) {
			Vector2D distance = new Vector2D();
			distance.x = ball.getLocation().x - this.location.x;
			distance.y = ball.getLocation().y - this.location.y;

			if (ball.canCatch() && distance.getMagnitude() <= ball.getCatchRadius()) {
				hasBall = true;
				return true;
			} else return false;
		} else
			return false;
	}



	/*
	 * Getters and Setters
	 */

	public boolean isOpen() {
		return isOpen;
	}

	public void setIsOpen(boolean b) {
		isOpen = b;
	}

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
