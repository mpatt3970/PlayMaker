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

	public Team(boolean offense, PlayMaker playMaker) {
		isOffense = offense;
		players = new ArrayList<Player>();
		if (isOffense) {
			// add QB and receivers and such to array
			players.add(new Receiver(new Vector2D(100, 300), this, playMaker));
			players.add(new Receiver(new Vector2D(300, 370), this, playMaker));
			players.add(new Blocker(new Vector2D(250, 300), this, playMaker));
			players.add(new Blocker(new Vector2D(300, 300), this, playMaker));
			//Center
			players.add(new Blocker(new Vector2D(350, 300), this, playMaker));
			players.add(new QuarterBack(new Vector2D(350, 330), this, playMaker));
			players.add(new Blocker(new Vector2D(400, 300), this, playMaker));
			players.add(new Blocker(new Vector2D(450, 300), this, playMaker));
			//Tight end is a lil' faster
			players.add(new Blocker(new Vector2D(500, 320), this, playMaker));
			players.add(new Receiver(new Vector2D(350, 420), this, playMaker));
			players.add(new Receiver(new Vector2D(600, 300), this, playMaker));


		}
		else {
			// add defenders and such to array
			players.add(new Defender(new Vector2D(100, 230), this, playMaker));
			players.add(new Blocker(new Vector2D(220, 240), this, playMaker));
			players.add(new Defender(new Vector2D(255, 130), this, playMaker));
			players.add(new Defender(new Vector2D(265, 210), this, playMaker));
			players.add(new Blocker(new Vector2D(310, 240), this, playMaker));
			players.add(new Defender(new Vector2D(350, 200), this, playMaker));
			players.add(new Blocker(new Vector2D(390, 240), this, playMaker));
			players.add(new Defender(new Vector2D(435, 210), this, playMaker));
			players.add(new Defender(new Vector2D(445, 150), this, playMaker));
			players.add(new Blocker(new Vector2D(480, 240), this, playMaker));
			players.add(new Defender(new Vector2D(600, 230), this, playMaker));


		}
	}

	public void loadDefaultFormation(boolean offense) {
		if (offense) {
			players.get(0).setAbsoluteLocation(new Vector2D(100,300));
			players.get(1).setAbsoluteLocation(new Vector2D(300,370));
			players.get(2).setAbsoluteLocation(new Vector2D(250,300));
			players.get(3).setAbsoluteLocation(new Vector2D(300,300));
			players.get(4).setAbsoluteLocation(new Vector2D(350,300));
			players.get(5).setAbsoluteLocation(new Vector2D(350,330));
			players.get(6).setAbsoluteLocation(new Vector2D(400,300));
			players.get(7).setAbsoluteLocation(new Vector2D(450,300));
			players.get(8).setAbsoluteLocation(new Vector2D(500,320));
			players.get(9).setAbsoluteLocation(new Vector2D(350,420));
			players.get(10).setAbsoluteLocation(new Vector2D(600,300));
		} else {
			// this happens to be 4-3 for defense
			players.get(0).setAbsoluteLocation(new Vector2D(100,230));
			players.get(1).setAbsoluteLocation(new Vector2D(220,240));
			players.get(2).setAbsoluteLocation(new Vector2D(255,130));
			players.get(3).setAbsoluteLocation(new Vector2D(265,210));
			players.get(4).setAbsoluteLocation(new Vector2D(310,240));
			players.get(5).setAbsoluteLocation(new Vector2D(350,200));
			players.get(6).setAbsoluteLocation(new Vector2D(390,240));
			players.get(7).setAbsoluteLocation(new Vector2D(435,210));
			players.get(8).setAbsoluteLocation(new Vector2D(445,150));
			players.get(9).setAbsoluteLocation(new Vector2D(480,240));
			players.get(10).setAbsoluteLocation(new Vector2D(600,230));
		}
	}

	//loads four three defense
	public void loadFourThree() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,230));
		players.get(1).setAbsoluteLocation(new Vector2D(220,240));
		players.get(2).setAbsoluteLocation(new Vector2D(255,130));
		players.get(3).setAbsoluteLocation(new Vector2D(265,210));
		players.get(4).setAbsoluteLocation(new Vector2D(310,240));
		players.get(5).setAbsoluteLocation(new Vector2D(350,200));
		players.get(6).setAbsoluteLocation(new Vector2D(390,240));
		players.get(7).setAbsoluteLocation(new Vector2D(435,210));
		players.get(8).setAbsoluteLocation(new Vector2D(445,150));
		players.get(9).setAbsoluteLocation(new Vector2D(480,240));
		players.get(10).setAbsoluteLocation(new Vector2D(600,230));
	}

	// defense formation
	public void loadFiveTwo() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,230));
		players.get(1).setAbsoluteLocation(new Vector2D(300,200));
		players.get(2).setAbsoluteLocation(new Vector2D(255,130));
		players.get(3).setAbsoluteLocation(new Vector2D(220,260));
		players.get(4).setAbsoluteLocation(new Vector2D(280,240));
		players.get(5).setAbsoluteLocation(new Vector2D(350,240));
		players.get(6).setAbsoluteLocation(new Vector2D(420,240));
		players.get(7).setAbsoluteLocation(new Vector2D(480,260));
		players.get(8).setAbsoluteLocation(new Vector2D(445,130));
		players.get(9).setAbsoluteLocation(new Vector2D(400,200));
		players.get(10).setAbsoluteLocation(new Vector2D(600,230));
	}
	//defense
	public void loadThreeFour() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,230));
		players.get(1).setAbsoluteLocation(new Vector2D(220,240));
		players.get(2).setAbsoluteLocation(new Vector2D(255,130));
		players.get(3).setAbsoluteLocation(new Vector2D(265,210));
		players.get(4).setAbsoluteLocation(new Vector2D(320,200));
		players.get(5).setAbsoluteLocation(new Vector2D(400,200));
		players.get(6).setAbsoluteLocation(new Vector2D(360,240));
		players.get(7).setAbsoluteLocation(new Vector2D(435,210));
		players.get(8).setAbsoluteLocation(new Vector2D(445,150));
		players.get(9).setAbsoluteLocation(new Vector2D(480,240));
		players.get(10).setAbsoluteLocation(new Vector2D(600,230));
	}
	
	
	//offensive formations
	public void loadShotgun() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,300));
		players.get(1).setAbsoluteLocation(new Vector2D(130,310));
		players.get(2).setAbsoluteLocation(new Vector2D(250,300));
		players.get(3).setAbsoluteLocation(new Vector2D(300,300));
		players.get(4).setAbsoluteLocation(new Vector2D(350,300));
		players.get(5).setAbsoluteLocation(new Vector2D(350,380));
		players.get(6).setAbsoluteLocation(new Vector2D(400,300));
		players.get(7).setAbsoluteLocation(new Vector2D(450,300));
		players.get(8).setAbsoluteLocation(new Vector2D(500,320));
		players.get(9).setAbsoluteLocation(new Vector2D(370,360));
		players.get(10).setAbsoluteLocation(new Vector2D(600,300));
	}
	
	public void loadProset() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,300));
		players.get(1).setAbsoluteLocation(new Vector2D(300,370));
		players.get(2).setAbsoluteLocation(new Vector2D(250,300));
		players.get(3).setAbsoluteLocation(new Vector2D(300,300));
		players.get(4).setAbsoluteLocation(new Vector2D(350,300));
		players.get(5).setAbsoluteLocation(new Vector2D(350,330));
		players.get(6).setAbsoluteLocation(new Vector2D(400,300));
		players.get(7).setAbsoluteLocation(new Vector2D(450,300));
		players.get(8).setAbsoluteLocation(new Vector2D(500,320));
		players.get(9).setAbsoluteLocation(new Vector2D(400,370));
		players.get(10).setAbsoluteLocation(new Vector2D(600,300));
	}
	
	public void loadIFormation() {
		players.get(0).setAbsoluteLocation(new Vector2D(100,300));
		players.get(1).setAbsoluteLocation(new Vector2D(350,390));
		players.get(2).setAbsoluteLocation(new Vector2D(250,300));
		players.get(3).setAbsoluteLocation(new Vector2D(300,300));
		players.get(4).setAbsoluteLocation(new Vector2D(350,300));
		players.get(5).setAbsoluteLocation(new Vector2D(350,320));
		players.get(6).setAbsoluteLocation(new Vector2D(400,300));
		players.get(7).setAbsoluteLocation(new Vector2D(450,300));
		players.get(8).setAbsoluteLocation(new Vector2D(500,320));
		players.get(9).setAbsoluteLocation(new Vector2D(350,360));
		players.get(10).setAbsoluteLocation(new Vector2D(600,300));
	}
	
	
	//The passed name just routes the function to the correct version
	public void loadFormation(String name) {
		//Default
		if (name.equalsIgnoreCase("Default")) {
			loadDefaultFormation(isOffense);
		}
		//Add others here and call there functions
		else if (name.equalsIgnoreCase("4-3")) {
			loadFourThree();
		}
		else if (name.equalsIgnoreCase("5-2")) {
			loadFiveTwo();
		}
		else if (name.equalsIgnoreCase("3-4")) {
			loadThreeFour();
		}
		else if (name.equalsIgnoreCase("Shotgun")) {
			loadShotgun();
		}
		else if (name.equalsIgnoreCase("Proset")) {
			loadProset();
		}
		else if (name.equalsIgnoreCase("IFormation")) {
			loadIFormation();
		}
		else {
			loadDefaultFormation(isOffense);
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
				//first line is the formation
				loadFormation(scanner.nextLine());
				//now load routes
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
						current.setRouteDirection2(new Vector2D(0,.01));
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
