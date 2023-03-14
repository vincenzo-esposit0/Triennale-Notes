package main_package;

import main_package.Treno;
import java.util.ArrayList;

public class Azienda_trasporti {
	//Costruttore
	public Azienda_trasporti() {		
	}
	
	//Aggiunge un treno non espresso all'azienda
	public boolean addTreno(int posti,double prezzoposti,int km,int fermate,String[][] orario) {
		if ((posti>0)&&(km>0)&&(fermate >=2)) {
			treni.add(new Treno(posti,prezzoposti,km,fermate,orario));
			return true;
		}else
			return false;
	}
	//Aggiunge un treno non espresso all'azienda
	public boolean addTreno(int posti,double prezzoposti,int km,int fermate,String[][] orario,int postiristorante,double prezzoristorante) {
		if ((posti>0)&&(km>0)&&(fermate >=2)&&(postiristorante>0)) {
			treni.add(new Treno(posti,prezzoposti,km,fermate,orario,postiristorante,prezzoristorante));
			return true;
		}else
			return false;
	}
	//Ritorna il numero di fermate del treno X
	public int getfermate (int x) { return treni.get(x).getNfermate();}
	//Ritorna il ricavo di un determinato treno X
	public double getRicavo(int x) { return treni.get(x).ricavoTreno();}
	//ritorna le informazioni su un treno x
	public void getTreno(int x) { treni.get(x).getTreno();}
		
	//Attributi
	private ArrayList <Treno> treni= new ArrayList<Treno>();
}
