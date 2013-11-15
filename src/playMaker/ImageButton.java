package playMaker;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.processPlay();
			}
			
			// unneccesary for this button
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
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
