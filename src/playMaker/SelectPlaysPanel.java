package playMaker;

import java.awt.Color;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SelectPlaysPanel extends JPanel {

	private PlayMaker frame;
	private GenericComboBox base, secondary, offense;

	public SelectPlaysPanel(PlayMaker frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EtchedBorder());
		String[] formations = {"4-3", "5-2", "3-4"};
		String title = "Formation";
		base = new GenericComboBox(formations, title, this);
		this.add(base);
		String[] coverages = {"Cover-2"};
		title = "Coverage";
		secondary = new GenericComboBox(coverages, title, this);
		this.add(secondary);
		String[] plays = {"run", "pass"};
		title = "Plays";
		offense = new GenericComboBox(plays, title, this);
		this.add(offense);
		// load a default play
		updateChoices();
	}

	public void updateChoices() {
		String formation = base.getChoice();
		//String coverage = secondary.getChoice();
		//String play = offense.getChoice();
		
		String coverage = "defaultDefensePlay.txt";
		String play = "defaultOffensePlay.txt";
		
		frame.loadPlayConfig(formation,coverage, play);
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
	}
}
