package playMaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Receiver extends Player {
	// I figure the running back can be represented as a receiver
	
	public Receiver(int speed, boolean hasBall, Vector2D location, Team team) {
		super(speed,hasBall,location, team);
	}

	public void drawRoute(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(
				(int)this.getInitialLocation().x, 
				(int)this.getInitialLocation().y, 
				(int)((double)this.getRouteDirection1().x*50) + (int)this.getInitialLocation().x, 
				(int)((double)this.getRouteDirection1().y*50) + (int)this.getInitialLocation().y);
		g.drawRect(
				(int)((double)this.getRouteDirection1().x*50) + (int)this.getInitialLocation().x, 
				(int)((double)this.getRouteDirection1().y*50) + (int)this.getInitialLocation().y, 4, 4);
		g.drawLine(
				(int)this.getInitialLocation().x + (int)((double)this.getRouteDirection1().x*50), 
				(int)this.getInitialLocation().y + (int)((double)this.getRouteDirection1().y*50), 
				(int)((double)this.getRouteDirection2().x*50) + (int)this.getInitialLocation().x + (int)((double)this.getRouteDirection1().x*50), 
				(int)((double)this.getRouteDirection2().y*50) + (int)this.getInitialLocation().y + (int)((double)this.getRouteDirection1().y*50));
		g.drawRect(
				(int)((double)this.getRouteDirection2().x*50) + (int)this.getInitialLocation().x + (int)((double)this.getRouteDirection1().x*50), 
				(int)((double)this.getRouteDirection2().y*50) + (int)this.getInitialLocation().y + (int)((double)this.getRouteDirection1().y*50), 4, 4);
	}
}
