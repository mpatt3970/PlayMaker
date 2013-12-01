package playMaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Receiver extends Player {
	// I figure the running back can be represented as a receiver
	
	public Receiver(Vector2D location, Team team, PlayMaker playMaker) {
		super(location, team, playMaker);
		this.speed = 4;
		this.hasBall = false;
	}
	
	public void drawRoute(Graphics g) {
		int lx = (int)this.getInitialLocation().x + 15;
		int ly = (int)this.getInitialLocation().y + 20;
		int x1 = (int)((double)this.getRouteDirection1().getUnitVector().x*getRouteUpdateDistance());
		int y1 = (int)((double)this.getRouteDirection1().getUnitVector().y*getRouteUpdateDistance());
		int x2 = (int)((double)this.getRouteDirection2().getUnitVector().x*getRouteUpdateDistance());
		int y2 = (int)((double)this.getRouteDirection2().getUnitVector().y*getRouteUpdateDistance());
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));
		g.drawLine(lx, ly, x1 + lx, y1 + ly);
		
		g.drawLine(
				x1 + lx, 
				y1 + ly, 
				x2 + x1 + lx, 
				y2 + y1 + ly);
		
		//g.drawRect(x2 + x1 + lx, y2 + y1 + ly, 5 , 5);
	}
}
