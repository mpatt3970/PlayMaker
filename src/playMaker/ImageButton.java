package playMaker;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ImageButton extends JPanel {
	
	private PlayMaker frame;
	
	private JToggleButton button;
	
	public ImageButton(String playImage, String pauseImage, PlayMaker playMaker) {
		this.frame = playMaker;
		ImageIcon icon = getIcon(playImage);
		button = new JToggleButton();
		button.setIcon(icon);
		icon = getIcon(pauseImage);
		button.setSelectedIcon(icon);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.flipPaused();
				frame.getField().setSelected(false);
			}
		});
		add(button);
	}
	
	public ImageIcon getIcon(String fileName) {
		URL url = getClass().getResource(fileName);
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		return new ImageIcon(image);
	}
}
