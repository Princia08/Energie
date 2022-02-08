package formulaire;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Interface.PlaceObject;
import appareil.Appareil;

public class ValiderListener implements MouseListener {

	ZoneFormulaire zf;
	Formulaire f;
	public ValiderListener(ZoneFormulaire zf,Formulaire f) 
	{
		this.zf=zf;
		this.f=f;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String label = zf.labelText.getText();
		Double puissance=Double.parseDouble(zf.puissanceText.getText());
		String heureDebut=zf.heureDebutText.getText();
		String heureFin=zf.heureFinText.getText();
		int quantite=Integer.parseInt(zf.quantiteText.getText()); 
		Appareil app=new Appareil(label,puissance,heureDebut,heureFin,quantite);
		zf.mi.addAppareil(app);
		f.setVisible(false);
		PlaceObject po=zf.mi.getPo();
		po.setBackground(new Color(255,255,255));
		JLabel jl=new JLabel(label);
		jl.setBounds(0, 0, 50, 20);
		po.add(jl);
		zf.mi.addDragListener();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
