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
	private GenericComboBox base, offense;

	public SelectPlaysPanel(PlayMaker frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EtchedBorder());
		String[] formations = {"4-3.txt", "5-2.txt", "3-4.txt"};
		String title = "Formation";
		base = new GenericComboBox(formations, title, this);
		this.add(base);
		String[] plays = {"Fly.txt","defaultOffensePlay.txt", "testOffensePlay.txt"};
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
		
		frame.loadPlayConfig(defensePlay,offensePlay);

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
