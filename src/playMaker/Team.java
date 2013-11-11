package playMaker;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> players;
	
	public Team() {
		players = new ArrayList<Player>();
		
	}
	
	public void loadPlay(String fileName) {
		// probably get the current selection from a combo box, load a config file with that fileName, initialize two teams...
		// button listener will pass the correct file name to this function
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
