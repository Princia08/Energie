package appareil;

import java.util.Date;

public class Appareil {
	String label;
	Double puissance;
	String heureDebut;
	String heureFin;
	int quantite;
	double totalJour;
	double totalNuit;
	
	public Appareil(){}
	public Appareil(String label, Double puissance, String heureDebut, String heureFin, int quantite) {
		this.label = label;
		this.puissance = puissance;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.quantite = quantite;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPuissance() {
		return puissance;
	}
	public void setPuissance(Double puissance) {
		this.puissance = puissance;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public Double getTotalJour() {
		return totalJour;
	}
	public void setTotalJour(Double totalJour) {
		this.totalJour = totalJour;
	}
	public Double getTotalNuit() {
		return totalNuit;
	}
	public void setTotalNuit(Double totalNuit) {
		this.totalNuit = totalNuit;
	}
}
