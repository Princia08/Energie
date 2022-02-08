package main;

import java.util.ArrayList;
import java.util.List;

import Interface.MonInterface;
import appareil.Appareil;
import service.Service;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MonInterface mi=new MonInterface();
		Service s = new Service();
		
		Appareil a1=new Appareil();
		a1.setHeureDebut("05:00");
		a1.setHeureFin("22:00");
		Appareil a2=new Appareil();
		a2.setHeureDebut("23:00");
		a2.setHeureFin("01:00");
		List<Appareil> lia = new ArrayList<Appareil>();
		lia.add(a1);lia.add(a2);
		
		s.finale(lia);
	}

}
