package test;

import static org.junit.Assert.*;

import java.awt.Point;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import playMaker.Ball;
import playMaker.Blocker;
import playMaker.Defender;
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
		
		// ball movement speed, adjustable as needed
		int speed = 10;
		
		// test players move
		for (Player p : playMaker.getOffense().getPlayers()) {
			current = p.getLocation();
			p.move(new Point(100,100),p.getSpeed());
			assertFalse(p.getLocation().equals(current));
		}
		
		// test ball moves but does not change its target
		current = ball.getCurrentLocation();
		target = ball.getTargetLocation();
		ball.move(target,5);
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
		fail("not implemented");
	}
	
	@Test
	public void testLoadDefense() {
		// test that the defense gets initialized correctly
		int defenderCount = 0;
		int blockerCount = 0;
		int otherCount = 0;
		
		// test that no defender gets the ball initially
		for (Player p : playMaker.getDefense().getPlayers()) {
			assertFalse(p.isHasBall());
		}
		// make sure defense has only defenders and blockers
		for (Player p : playMaker.getDefense().getPlayers()) {
			if (p instanceof Defender)
				defenderCount++;
			if (p instanceof Blocker)
				blockerCount++;
			else
				otherCount++;
		}
		assertTrue(defenderCount > 0);
		assertTrue(blockerCount > 0);
		assertTrue(otherCount == 0);
	}
	
	@Test
	public void testCollisionDetection() {
		// test to check if 2 players in the same place is detected
		fail("not implemented");
	}
	
	@Test
	public void testBlocking() {
		// test that block stops movement and sometimes lets the person through
		int blockCount = 0;
		int failCount = 0;
		boolean block;
		
		for (int i = 0; i < 100; i++) {
			block = playMaker.blocked();
			if (block)
				blockCount++;
			else
				failCount++;
		}
		
		assertTrue(blockCount > 10);
		assertTrue(failCount > 10);
	}
	
	@Test
	public void testStartPlay() {
		// test for 2 teams, a hiked ball, and players starting to move simultaneously
		fail("not implemented");
	}

}
