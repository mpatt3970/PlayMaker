package playMaker;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PlayMaker extends JFrame {
	public static final int DEFAULT_SIZE_X = 900;
	public static final int DEFAULT_SIZE_Y = 600;
	public static final int DEFAULT_SIDEBAR_X = 150;

	private SideBar sideBar;
	private Field field;

	public Field getField() {
		return field;
	}

	private Team offense;
	private Team defense;
	//so we have a reference to the quarterback
	private static int QB_INDEX = 5;

	private Ball ball;

	private ArrayList<MovableObject> drawable;

	private Timer animationTimer;


	// this determines how many loops need to occur before the ball gets thrown
	private static int THROW_COUNT = 95;
	private int loopCounter;
	private boolean thrown;
	private boolean paused;
	private boolean caught;

	//This new version of playOver is true when the ball carrier is tackled
	private boolean playOver;

	public PlayMaker() {
		// passing true initializes the team as offense
		offense = new Team(true, this);
		defense = new Team(false, this);

		caught = false;

		// make a drawable(ie movable) list to pass to paintComponent
		drawable = new ArrayList<MovableObject>();
		drawable.addAll(offense.getPlayers());
		drawable.addAll(defense.getPlayers());

		// We can set this to false and call the processPlay when the GUI start button is pressed
		paused = true;
		thrown = false;

		loopCounter = 0;
		
		//This one determines if the current play is over, ie the ball carrier was tackled
		playOver = false;
	}

	public void initGui() {
		this.setSize(DEFAULT_SIZE_X, DEFAULT_SIZE_Y);
		// instantiate gui components

		field = new Field(this, DEFAULT_SIZE_X - DEFAULT_SIDEBAR_X, DEFAULT_SIZE_Y);
		sideBar = new SideBar(this, DEFAULT_SIDEBAR_X, DEFAULT_SIZE_Y);
		
		this.add(sideBar, BorderLayout.WEST);
		this.add(field, BorderLayout.CENTER);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void reset() {
		if (paused == false) {
			sideBar.toggle();
		}
		offense = new Team(true, this);
		defense = new Team(false, this);
		drawable = new ArrayList<MovableObject>();
		drawable.addAll(offense.getPlayers());
		drawable.addAll(defense.getPlayers());
		thrown = false;
		playOver = false;
		loopCounter = 0;
		sideBar.refreshPlayChoice();
		sideBar.updateMessage(sideBar.getDEFAULT_MESSAGE());
		repaint();
	}

	
	public void processPlay() {
		/**
		 * This function will step through the play
		 * 1) Find best direction for players
		 * 2) Move them accordingly
		 */

		
		if (!playOver) {
			sideBar.updateMessage("Play in progress");

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

			//This loop is for catching the ball.  Offense gets the heads up once again.  The catch function
			// takes care of setting hasBall correctly for each player
			if (ball != null) {
				//Offense
				for (Player p : offense.getPlayers()) {
					if (p.catchBall(ball)) {
						drawable.remove(ball);
						ball = null;
					}
				}
				//Defense
				for (Player p : defense.getPlayers()) {
					if (p.catchBall(ball)) {
						drawable.remove(ball);
						ball = null;
						playOver = true;
					}
				}
			}

			
			// add some randomness to mix up the throw length
			Random generator = new Random();
			int randomness = generator.nextInt(30);
			// Need to have loop counter reset and thrown set back to false when a new play is selected
			if(loopCounter > (THROW_COUNT + randomness)) {
				sideBar.updateMessage("Ball is thrown");
				if(!thrown) {
					thrown = true;
					// Cast to reference the QB
					QuarterBack qb = (QuarterBack) offense.getPlayers().get(QB_INDEX);

					// Sets up the target accordingly to an open receiver
					ball = qb.throwBall(offense);
					// Now the ball can be drawn if it was thrown.  A null bull means the QB is running it
					if (ball != null) {
						drawable.add(ball);
					}
				}
				//Update ball location
				if (ball != null) {
					Vector2D ballDirection = new Vector2D();
					Vector2D ballTarget = ball.getTargetLocation();
					Vector2D ballLocation = ball.getLocation();

					ballDirection.x = ballTarget.x - ballLocation.x;
					ballDirection.y = ballTarget.y - ballLocation.y;

					//Test if the ball is at it's target, an incomplete pass
					if (ballDirection.getMagnitude() < ball.getCatchRadius()/4) {
						playOver = true;
						sideBar.updateMessage("Ball hit the ground");
					}

					ball.move(ballDirection, ball.getSpeed());
				}
				if (caught) {
					sideBar.updateMessage("Ball is caught");
				}
			}

			
			// increment the loop count toward ball throwing time
			loopCounter++;
		}

	}
	
	public boolean checkForEdge(Player p) {
		int borderDistance = 10;
		if (p.getLocation().x < 0 + borderDistance || p.getLocation().y > DEFAULT_SIZE_X - DEFAULT_SIDEBAR_X - borderDistance) {
			return true;
		}
		return false;
	}

	// this function loops over all other players to determine which direction the passed player should move
	// it then returns that direction so it can be passed to the move function of player p
	public Vector2D findBestDirection(Player p, boolean isOffense) {
		Vector2D distance = null;
		Vector2D netDirection = new Vector2D(0,0);
		ArrayList<Player> otherPlayers;

		if (checkForEdge(p)) {
			if (isOffense) {
				return new Vector2D(0, -1);
			} else {
				return new Vector2D(0, 1);
			}
		}
		
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
					netDirection.x -= 6*distance.getUnitVector().x;
					netDirection.y -= 6*distance.getUnitVector().y;
				}
			}
			else {
				// COLLISION
				// call a collision function which will sometimes stop the player's movement, sometimes let them through
				// if the collision involves a player that has the ball, the play should end

				p.setIsOpen(false);

				if (blocked()) {

					// play ends if player that has ball is tackled
					if (p.isHasBall()) {
						playOver = true;
						sideBar.updateMessage("Tackle is Made. Reset the teams.");
					}

					// return zero for direction so player doesn't move
					return new Vector2D(0,.01);


				} 
				else {
					// made it through the collision, continue on desired route
					// this can be changed as needed depending on how it makes players move once
					// we see it in action
					netDirection.x += p.getDirection().getUnitVector().x;
					netDirection.y += p.getDirection().getUnitVector().y;
				}

			}
			
			// Modify routes once ball is caught
			if (caught) {
				// set direction towards the ball carrier
				if (p.isHasBall()) {
					return new Vector2D(0, -1);
				} else if (player.isHasBall()){
					// go towards the ball carrier
					netDirection.x = player.getLocation().x - p.getLocation().x;
					netDirection.y = player.getLocation().y - p.getLocation().y;
					return netDirection;
				}
			}
		}
		
	
		return netDirection;
	}


	// this can be called when the user selects new play options from the combo boxes on the GUI
	// the team loadPlay functions will initialize all positions and directions
	public void loadPlayConfig(String defensePlay, String offensePlay) {
		offense.loadPlay(offensePlay);
		defense.loadPlay(defensePlay);
		//repaint is here to update locations and draw the route lines
		repaint();
	}

	// This function just decides if the player gets through or not
	public boolean blocked() {
		Random generator = new Random();
		int chance = generator.nextInt(10);
		if (chance < 4)
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
				//moved loopCounter addition here since it used to keep getting reset by
				// the beginning of processPlay().  Leave it here
				loopCounter++;
				processPlay();
				repaint();
			}
		};

		animationTimer = new Timer(100, actionTimer);
	}

	/*
	 * Getters and Setters
	 */

	public ArrayList<MovableObject> getDrawable() {
		return drawable;
	}
	
	public void setDrawable(ArrayList<MovableObject> d) {
		drawable = d;
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
		return paused;
	}

	public void setLoopCounter(int num) {
		loopCounter = num;
	}

	public void setThrown(boolean b) {
		thrown = b;
	}
	

	public void resetBall() {
		drawable.remove(ball);
		for(Player player: offense.getPlayers()){
			player.hasBall = false;
		}
		for(Player player: defense.getPlayers()){
			player.hasBall = false;
		}
		offense.getPlayers().get(QB_INDEX).hasBall = true;
		ball = null;
	}

	public void setPlayOver(boolean b) {
		playOver = b;
	}
	
	public boolean getPaused() {
		return paused;
	}
	
	public SideBar getSideBar() {
		return sideBar;
	}
	
	public void setCaught(boolean value) {
		caught = value;
	}

	public void flipPaused() {
		// also start and stop the timer
		if (paused == true) {
			animationTimer.start();
			paused = false;
		} else {
			animationTimer.stop();
			paused = true;
			sideBar.updateMessage("Paused");
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
