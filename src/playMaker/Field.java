package playMaker;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Field extends JPanel{
	private PlayMaker playMaker;
	
	public Field(PlayMaker playMaker) {
		this.playMaker = playMaker;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paint green background, field lines, then loop through offense and defense to call
		// their draw functions
	}
	
	
}
