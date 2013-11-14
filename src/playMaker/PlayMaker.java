package playMaker;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayMaker extends JFrame {

	private SideBar sideBar;
	private Field field;

	private Team offense;
	private Team defense;

	// This can be adjusted later, just how big to draw players
	private final int PLAYERSIZE = 50;

	// this determines how many loops need to occur before the ball gets thrown
	private int throwCount = 100;

	private boolean playOver;

	public PlayMaker() {
		// instantiate gui components
		sideBar = new SideBar(this);
		field = new Field(this);

		// passing true initializes the team as offense
		offense = new Team(true);
		defense = new Team(false);

		// We can set this to false and call the processPlay when the GUI start button is pressed
		playOver = true;
	}

	public void processPlay() {
		/**
		 * This function will step through the play
		 * 1) Find best direction for players
		 * 2) Move them accordingly
		 * 3) Repaint
		 */

		// used to tell the quarterback to throw the ball after so many loops
		int loopCounter = 0;


		if (!playOver) {

			// this handles players making appropriate movement direction choices
			// offensive moves first since they know their route, defense is trying to compensate after words
			for (Player p : offense.getPlayers()) {
				Vector2D direction = findBestDirection(p,true);
				p.move(direction, p.getSpeed());
			}
			for (Player p : defense.getPlayers()) {
				Vector2D direction = findBestDirection(p,false);
				p.move(direction, p.getSpeed());
			}

			// repaint now that all players have new locations
			repaint();

			// loop through receivers to throwBall() or handOff() to anyone open or even run if no one is open
			if(loopCounter > throwCount) {
				/**
				 * We will probably need a reference to the QB, and the QB will also possibly need a
				 * reference to the ball since it had a throwBall() function
				 */
			}

			// increment the loop count toward ball throwing time
			loopCounter++;

		}


	}

	// this function loops over all other players to determine which direction the passed player should move
	// it then returns that direction so it can be passed to the move function of player p
	public Vector2D findBestDirection(Player p, boolean isOffense) {
		Vector2D distance = null;
		Vector2D netDirection = new Vector2D(0,0);
		ArrayList<Player> otherPlayers;

		// Pick which players to iterate through 
		if (isOffense)
			otherPlayers = defense.getPlayers();
		else
			otherPlayers = offense.getPlayers();


		for (Player player : otherPlayers) {
			// find distance between, find magnitude of that distance, determine if player should continue on their
			// local direction, or return the better direction to be used in the move function
			distance = new Vector2D(p.getLocation().x - player.getLocation().x,p.getLocation().y - player.getLocation().y);
			double magnitude = distance.getMagnitude();

			// if statements to determine what is the best direction to return according to the magnitude of the distance
			if (magnitude > 3*PLAYERSIZE) {
				// continue as normal, return players correct direction
				netDirection.x += p.getDirection().x;
				netDirection.y += p.getDirection().y;
			}
			else if (magnitude > PLAYERSIZE) {
				// return adjusted direction away from defensive player by adding a component to the players
				// current direction that points away from the defensive player

				// I wouldn't modify the route variables in players, just return something like
				// return getRouteDirection() + someChange
				// This way once they are far enough from the defender, they will continue on their planned route
			}
			else {
				// COLLISION
				// call a collision function which will sometimes stop the player's movement, sometimes let them through
				// if the collision involves a player that has the ball, the play should end

				if (blocked()) {

					// play ends if player that has ball is tackled
					if (p.isHasBall())
						playOver = true;

					// return zero for direction so player doesn't move
					return new Vector2D(0,0);
				} 
				else {
					// made it through the collision, continue on desired route
				}

			}
		}

		return null;
	}

	
	// this can be called when the user selects new play options from the combo boxes on the GUI
	// the team loadPlay functions will initialize all positions and directions
	public void loadPlayConfig(String offensePlay, String defensePlay) {
		offense.loadPlay(offensePlay);
		defense.loadPlay(defensePlay);
	}

	// This function just decides if the player gets through or not
	public boolean blocked() {
		return false;
	}

	/*
	 * Getters and Setters
	 */

	public Team getOffense() {
		return offense;
	}

	public void setOffense(Team offense) {
		this.offense = offense;
	}

	public Team getDefense() {
		return defense;
	}

	public void setDefense(Team defense) {
		this.defense = defense;
	}

	public boolean getPlayOver() {
		return playOver;
	}
	/*
	 * 
	 */

	public static void main(String[] args) {
		PlayMaker gui = new PlayMaker();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}
