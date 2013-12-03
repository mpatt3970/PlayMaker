package playMaker;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SelectPlaysPanel extends JPanel {

	private PlayMaker frame;
	private GenericComboBox base, offense;

	public SelectPlaysPanel(PlayMaker frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EtchedBorder());
		String[] formations = {"4-3", "5-2", "3-4"};
		String title = "Formation";
		base = new GenericComboBox(formations, title, this);
		this.add(base);
		String[] plays = {"Fly", "SweepLeft", "SweepRight", "Slants", "Blast", "Cross", "Reverse", "Screen", "HailMary"};
		title = "Plays";
		offense = new GenericComboBox(plays, title, this);
		this.add(offense);
		// load a default play
		updateChoices();
	}

	public void updateChoices() {
		String defensePlay = base.getChoice();
		String offensePlay = offense.getChoice();
		
		//String defensePlay = "3-4.txt";
		//String offensePlay = "defaultOffensePlay.txt";
		

		// Reset the throwing loop and boolean for a new play
		frame.setLoopCounter(0);
		frame.setThrown(false);
		frame.setCaught(false);
		frame.resetBall();
		frame.setPlayOver(false);
		if (frame.getPaused() == false) {
			frame.getSideBar().toggle();
		}
		frame.getField().setSelected(true);
		Team off = new Team(true, frame);
		Team def = new Team(false, frame);
		ArrayList<MovableObject> d = new ArrayList<MovableObject>();
		d.addAll(off.getPlayers());
		d.addAll(def.getPlayers());
		frame.setOffense(off);
		frame.setDefense(def);
		frame.setDrawable(d);
		frame.loadPlayConfig(defensePlay + ".txt",offensePlay + ".txt");
	}
}
