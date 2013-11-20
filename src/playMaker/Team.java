package playMaker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	
	private ArrayList<Player> players;
	private boolean isOffense;
	
	/**
	 * We could also make this an abstract class and make child classes of OffensiveTeam
	 * and DefensiveTeam and have their constructors initialize the correct player types
	 * instead of passing in a boolean to the team constructor.
	 * 
	 */
	
	public Team(boolean offense) {
		this.isOffense = offense;
		players = new ArrayList<Player>();
		if (isOffense) {
			isOffense = true;
			// add QB and receivers and such to array
			
			// for testing drawing
			//players.add(new QuarterBack(0, true, new Vector2D(150, 150), this));
			
		}
		else {
			isOffense = false;
			// add defenders and such to array
			
			// for testing drawing
			//players.add(new Defender(0, false, new Vector2D(200, 150), this));
			
		}
	}
	
	public void loadPlay(String fileName) {
		// probably get the current selection from a combo box, load a config file with that fileName,
		// initialize the players with their locations and directions
		
		// button listener will pass the correct file name to this function
		Scanner scanner;
		try {
			FileReader reader = new FileReader(fileName);
			scanner = new Scanner(reader);
			for (Player current : players){
				int direction = scanner.nextInt();
				int direction2 = scanner.nextInt();
				switch(direction) {
				case 1:
					current.setRouteDirection1(new Vector2D(1,0));
					break;
				case 2:
					current.setRouteDirection1(new Vector2D(.5,.5));
					break;
				case 3:
					current.setRouteDirection1(new Vector2D(0,1));
					break;
				case 4:
					current.setRouteDirection1(new Vector2D(-.5,.5));
					break;
				case 5:
					current.setRouteDirection1(new Vector2D(-1,0));
					break;
				case 6:
					current.setRouteDirection1(new Vector2D(-.5,-.5));
					break;
				case 7:
					current.setRouteDirection1(new Vector2D(0,-1));
					break;
				case 8:
					current.setRouteDirection1(new Vector2D(.5,-.5));
					break;	
				}
				
				switch(direction2) {
				case 1:
					current.setRouteDirection1(new Vector2D(1,0));
					break;
				case 2:
					current.setRouteDirection1(new Vector2D(.5,.5));
					break;
				case 3:
					current.setRouteDirection1(new Vector2D(0,1));
					break;
				case 4:
					current.setRouteDirection1(new Vector2D(-.5,.5));
					break;
				case 5:
					current.setRouteDirection1(new Vector2D(-1,0));
					break;
				case 6:
					current.setRouteDirection1(new Vector2D(-.5,-.5));
					break;
				case 7:
					current.setRouteDirection1(new Vector2D(0,-1));
					break;
				case 8:
					current.setRouteDirection1(new Vector2D(.5,-.5));
					break;	
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/**
		 * I'm thinking the config files could look like 
		 * (xLocation,yLocation),(xDirection1,yDirection1),(xDirection2,yDirection2),
		 * (xLocation,yLocation),(...
		 * and we could read in the current location and direction like that
		 */
	}
	
	public void hike() {
		// when the user clicks run
	}

	/*
	 * Getters and Setters
	 */
	
	public boolean isOffense() {
		return isOffense;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
}
