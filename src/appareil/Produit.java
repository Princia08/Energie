package appareil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public void findNecessaire() {
		try{  
			   String url="jdbc:ucanaccess://D://itu//S5//Mr Tahiana//Access//Energie.accdb";  
			   //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
			   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			   Connection c=DriverManager.getConnection(url);  
			   Statement st=c.createStatement();  
			   ResultSet rs=st.executeQuery("select * from produit");  
			   
			   while(rs.next()){  
			    System.out.println(rs.getString(1));  
			   }  
			  
			}catch(Exception ee){System.out.println(ee);}
	}
	
}
