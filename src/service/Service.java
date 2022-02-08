package service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import appareil.Appareil;

public class Service {
	public Double getDiffHour(String heureDebut,String heureFin)
	{
		LocalTime localDebut = LocalTime.parse(heureDebut);
		LocalTime localFin = LocalTime.parse(heureFin);
		
		Double differenceInHours = Double.parseDouble(ChronoUnit.MINUTES.between(localDebut, localFin)+"")/60;
		return differenceInHours;
	}
	
	public ArrayList<Appareil> getAllHour(String heureDebut,String heureFin)
	{
		ArrayList<Appareil> result=new ArrayList<Appareil>();
		
		if(getDiffHour(heureDebut,heureFin)<0)
		{
			Appareil appareil1 = new Appareil();
			appareil1.setHeureDebut(heureDebut);
			appareil1.setHeureFin("23:59");
			result.add(appareil1);
			Appareil appareil2 = new Appareil();
			appareil2.setHeureDebut("00:00");
			appareil2.setHeureFin(heureFin);
			result.add(appareil2);
		}
		else
		{
			Appareil appareil = new Appareil();
			appareil.setHeureDebut(heureDebut);
			appareil.setHeureFin(heureFin);
			result.add(appareil);
		}
		return result;
	}
	
	public Double[] getTotalJour(String heureDebut,String heureFin)
	{
		Double totalMatin=0.0;
		Double totalSoir=0.0;
		Double [] retour =new Double [2];
		LocalTime localDebut = LocalTime.parse(heureDebut);
		LocalTime localFin = LocalTime.parse(heureFin);
		String heureLimiteDebut="06:00"; String heureLimiteFin="18:00";
		LocalTime limiteDebut= LocalTime.parse(heureLimiteDebut);
		LocalTime limiteFin= LocalTime.parse(heureLimiteFin);
		
		if((localDebut.isBefore(limiteDebut) && localFin.isBefore(limiteDebut)) ||
		(localDebut.isAfter(limiteFin) && localFin.isAfter(limiteFin)))
		{
			System.out.print("heureFin" +heureFin+ "\n");
			String finTemp="";
			if(heureFin.equalsIgnoreCase("23:59"))
				heureDebut= localDebut.minusMinutes(1)+"";
			//System.out.print("debutTemp "+debutTemp+"\n");
			
			totalSoir=getDiffHour(heureDebut,heureFin);
		}
		else if((localDebut.isAfter(limiteDebut) || localDebut.equals(limiteDebut))
		 && localFin.isBefore(limiteFin))
		{
			totalMatin=getDiffHour(heureDebut,heureFin);
		}
		else if(
				(localDebut.isAfter(limiteDebut) || localDebut.equals(limiteDebut)) 
				&& (localFin.isAfter(limiteFin) || localFin.equals(limiteFin)))
		{
			totalMatin=getDiffHour(heureDebut,heureLimiteFin);
			totalSoir=getDiffHour(heureLimiteFin,heureFin);
		}
		else if(localDebut.isBefore(limiteDebut) 
				&& (localFin.isAfter(limiteDebut)|| localFin.equals(limiteDebut))
				&& localFin.isBefore(limiteFin))
		{
			totalSoir=getDiffHour(heureDebut,heureLimiteDebut);
			totalMatin=getDiffHour(heureLimiteDebut,heureFin);	
		}
		else if(localDebut.isBefore(limiteDebut) 
				&& localFin.isAfter(limiteFin))
		{
			totalMatin=12.0;
			totalSoir +=getDiffHour(heureDebut,heureLimiteDebut);
			totalSoir +=getDiffHour(heureLimiteFin,heureFin);
			
		}
		retour[0] = totalMatin;
		retour[1] = totalSoir;
		return retour;
	}
	
	public void finale(List<Appareil> lia) {
		for(Appareil ap: lia) {
			setTotalHeure(ap);
			System.out.println("jour "+ap.getTotalJour());
			System.out.println("nuit "+ap.getTotalNuit());
		}
	}
	
	public void setTotalHeure(Appareil ap) {
		ArrayList<Appareil> liste=this.getAllHour(ap.getHeureDebut(), ap.getHeureFin());
		for(Appareil app: liste) {
			Double totalJour = getTotalJour(app.getHeureDebut(),app.getHeureFin())[0];
			Double totalSoir = getTotalJour(app.getHeureDebut(),app.getHeureFin())[1];
			ap.setTotalJour(ap.getTotalJour()+totalJour);
			ap.setTotalNuit(ap.getTotalNuit()+totalSoir);
		}
		
		
	}
	
}
