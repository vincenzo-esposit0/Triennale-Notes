package gioco;

import java.util.Random;

public abstract class GiocoDazzardo {
	//Costruttore
	public GiocoDazzardo(double vbiglietto) {
		this.vbiglietto=vbiglietto;
		vincit�=0;
	}
	
	//Metodo gioca
	public abstract boolean gioca();
	
	//Ritorna vincit�
	public double getVincit�() { return vincit�; }
	
	//Attributi
	protected double vbiglietto;
	protected double vincit�;
	protected Random rand=new Random();
}
