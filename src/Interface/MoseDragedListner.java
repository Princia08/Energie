package Interface;

import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

import formulaire.Formulaire;

public class MoseDragedListner implements MouseInputListener  {
	
	PlaceObject po;
	Maison ma;
	Point currentScreenLocation;
	MonInterface mi;
	public MoseDragedListner(MonInterface mi,PlaceObject po,Maison m) {
		super();
		this.po = po;
		this.ma=m;
		this.mi=mi;
		//ma.addMouseListener(new Listener(ma));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.currentScreenLocation = e.getLocationOnScreen();
        po.setLocation(currentScreenLocation.x, currentScreenLocation.y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(ma.contains(currentScreenLocation)) {
			System.out.println("ato");
			Formulaire f=new Formulaire(mi);
	        //po.setVisible(false);
			po.removeMouseListener(this);
		}else {
			System.out.println("tsy ato");
		}
		//System.out.println("dsfqsfq");
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
