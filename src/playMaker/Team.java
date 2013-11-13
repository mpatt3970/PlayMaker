package playMaker;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> players;
	
	/**
	 * We could also make this an abstract class and make child classes of OffensiveTeam
	 * and DefensiveTeam and have their constructors initialize the correct player types
	 * instead of passing in a boolean to the team constructor.
	 * 
	 */
	
	public Team(boolean isOffense) {
		players = new ArrayList<Player>();
		if (isOffense) {
			// add QB and receivers and such to array
		}
		else {
			// add blockers and such to array
		}
	}
	
	public void loadPlay(String fileName) {
		// probably get the current selection from a combo box, load a config file with that fileName,
		// initialize the players with their locations and directions
		
		// button listener will pass the correct file name to this function
		
		/**
		 * I'm thinking the config files could look like 
		 * (xLocation,yLocation),(xDirection1,yDirection1),(xDirection2,yDirection2),(xLocation,yLocation),(...
		 * and we could read in the current location and direction like that
		 */
	}
	
	public void hike() {
		// when the user clicks run
	}

	/*
	 * Getters and Setters
	 */
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
}
