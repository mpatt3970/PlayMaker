package test;

import static org.junit.Assert.*;

import java.awt.Point;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import playMaker.Ball;
import playMaker.PlayMaker;
import playMaker.Player;

public class playMakerTests {
	PlayMaker playMaker;
	Ball ball;
	
	@Before
	public void setUp() {
		PlayMaker playMaker = new PlayMaker();
		Ball ball = new Ball(new Point(50,50), new Point(100,100));
	}

	@Test
	public void testMoveFunctions() {
		Point current;
		Point target;
		
		// test players move
		for (Player p : playMaker.getOffense().getPlayers()) {
			current = p.getLocation();
			p.move();
			assertFalse(p.getLocation().equals(current));
		}
		
		// test ball moves but does not change its target
		current = ball.getCurrentLocation();
		target = ball.getTargetLocation();
		ball.move();
		assertFalse(ball.getCurrentLocation().equals(current));
		assertTrue(ball.getTargetLocation().equals(target));
	}
	
	@Test
	public void testFullTeams() {
		// test if each team has 11 players.
		
	}
	
	@Test
	public void testLoadPlay() {
		// test that the load functions initialize some values correctly
		
	}
	
	@Test
	public void testLoadDefense() {
		// test that the defense gets initialized correctly
		
	}
	
	@Test
	public void testCollisionDetection() {
		// test to check if 2 players in the same place is detected
		
	}
	
	@Test
	public void testStartPlay() {
		// test for 2 teams, a hiked ball, and players starting to move simultaneously
		
	}

}
