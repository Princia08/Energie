package appareil;

public class Produit {
	
	String id;
	String label;
	Double amperage;
	Double voltage;
	Double price;

	public Produit() {}
	public Produit(String id, String label, Double amperage, Double voltage, Double price) {
		this.id = id;
		this.label = label;
		this.amperage = amperage;
		this.voltage = voltage;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getAmperage() {
		return amperage;
	}
	public void setAmperage(Double amperage) {
		this.amperage = amperage;
	}
	public Double getVoltage() {
		return voltage;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
