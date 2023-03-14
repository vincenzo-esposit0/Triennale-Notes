import java.util.ArrayList;
public class StazioneTester {
	
	public static void main (String[] args){
	
	Stazione myStazione = new Stazione();
	ArrayList<Fermata> myFermate = new ArrayList<Fermata>();
	ArrayList<Fermata> myFermate1 = new ArrayList<Fermata>();
	
		myFermate.add(new Fermata("Roma", "8.00"));
		myFermate.add(new Fermata("Milano", "12.00"));
		myFermate1.add(new Fermata("Napoli", "9.00"));
		myFermate1.add(new Fermata("Salerno", "10.30"));
		myStazione.addTreno(new Treno(myFermate, 800, 100,5.0,0));
		myStazione.addTreno(new TrenoRistorante(myFermate1, 900,200,300,7.0,0));
		
		Treno treno;
		
		for (int i=0; i<myStazione.size();i++)
		{
			treno = myStazione.getTreno(i);
			System.out.print("Incasso del treno " + i + ": " );
			System.out.print(treno.calcIncasso(treno.getNumKm(), treno.getPrezzoperKm()));
			System.out.println("");
		}
		
		
		for (int i=0; i<myStazione.size();i++)
		{
			treno = myStazione.getTreno(i);
			System.out.print("Fermate del treno " + i + ": " );
			System.out.print(treno.getFermate());
			System.out.println("");
		}
		
		for (int i=0; i<myStazione.size();i++)
		{
			treno = myStazione.getTreno(i);
			System.out.print("Posti disponibili del treno "+ i + ": ");
			System.out.print(treno.getNumeroPosti());
			System.out.println("");
		}
		
	}
	
}
