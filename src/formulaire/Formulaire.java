package formulaire;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Interface.MonInterface;

public class Formulaire extends JFrame {

	private JPanel contentPane;
	MonInterface mi;
	public Formulaire(MonInterface mi) {
		this.mi=mi;
		setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);	
		ZoneFormulaire z=new ZoneFormulaire(mi,this);
		this.add(z);
		setVisible(true);

	}

}
