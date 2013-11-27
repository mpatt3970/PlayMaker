package playMaker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PlayMaker extends JFrame {
	public static final int DEFAULT_SIZE_X = 900;
	public static final int DEFAULT_SIZE_Y = 600;
	public static final int DEFAULT_SIDEBAR_X = 150;

	private SideBar sideBar;
	private Field field;

	private Team offense;
	private Team defense;
	
	private Ball ball;
	
	private ArrayList<MovableObject> drawable;
	
	private Timer animationTimer;



	// this determines how many loops need to occur before the ball gets thrown
	private static int THROW_COUNT = 100;

	private boolean playOver;

	public PlayMaker() {
		// passing true initializes the team as offense
		offense = new Team(true);
		defense = new Team(false);
		
		
		// initialize ball
		ball = new Ball(new Vector2D(50, 50), new Vector2D(50, 50));
		// make a drawable(ie movable) list to pass to paintComponent
		drawable = new ArrayList<MovableObject>();
		drawable.addAll(offense.getPlayers());
		drawable.addAll(defense.getPlayers());
		drawable.add(ball);
		
		// We can set this to false and call the processPlay when the GUI start button is pressed
		playOver = true;
	}

	public void initGui() {
		this.setSize(DEFAULT_SIZE_X, DEFAULT_SIZE_Y);
		// instantiate gui components
		sideBar = new SideBar(this, DEFAULT_SIDEBAR_X, DEFAULT_SIZE_Y);
		field = new Field(this, DEFAULT_SIZE_X - DEFAULT_SIDEBAR_X, DEFAULT_SIZE_Y);
		this.add(sideBar, BorderLayout.WEST);
		this.add(field, BorderLayout.CENTER);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
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
		playOver = false;

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
			if(loopCounter > THROW_COUNT) {
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
			if (magnitude > 3*Player.PLAYER_SIZE_X) {
				// continue as normal, add players correct direction
				netDirection.x += p.getDirection().getUnitVector().x;
				netDirection.y += p.getDirection().getUnitVector().y;
				p.setIsOpen(true);
			}
			else if (magnitude > Player.PLAYER_SIZE_X) {
				// return adjusted direction away from defensive player by adding a component to the players
				// current direction that points away from the defensive player

				// the two is so this has more influence on motion direction
				if (isOffense) {
					//move away
					netDirection.x += 2*distance.getUnitVector().x;
					netDirection.y += 2*distance.getUnitVector().y;
				} else {
					// move towards
					netDirection.x -= 2*distance.getUnitVector().x;
					netDirection.y -= 2*distance.getUnitVector().y;
				}
			}
			else {
				// COLLISION
				// call a collision function which will sometimes stop the player's movement, sometimes let them through
				// if the collision involves a player that has the ball, the play should end

				p.setIsOpen(false);
				
				if (blocked()) {

					// play ends if player that has ball is tackled
					if (p.isHasBall())
						playOver = true;

					// return zero for direction so player doesn't move
					return new Vector2D(0,0);
				} 
				else {
					// made it through the collision, continue on desired route
					// this can be changed as needed depending on how it makes players move once
					// we see it in action
					netDirection.x += p.getDirection().getUnitVector().x;
					netDirection.y += p.getDirection().getUnitVector().y;
				}

			}
		}
		return netDirection;
	}


	// this can be called when the user selects new play options from the combo boxes on the GUI
	// the team loadPlay functions will initialize all positions and directions
	public void loadPlayConfig(String offensePlay, String defensePlay) {
		offense.loadPlay(offensePlay);
		defense.loadPlay(defensePlay);
	}

	// This function just decides if the player gets through or not
	public boolean blocked() {
		Random generator = new Random();
		int chance = generator.nextInt(10);
		if (chance < 5)
			return true;
		else
			return false;
	}
	
	public void animate() {
		// Thanks to http://stackoverflow.com/questions/9800968/ball-animation-in-swing
		initGui();
		ActionListener actionTimer = new ActionListener() {
			// called when the timer triggers an action
			@Override
			public void actionPerformed(ActionEvent arg0) {
				processPlay();
				repaint();
			}
		};
		
		animationTimer = new Timer(500, actionTimer);
	}

	/*
	 * Getters and Setters
	 */
	
	public ArrayList<MovableObject> getDrawable() {
		return drawable;
	}

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
	
	public void flipPlayOver() {
		// also start and stop the timer
		if (playOver == true) {
			animationTimer.start();
			playOver = false;
		} else {
			animationTimer.stop();
			playOver = true;
		}
	}
	/*
	 * 
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayMaker gui = new PlayMaker();
				gui.animate();
			}
		});
	}
}
