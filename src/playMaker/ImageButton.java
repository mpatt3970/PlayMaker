package playMaker;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ImageButton extends JPanel {
	
	
	
	private JToggleButton button;
	
	public ImageButton(String playImage, String pauseImage) {
		ImageIcon icon = getIcon(playImage);
		button = new JToggleButton();
		button.setIcon(icon);
		icon = getIcon(pauseImage);
		button.setSelectedIcon(icon);
		add(button);
	}
	
	public ImageIcon getIcon(String fileName) {
		URL url = getClass().getResource(fileName);
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		return new ImageIcon(image);
	}
}
