package playMaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

public class Field extends JComponent {
	// Chose these numbers becuase the field is about 50 wide and the length we will show is 25 yards.
	// I don't enforce this ratio above these sizes though
	private final int MIN_X = 150;
	private final int MIN_Y = 300;
	private int sizeX, sizeY;

	private PlayMaker playMaker;

	public Field(PlayMaker playMaker, int x, int y) {
		this.playMaker = playMaker;
		this.sizeX = x;
		this.sizeY = y;
		// add a listener for resizing
		addComponentListener(new SizeAdapter(this));
		// add a repaint Thread
		addThread();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw the background
		g.setColor(Color.green);
		g.fillRect(0, 0, sizeX, sizeY);
		drawLines(g);
		// draw each drawableObject on each team
		for (MovableObject toDraw : playMaker.getDrawable()) {
			toDraw.draw(g);
		}
	}

	public void addThread() {
		// I think this will help for animation purposes.
		// Thank you Vulcan for http://stackoverflow.com/questions/10535061/jpanel-is-not-refreshing-until-i-resize-the-app-window
		Thread repainter = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) { 
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException ignored) {
					}
				}
			}
		});
		repainter.setName("Panel repaint");
		repainter.setPriority(Thread.MIN_PRIORITY);
		repainter.start();
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

	private class SizeAdapter extends ComponentAdapter {
		// A private class in charge of resizing the field when the window is resized.
		private JComponent parent;

		public SizeAdapter(JComponent parent) {
			this.parent = parent;	
		}

		@Override
		public void componentResized(ComponentEvent e) {
			// When the size changes, update the sizeX and sizeY, then repaint
			int prevX = sizeX;
			int prevY = sizeY;
			sizeX = parent.getWidth();
			sizeY = parent.getHeight();
			// Restore sizes if below 150 by 300
			if (sizeX < MIN_X)
				sizeX = prevX;
			if (sizeY < MIN_Y)
				sizeY = prevY;
			repaint();
		}
	}


}
