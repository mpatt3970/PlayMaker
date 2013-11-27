package playMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GenericComboBox extends JPanel implements ActionListener {
	
	private SelectPlaysPanel parent;
	private JComboBox box;
	
	public GenericComboBox(String[] combo, String title, SelectPlaysPanel parent) {
		this.parent = parent;
		this.setBorder(new TitledBorder(title));
		box = new JComboBox(combo);
		box.addActionListener(this);
		this.add(box);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// load play config
		parent.updateChoices();
	}
	
	
	public String getChoice() {
		return (String) box.getSelectedItem();
	}
	
}
