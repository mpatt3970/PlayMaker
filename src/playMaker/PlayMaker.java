package playMaker;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayMaker extends JFrame {
	
	private JPanel sideBar;
	private JPanel field;
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
	
	PlayMaker() {
		
	}
	
	public void processPlay() {
		/**
		 * This function will step through the play
		 * 1) Moving all players
		 * 2) Repainting
		 */
		

	}
	
	
	private static void main(String[] args0) {
		PlayMaker gui = new PlayMaker();
		gui.setVisible(true);
	}
}
