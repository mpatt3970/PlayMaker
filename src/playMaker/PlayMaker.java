package playMaker;

import java.awt.Graphics;

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
