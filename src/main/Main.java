package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import appareil.Produit;  

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MonInterface mi=new MonInterface();
		Service s = new Service();
		
		Appareil a1=new Appareil();
		a1.setHeureDebut("05:00");
		a1.setHeureFin("19:00");
		Appareil a2=new Appareil();
		a2.setHeureDebut("18:00");
		a2.setHeureFin("06:00");
		List<Appareil> lia = new ArrayList<Appareil>();
		lia.add(a1);
		lia.add(a2);
		
		s.finale(lia);*/
		
		
		
		try{  
		   String url="jdbc:ucanaccess://D://itu//S5//Mr Tahiana//Access//Energie.accdb";  
		   //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
		   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		   Connection c=DriverManager.getConnection(url);  
		   Statement st=c.createStatement();  
		   ResultSet rs=st.executeQuery("select tab1.*, util*[voltage]*[amperage] as puissanceTotal,price*util as pricetotal from  (select id,label,amperage,voltage,price," + 
		   		"int((iif(label='Panneaux solaire',-int(-80/([voltage]*[amperage])),iif(label='baterie',-int(-0/([voltage]*[amperage])),0)))) as util " + 
		   		"from produit) as tab1");  
		   List<Produit> lp=new ArrayList<Produit>();
		   while(rs.next()){  
			   Produit p=new Produit();
			   p.setId(rs.getString(1));
			   p.setLabel(rs.getString(2));
			   p.setAmperage(rs.getDouble(3));
			   p.setVoltage(rs.getDouble(4));
			   p.setPrice(rs.getDouble(5));
			   lp.add(p);
		    //System.out.println(rs.getString(5));  
		   }  
		   c.close();
		   List<List<Produit>> f=new ArrayList<List<Produit>>();
		   //getAllCombinaison(lp,0,new ArrayList<Produit>(),f);
		   gg(lp,0,new ArrayList<Produit>(),f);
		   for(List<Produit> l:f) {
			   afficherListe(l);
		   }
		   /*Double puissanceJour=10000.0;
		   Double puissanceNuit=5000.0;
		   List<List<Produit>> listeCombinaisonPaneaux=new ArrayList<List<Produit>>();
		   for(Produit p:lp) {
			   List<Produit> combinaisonTempPaneaux=new ArrayList<Produit>();
			   if(p.getLabel().compareTo("Panneaux solaire")==0) {
				   if(combinaisonTempPaneaux.size()<1) {
					   combinaisonTempPaneaux.add(p);
				   }else {
					   
				   }
			   }
		   }*/
		   
		  
		}catch(Exception ee){System.out.println(ee);}  
		//f(new String[] {"B1","B2","B3","B4"},0,"","{");
		  
		
	}
	
	public static void gg(List<Produit> lp,int index,List<Produit> li,List<List<Produit>> finale) {
		if(index==lp.size()) {
			finale.add(li);
			li = new ArrayList<Produit>();
			return;
		}
		
		Produit produit=(Produit)lp.get(index);
		
		List<Produit> lpp=new ArrayList<Produit>();
		
		for(Produit l:li) {
			lpp.add(l);
		}
		
		li.add(produit);
		gg(lp,index+1,li,finale);
		
		gg(lp,index+1,lpp,finale);
		//afficherListe(li);
		//li=new ArrayList<Produit>();
	}
	
	public static void getAllCombinaison(List<Produit> lp,int index,List<Produit> li,List<List<Produit>> finale) {
		
		if(index==lp.size()) {
			finale.add(li);
			//li=new ArrayList<Produit>();
			return;
		}
		
		
		Produit produit=(Produit)lp.get(index);
		List<Produit> lpp=new ArrayList<Produit>();
		for(Produit l:li) {
			lpp.add(l);
		}
		li.add(produit);
		
		getAllCombinaison(lp,index+1,li,finale);
		getAllCombinaison(lp,index+1,lpp,finale);
		
		afficherListe(li);
		
	}
	
	public static void afficherListe(List<Produit>li) {
		for(Produit ap :li) {
			System.out.print(ap.getId());
		}
		System.out.println("-------");
	}
	
	public static void f(String[] numbers,int index,String sum,String output) {
		if(index==numbers.length) {
			System.out.println(output + " } = " + sum);
			return;
		}
		f(numbers,index+1,sum+numbers[index],output+""+numbers[index]);
		
		f(numbers,index+1,sum,output);
	}
	
	/*public void getAllCombinaison(List<Produit> lp,int indice,Double puissance){
		List<Produit> lip=new ArrayList<Produit>();
		for(int i=indice;i<lp.size();i++) {
			if(sommePuissanceListe(lip)<puissance) {
				Produit ptemp=(Produit) lp.get(i);
				lip.add(ptemp);
			}
		}
	}*/
	
	public static Double sommePuissanceListe(List<Produit>li) {
		Double retour=0.0;
		for(Produit p: li) {
			retour+=p.getPuissance();
		}
		return retour;
		
	}

}
