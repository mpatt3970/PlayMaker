package playMaker;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;



public class SideBar extends JPanel {
	
	private static int MAX_LETTERS = 20;
	private static String DEFAULT_MESSAGE = "Choose Plays from Above. Start the Play with the Button Below.";
	
	private PlayMaker playMaker;
	private SelectPlaysPanel selecter;
	private ImageButton playPause;
	private JTextPane message;
	
	public SideBar(PlayMaker playMaker, int x, int y) {
		this.playMaker = playMaker;
		// set layout to a single column
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		selecter = new SelectPlaysPanel(playMaker);
		this.add(selecter);
		message = new JTextPane();
		this.updateMessage(DEFAULT_MESSAGE);
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		message.setAlignmentY(Component.CENTER_ALIGNMENT);
		message.setEditable(false);
		this.add(message);
		playPause = new ImageButton("/images/playIcon.png", "/images/pauseIcon.png", playMaker);
		this.add(playPause);
		JButton resetButton = new JButton("RESET");
		resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetButton.addActionListener(new ResetListener(playMaker));
		this.add(resetButton);
	}
	
	public static String getDEFAULT_MESSAGE() {
		return DEFAULT_MESSAGE;
	}

	public void toggle() {
		playPause.toggle();
	}
	
	public void refreshPlayChoice() {
		selecter.updateChoices();
	}
	
	public void updateMessage(String m) {
		// breaks the string into a lined string to keep the width of the textarea from squeezing out the field
		
		// split it into words
		// add words to linedMessage until the next addition would overflow
		// then insert a new line and continue
		String[] words = m.split(" ");
		int max = MAX_LETTERS;
		String linedMessage = "";
		for (String word : words) {
			if ((linedMessage.length() + word.length()) > max) {
				linedMessage = linedMessage.concat("\n" + word + " ");
				max += MAX_LETTERS;
			} else {
				linedMessage = linedMessage.concat(word + " ");
			}
		}
		message.setText(linedMessage);
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
