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
		this.speed = 3;
		this.hasBall = false;
	}
	
	
}
