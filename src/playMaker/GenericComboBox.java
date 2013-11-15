package playMaker;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GenericComboBox extends JPanel {
	public GenericComboBox(String[] combo, String title) {
		this.setBorder(new TitledBorder(title));
		this.add(new JComboBox(combo));
	}
}
