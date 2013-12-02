package playMaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

public class Field extends JComponent {
	// Chose these numbers because the field is about 50 wide and the length we will show is 25 yards.
	// I don't enforce this ratio above these sizes though
	private final int MIN_X = 150;
	private final int MIN_Y = 300;
	private int sizeX, sizeY;

	private PlayMaker playMaker;
	private boolean selected;
	private boolean first;

	public Field(PlayMaker playMaker, int x, int y) {
		this.playMaker = playMaker;
		this.sizeX = x;
		this.sizeY = y;
		this.selected = true;
		this.first = true;
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw the background
		g.setColor(Color.green);
		g.fillRect(0, 0, sizeX, sizeY);
		drawLines(g);
		drawRoutes(g);
		// draw each drawableObject on each team
		for (MovableObject toDraw : playMaker.getDrawable()) {
			toDraw.draw(g);
		}
	}

	public void drawLines(Graphics g) {
		// draw some fieldlines
		// for a 25 yard section, there are 4 lines, and 5 spaces
		int length = sizeY/5;
		for (int currentY = 0; currentY < sizeY; currentY += length) {
			g.setColor(Color.white);
			g.drawLine(0, currentY, sizeX, currentY);
		}
	}



	public void drawRoutes(Graphics g) {
		g.setColor(Color.BLUE);
		for(Player p : playMaker.getOffense().getPlayers()) {
			if(p.getClass() == Receiver.class || p.getClass() == QuarterBack.class) {
				p.drawRoute(g);
			}
		}
	}



	public void setSelected(boolean b) {
		selected = b;
	}
}
