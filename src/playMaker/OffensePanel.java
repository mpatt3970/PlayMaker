package playMaker;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OffensePanel extends JPanel {
	private PlayMaker frame;
	
	public OffensePanel(PlayMaker frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new TitledBorder("Offense"));
		String[] plays = {"run", "pass"};
		String title = "Plays";
		this.add(new GenericComboBox(plays, title));
	}
}
