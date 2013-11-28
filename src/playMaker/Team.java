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
		isOffense = offense;
		players = new ArrayList<Player>();
		if (isOffense) {
			// add QB and receivers and such to array
			players.add(new Receiver(5, false, new Vector2D(100, 300), this));
			players.add(new Receiver(5, false, new Vector2D(300, 370), this));
			players.add(new Blocker(1, false, new Vector2D(250, 300), this));
			players.add(new Blocker(1, false, new Vector2D(300, 300), this));
			//Center
			players.add(new Blocker(1, false, new Vector2D(350, 300), this));
			players.add(new QuarterBack(3, true, new Vector2D(350, 330), this));
			players.add(new Blocker(1, false, new Vector2D(400, 300), this));
			players.add(new Blocker(1, false, new Vector2D(450, 300), this));
			//Tight end is a lil' faster
			players.add(new Blocker(2, false, new Vector2D(500, 320), this));
			players.add(new Receiver(5, false, new Vector2D(350, 420), this));
			players.add(new Receiver(5, false, new Vector2D(600, 300), this));


			// for testing drawing
			// players.add(new QuarterBack(0, true, new Vector2D(150, 150), this));

		}
		else {
			// add defenders and such to array
			players.add(new Defender(5, false, new Vector2D(100, 230), this));
			players.add(new Blocker(1, false, new Vector2D(220, 240), this));
			players.add(new Defender(5, false, new Vector2D(255, 130), this));
			players.add(new Defender(5, false, new Vector2D(265, 210), this));
			players.add(new Blocker(1, false, new Vector2D(310, 240), this));
			players.add(new Defender(5, false, new Vector2D(350, 200), this));
			players.add(new Blocker(1, false, new Vector2D(390, 240), this));
			players.add(new Defender(5, false, new Vector2D(435, 210), this));
			players.add(new Defender(5, false, new Vector2D(445, 150), this));
			players.add(new Blocker(1, false, new Vector2D(480, 240), this));
			players.add(new Defender(5, false, new Vector2D(600, 230), this));

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
					current.setRouteDirection1(new Vector2D(.5,-.5));
					break;
				case 3:
					current.setRouteDirection1(new Vector2D(0,-1));
					break;
				case 4:
					current.setRouteDirection1(new Vector2D(-.5,-.5));
					break;
				case 5:
					current.setRouteDirection1(new Vector2D(-1,0));
					break;
				case 6:
					current.setRouteDirection1(new Vector2D(-.5,.5));
					break;
				case 7:
					current.setRouteDirection1(new Vector2D(0,1));
					break;
				case 8:
					current.setRouteDirection1(new Vector2D(.5,.5));
					break;	
				case 9:
					current.setRouteDirection1(new Vector2D(0,.01));
					break;
				}

				switch(direction2) {
				case 1:
					current.setRouteDirection2(new Vector2D(1,0));
					break;
				case 2:
					current.setRouteDirection2(new Vector2D(.5,-.5));
					break;
				case 3:
					current.setRouteDirection2(new Vector2D(0,-1));
					break;
				case 4:
					current.setRouteDirection2(new Vector2D(-.5,-.5));
					break;
				case 5:
					current.setRouteDirection2(new Vector2D(-1,0));
					break;
				case 6:
					current.setRouteDirection2(new Vector2D(-.5,.5));
					break;
				case 7:
					current.setRouteDirection2(new Vector2D(0,1));
					break;
				case 8:
					current.setRouteDirection2(new Vector2D(.5,.5));
					break;	
				case 9:
					current.setRouteDirection1(new Vector2D(0,.01));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//As coded now 1 = -> and then counter clockwise at 45 degree amounts(like the unit circle)


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
