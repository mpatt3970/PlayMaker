package playMaker;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DefensePanel extends JPanel {
	
	private PlayMaker frame;
	
	public DefensePanel(PlayMaker frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new TitledBorder("Defense"));
		String[] formations = {"4-3", "5-2", "3-4"};
		String title = "Formation";
		this.add(new GenericComboBox(formations, title));
		String[] coverages = {"Cover-2"};
		title = "Coverage";
		this.add(new GenericComboBox(coverages, title));
	}
}
