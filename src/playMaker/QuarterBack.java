package playMaker;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class QuarterBack extends Player {
	// Time the ball takes to travel half the screen.  This will need to change if ball speed changes
	// or if field size changes.  It could also just be fine tuned so balls are caught well
	final double LEAD_TIME = 50;
	
	public QuarterBack(int speed, boolean hasBall, Vector2D location, Team team) {
		super(speed,hasBall,location, team);
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
			openPlayers.add(player);
		}
		// Select a player to throw to OR just run forward if no one is open
		if (openPlayers.size() > 0) {
			//throw it away
			this.setHasBall(false);
			// select a player to throw to
			selected = generator.nextInt(openPlayers.size());
			playerTarget = openPlayers.get(selected).getLocation();
			playersDirection = openPlayers.get(selected).getDirection();
			
			throwTarget.x = playerTarget.x + LEAD_TIME*playersDirection.x;
			throwTarget.y = playerTarget.y + LEAD_TIME*playersDirection.y;
			
			// return the correct ball
			return new Ball(new Vector2D(this.getLocation().x,this.getLocation().y),new Vector2D(throwTarget.x,throwTarget.y));
			
		} else {
			//QB runs ball
			super.setRouteDirection1(new Vector2D(0,-1));
			super.setRouteDirection2(new Vector2D(0,-1));
			return null;
		}
		
		
	}
	
	// This may be taken care of with a "throw" to a halfback/fullback
	public void handOff() {
		
	}

	
}
