package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import playMaker.Ball;
import playMaker.Blocker;
import playMaker.Defender;
import playMaker.PlayMaker;
import playMaker.Player;
import playMaker.Receiver;
import playMaker.Team;

public class playMakerTests {
	PlayMaker playMaker;
	Ball ball;
	
	@Before
	public void setUp() {
		playMaker = new PlayMaker();
		ball = new Ball(new Point(50,50), new Point(100,100));
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
		playMaker.loadPlayConfig("testOffensePlay.txt", "testDefensePlay.txt");
		
		assertTrue(playMaker.getOffense().getPlayers().size() > 0);
		assertTrue(playMaker.getDefense().getPlayers().size() > 0);
		
		
		// the test plays will just line every player up horizontally, 50 pixels apart, and everyone head up/down
		// and then left/right
		for (int i = 0; i < playMaker.getOffense().getPlayers().size(); i++) {
			assertEquals(50*(i+1),playMaker.getOffense().getPlayers().get(i).getLocation().x);
			assertEquals(200,playMaker.getOffense().getPlayers().get(i).getLocation().y);
			assertTrue(playMaker.getOffense().getPlayers().get(i).getRouteDirection1().equals(new Point(0,-1)));
			assertTrue(playMaker.getOffense().getPlayers().get(i).getRouteDirection2().equals(new Point(1,0)));
		}
		// defense testing
		for (int i = 0; i < playMaker.getOffense().getPlayers().size(); i++) {
			assertEquals(50*(i+1),playMaker.getDefense().getPlayers().get(i).getLocation().x);
			assertEquals(150,playMaker.getDefense().getPlayers().get(i).getLocation().y);
			assertTrue(playMaker.getDefense().getPlayers().get(i).getRouteDirection1().equals(new Point(0,1)));
			assertTrue(playMaker.getDefense().getPlayers().get(i).getRouteDirection2().equals(new Point(-1,0)));
		}
		
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
		// make offense and defense of one known player with similar locations
		ArrayList<Player> testOffensePlayer = new ArrayList<Player>();
		ArrayList<Player> testDefensePlayer = new ArrayList<Player>();
		
		// add two players that are a magnitude of 5 apart
		testOffensePlayer.add(new Receiver(10,false,new Point(50,50)));
		testDefensePlayer.add(new Defender(10,false,new Point(47,46)));
		
		Team testOffenseTeam = new Team(true);
		Team testDefenseTeam = new Team(false);
		
		testOffenseTeam.setPlayers(testOffensePlayer);
		testDefenseTeam.setPlayers(testDefensePlayer);
		
		playMaker.setOffense(testOffenseTeam);
		playMaker.setDefense(testDefenseTeam);
		
		// find best direction and make sure it detects the collision and returns
		// a direction of (0,0) occasionally to indicate a collision and block
		int nullDirectionCount = 0;
		int otherCount = 0;
		Point direction = null;
		for (int i = 0; i < 100; ++i) {
			direction = playMaker.findBestDirection(testOffensePlayer.get(0), true);
			
			assertTrue(direction != null);
			
			if (direction.equals(new Point(0,0)))
				nullDirectionCount++;
			else
				otherCount++;
		}
		assertTrue(nullDirectionCount > 20);
		// turns out this also sort of tests blocked() since that function is called in the
		// findBestDirection() function
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
	public void testProcessPlay() {
		// test for 2 teams, a hiked ball, and players starting to move simultaneously
		
		// two teams test
		assertTrue(playMaker.getOffense() != null);
		assertTrue(playMaker.getOffense().getPlayers().size() > 0);
		assertTrue(playMaker.getDefense()!= null);
		assertTrue(playMaker.getDefense().getPlayers().size() > 0);
		
		// test that ball is hiked (someone has it on the offense)
		playMaker.loadPlayConfig("testOffensePlay.txt", "testDefensePlay.txt");
		boolean foundBall = false;
		for (Player p : playMaker.getOffense().getPlayers()) {
			if (p.isHasBall())
				foundBall = true;
		}
		assertTrue(foundBall);
		
		// test that a play processes correctly
		Team testOffense = playMaker.getOffense();
		Team testDefense = playMaker.getDefense();
		playMaker.processPlay();
		// assure all players moved and play is over
		assertTrue(playMaker.getPlayOver());
		for (int i = 0; i < playMaker.getOffense().getPlayers().size(); ++i) {
			assertFalse(testOffense.getPlayers().get(i).getLocation().equals(playMaker.getOffense().getPlayers().get(i).getLocation()));
		}
		
		for (int i = 0; i < playMaker.getDefense().getPlayers().size(); ++i) {
			assertFalse(testDefense.getPlayers().get(i).getLocation().equals(playMaker.getDefense().getPlayers().get(i).getLocation()));
		}
		
	}

}
