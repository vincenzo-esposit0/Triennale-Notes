package main_package;

public class Distributore {
	private int lattine;
	private int gettoni;
	private final int maxl;
	
	//Costruttore
	public Distributore(int inlat,int inget,int inmax) {
		lattine=inlat;
		gettoni=inget;
		maxl=inmax;
	}
	
	//metodo Acquisto
	public boolean Acquisto() {
		if (lattine>0) {
			System.out.println("Prelevare la lattina...");
			lattine--;
			gettoni++;
			return true;
		}
		else
			return false;
	}
	
	//metodo ricarica
	public boolean Ricarica(int newlat) {
		if ((lattine+newlat)>maxl)
			return false;
		else {
			lattine+=newlat;
			return true;
		}
	}
	
	//return lattine
	public int getlattine() {
		return lattine;
	}
	
	//return gettoni
	public int getgettoni() {
		return gettoni;
	}
}
