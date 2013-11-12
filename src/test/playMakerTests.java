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
			p.move(new Point(100,100),p.getSpeed());
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
		int offenseTotal = 11;
		int defenseTotal = 11;
		assertEquals(offenseTotal, playMaker.getOffense().getPlayers().size());
		assertEquals(defenseTotal, playMaker.getDefense().getPlayers().size());
	}
	
	@Test
	public void testLoadPlay() {
		// test that the load functions initializes some values correctly
		
	}
	
	@Test
	public void testLoadDefense() {
		// test that the defense gets initialized correctly
		
	}
	
	@Test
	public void testCollisionDetection() {
		// test to check if 2 players in the same place is detected
		// moving a player returns a boolean value. true if the move was successful and false if there is already a player there or the move fails
		// put an offensive player at 10, 10. should return true. noone is in that square
		assertTrue(playMaker.getOffense().getPlayers().get(0).setLocation(new Point(10, 10)));
		// attempt to move a defensive player to 10, 10. should retrun false.
		assertFalse(playMaker.getDefense().getPlayers().get(0).setLocation(new Point(10, 10)));
	}
	
	@Test
	public void testStartPlay() {
		// test for 2 teams, a hiked ball, and players starting to move simultaneously
		
	}

}
