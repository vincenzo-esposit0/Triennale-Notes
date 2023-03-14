package main_package;

public class Alimentare extends Prodotto{
	//Costruttore
	public Alimentare (int codice, String descrizione, String marca, double prezzo, int quantit�,double peso, long scadenza) {
		super(codice,descrizione,marca,prezzo,quantit�);
		this.peso=peso;
		this.scadenza=scadenza;
	}
	
	//Metodo �Scaduto
	public boolean �Scaduto() {
		if (time.getTimeInMillis()>scadenza)
			return true;
		return false;
	}
	
	//Attributi
	private double peso;
	private long scadenza;
}
