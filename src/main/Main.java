package main;

import java.util.ArrayList;
import java.util.List;

import Interface.MonInterface;
import appareil.Appareil;
import service.Service;
import java.sql.*;  

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MonInterface mi=new MonInterface();
		/*Service s = new Service();
		
		Appareil a1=new Appareil();
		a1.setHeureDebut("05:00");
		a1.setHeureFin("22:00");
		Appareil a2=new Appareil();
		a2.setHeureDebut("18:00");
		a2.setHeureFin("06:00");
		List<Appareil> lia = new ArrayList<Appareil>();
		lia.add(a1);lia.add(a2);
		
		s.finale(lia);*/
		
		
		
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
