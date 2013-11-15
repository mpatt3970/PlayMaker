package playMaker;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;



public class SideBar extends JPanel {
	// I don't worry about resizing this so larger windows will
	// just have larger fields. LayoutManager handles setting this size correctly

	
	private PlayMaker playMaker;
	
	public SideBar(PlayMaker playMaker, int x, int y) {
		this.playMaker = playMaker;
		// set layout to a single column
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new ImageButton("/images/playIcon.png", "/images/pauseIcon.png"));
	}
	
}
