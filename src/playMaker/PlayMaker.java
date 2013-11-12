package playMaker;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayMaker extends JFrame {
	
	private JPanel sideBar;
	private JPanel field;
	
	private Team offense;
	private Team defense;
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
	
	public PlayMaker() {
		offense = new Team();
		defense = new Team();
	}
	
	public void processPlay() {
		/**
		 * This function will step through the play
		 * 1) Moving all players
		 * 2) Repainting
		 */
		
		// this handles players making appropriate movement direction choices
		// offensive moves first since they know their route, defense is trying to compensate afterwords
		for (Player p : offense.getPlayers()) {
			Point direction = findBestDirection(p,true);
			p.move(direction, p.getSpeed());
		}
		for (Player p : defense.getPlayers()) {
			Point direction = findBestDirection(p,false);
			p.move(direction, p.getSpeed());
		}
		
		// repaint now that all players have new locations
		repaint();
		

	}
	
	public Point findBestDirection(Player player, boolean isOffense) {
		// this function loops over all other players to determine which direction the passed player should move
		// it then returns that direction so it can be passed to the move function of player p
		if (isOffense) {
			// offensive players care about avoiding defensive players
			for (Player p : defense.getPlayers()) {
				Point distance = null;
				// find distance between, find magnitude of that distance, determine if player should continue on their
				// local direction, or return the better direction to be used in the move function
			}
		}
		else {
			// defensive players care about tackling offensive
			for (Player p : offense.getPlayers()) {
				Point distance = null;
				// find distance between, find magnitude of that distance, determine if player should continue on their
				// local direction, or return the better direction to be used in the move function
			}
		}
		
		return null;
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

	/*
	 * 
	 */
	
	private static void main(String[] args0) {
		PlayMaker gui = new PlayMaker();
		gui.setVisible(true);
	}
}
