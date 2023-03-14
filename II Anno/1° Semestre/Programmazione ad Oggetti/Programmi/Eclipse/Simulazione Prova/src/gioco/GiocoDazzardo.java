package gioco;

import java.util.Random;

public abstract class GiocoDazzardo {
	//Costruttore
	public GiocoDazzardo(double vbiglietto) {
		this.vbiglietto=vbiglietto;
		vincità=0;
	}
	
	//Metodo gioca
	public abstract boolean gioca();
	
	//Ritorna vincità
	public double getVincità() { return vincità; }
	
	//Attributi
	protected double vbiglietto;
	protected double vincità;
	protected Random rand=new Random();
}
