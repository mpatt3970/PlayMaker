package playMaker;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class QuarterBack extends Player {
	//Fine tune this to determine how much the throw leads the intended target
	final double LEAD_TIME_FAR = 65;
	final double LEAD_TIME_CLOSE = 15;
	final double CLOSE_FAR_CHANGING_DISTANCE = 200;

	public QuarterBack(Vector2D location, Team team, PlayMaker playMaker) {
		super(location, team, playMaker);
		this.speed = 2;
		this.hasBall = true;
	}

	// Sets the target for the ball to an open receiver
	public Ball throwBall(Team offense) {
		Random generator = new Random();
		int selected;
		Vector2D playerTarget = new Vector2D();
		Vector2D playersDirection = new Vector2D();
		Vector2D throwTarget = new Vector2D();
		ArrayList<Player> openPlayers = new ArrayList<Player>();

		// Push open players to the array
		for(Player player : offense.getPlayers()) {
			if (!this.equals(player) && player.isReceiver() && player.isOpen()){
				openPlayers.add(player);
			}
		}
		// Select a player to throw to OR just run forward if no one is open
		if (openPlayers.size() > 0) {
			//throw it away
			this.setHasBall(false);
			// select a player to throw to
			selected = generator.nextInt(openPlayers.size());
			playerTarget = openPlayers.get(selected).getLocation();
			playersDirection = openPlayers.get(selected).getDirection();

			Vector2D distance = new Vector2D();
			distance.x = playerTarget.x-this.location.x;
			distance.y = playerTarget.y-this.location.y;

			if (distance.getMagnitude() > CLOSE_FAR_CHANGING_DISTANCE) {
				throwTarget.x = playerTarget.x + LEAD_TIME_FAR*playersDirection.x;
				throwTarget.y = playerTarget.y + LEAD_TIME_FAR*playersDirection.y;
			} else {
				throwTarget.x = playerTarget.x + LEAD_TIME_CLOSE*playersDirection.x;
				throwTarget.y = playerTarget.y + LEAD_TIME_CLOSE*playersDirection.y;
			}

			// return the correct ball
			return new Ball(new Vector2D(this.getLocation().x,this.getLocation().y),new Vector2D(throwTarget.x,throwTarget.y));

		} else {
			//QB runs ball
			super.setRouteDirection1(new Vector2D(0,-1));
			super.setRouteDirection2(new Vector2D(0,-1));
			return null;
		}


	}
	
	@Override
	public boolean isReceiver() {
		// because it aren't allowed to catch
		return false;
	}

	@Override
	public boolean catchBall(Ball ball) {
		return false;
	}

	// This may be taken care of with a "throw" to a halfback/fullback
	public void handOff() {

	}


}
