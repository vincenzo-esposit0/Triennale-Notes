package gioco;

public class CartaAlta extends GiocoDazzardo{
	//Costruttore 
	public CartaAlta(double vbiglietto) {
		super(vbiglietto);
		for (int i=0;i<4;i++) 
				carte[i]=rand.nextInt(9)+1;
	}
	//Metodo gioca deve solo giocare quindi verificar ela vittoria
	public boolean gioca() {
		if ((carte[2]>carte[0])&&(carte[3]>carte[1])) {
			vincità=vbiglietto*5;
			return true;
		}
		else
			return false;
	}

	//Metodo toString
	public String toString() {
		return vbiglietto+" "+carte[0]+" "+carte[1]+" "+carte[2]+" "+carte[3];
	}
	
	//Attributi
	private int[] carte=new int[4];
}
