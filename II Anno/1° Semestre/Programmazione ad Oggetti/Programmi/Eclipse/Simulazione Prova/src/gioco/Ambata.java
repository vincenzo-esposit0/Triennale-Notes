package gioco;

public class Ambata extends GiocoDazzardo{
	//Costruttore 
	public Ambata(double vbiglietto) {
		super(vbiglietto);
		puntata=rand.nextInt(44)+1;
		for (int i=0;i<10;i++) 
			nestratti[i]=rand.nextInt(9)+1;
	}
	//Metodo gioca 
	public boolean gioca() {
		for (int i=0;i<10;i++) {
			if (puntata==nestratti[i]) {
				vincità=vbiglietto*10;
				return true;			
			}
		}
		return false;
	}
		
	//Metodo toString
	public String toString() {
		return vbiglietto+" "+puntata;
	}
	
	//Attributi
	private int puntata;
	private int[] nestratti=new int[10];
}
