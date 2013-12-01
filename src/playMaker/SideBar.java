package playMaker;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;



public class SideBar extends JPanel {

	
	private PlayMaker playMaker;
	private SelectPlaysPanel selecter;
	private ImageButton playPause;
	
	public SideBar(PlayMaker playMaker, int x, int y) {
		this.playMaker = playMaker;
		// set layout to a single column
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		selecter = new SelectPlaysPanel(playMaker);
		this.add(selecter);
		playPause = new ImageButton("/images/playIcon.png", "/images/pauseIcon.png", playMaker);
		this.add(playPause);
		JButton resetButton = new JButton("RESET");
		resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetButton.addActionListener(new ResetListener(playMaker));
		this.add(resetButton);
	}
	
	public void toggle() {
		playPause.toggle();
	}
	
	public void refreshPlayChoice() {
		selecter.updateChoices();
	}
	
	private class ResetListener implements ActionListener {

		private PlayMaker frame;
		
		public ResetListener(PlayMaker playMaker) {
			this.frame = playMaker;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.reset();
		}
	}
	
}
