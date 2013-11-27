package playMaker;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SelectPlaysPanel extends JPanel {
	
	private PlayMaker frame;
	private GenericComboBox base, secondary;
	
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
		this.add(new GenericComboBox(plays, title, this));
	}
	
	public void updateChoices() {
		String formation = base.getChoice();
		String coverage = secondary.getChoice();
	}
}