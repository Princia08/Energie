package Interface;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JPanel;

public class PlaceObject extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlaceObject() {
		setSize(500,600);
		this.setBounds(550, 50, 50, 50);
		this.setLayout(null);
		this.setBackground(new Color(100,100,100));
	}

}
