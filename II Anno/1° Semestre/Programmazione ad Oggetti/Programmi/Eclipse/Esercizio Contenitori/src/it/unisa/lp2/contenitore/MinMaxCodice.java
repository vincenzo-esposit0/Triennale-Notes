package it.unisa.lp2.contenitore;

public class MinMaxCodice extends ElencoContenitori{
	//Costruttore
	public MinMaxCodice() {
		min=contenitori.get(0).codice;
		max=contenitori.get(0).codice;
		for(int i=0;i<contenitori.size();i++) {
			if(contenitori.get(i).codice<min)
				min=contenitori.get(i).codice;
			if(contenitori.get(i).codice>max)
				max=contenitori.get(i).codice;
		}
	}
		
	//Metodi get
	public int getMin() { return min;}
	public int getMax() { return max;}
		
	//Attributi
	private int min;
	private int max;
}
