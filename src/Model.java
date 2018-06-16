import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Model extends JFrame {
	/**
	 * NOT MAIN FRAME
	 */
	private static final long serialVersionUID = 1L;

	public JPanel insidePanel;
	public JLabel image;

	public Model(String imagePath, String title, int counterForTitle) {

		insidePanel = new JPanel(new GridLayout(1, 1));
		add(insidePanel);

		image = new JLabel(new ImageIcon(imagePath));
		insidePanel.add(image);

		setLayout(new GridLayout(1, 1));
		setVisible(true);
		setSize(700, 700);
		setLocation(860, 50);
		setTitle(title + " Model " + counterForTitle);
	}
}
