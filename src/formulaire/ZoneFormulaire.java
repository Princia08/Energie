package formulaire;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Interface.MonInterface;

public class ZoneFormulaire extends JPanel {

	/**
	 * Create the panel.
	 */
	MonInterface mi;
	Formulaire f;
	JTextField labelText=new JTextField("FRIGO");
	JTextField puissanceText=new JTextField("10");
	JTextField heureDebutText=new JTextField("06:00");
	JTextField heureFinText=new JTextField("10:00");
	JTextField quantiteText=new JTextField("1");

	public ZoneFormulaire(MonInterface mi,Formulaire f) {
		this.mi=mi;
		this.f=f;
		this.setLayout(null);
		setSize(300,300);
		JLabel label=new JLabel("label: ");
		JLabel puissance=new JLabel("puissance: ");
		JLabel heureDebut=new JLabel("Heure de debut: ");
		JLabel heureFin=new JLabel("Heure de fin: ");
		JLabel quantite=new JLabel("Quantite: ");
		label.setBounds(10,20,40,20);
		puissance.setBounds(10,40,100,20);
		heureDebut.setBounds(10,60,150,20);
		heureFin.setBounds(10,80,150,20);
		quantite.setBounds(10,100,150,20);

		labelText.setBounds(45,20,70,20);
		puissanceText.setBounds(100,40,70,20);
		heureDebutText.setBounds(100,60,70,20);
		heureFinText.setBounds(100,80,70,20);
		quantiteText.setBounds(100,100,70,20);
		
		JButton valider=new JButton("valider");
		valider.setBounds(50, 120, 80, 30);
		
		valider.addMouseListener(new ValiderListener(this,f));
		
		add(label);
		add(labelText);
		add(puissance);
		add(puissanceText);
		add(heureDebut);
		add(heureDebutText);
		add(heureFin);
		add(heureFinText);
		add(quantite);
		add(quantiteText);
		add(valider);
	}

}
