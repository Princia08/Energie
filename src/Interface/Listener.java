package Interface;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

public class Listener implements MouseListener {

	Point currentScreenLocation;
	MonInterface mi;
	PlaceObject po;
	Maison ma;

	public Listener(MonInterface mi,PlaceObject po, Maison ma) {
		super();
		this.mi=mi;
		this.po=po;
		this.ma = ma;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*this.currentScreenLocation = e.getLocationOnScreen();
        po.setLocation(currentScreenLocation.x, currentScreenLocation.y);
        mi.repaint();*/

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.currentScreenLocation = e.getLocationOnScreen();
		if(ma.contains(currentScreenLocation)) {
			System.out.println("ato");
		}else {
			System.out.println("tsy ato");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	

}
