package Main_package;

public class Quadrato {
	
	// Costruttore	
	public Quadrato(float lato_in) {
		lato=lato_in;
	}
	
	// Metodo getlato
	public float getLato() {
		return lato;
	}
	
	// Metodo setLato
	public void setLato(float lato_new) {
		lato=lato_new;
	}
	
	// Metodo calcPerimetro
	public float calcPerimetro() {
		return lato*4;
	}
	static float lato=1;
}
