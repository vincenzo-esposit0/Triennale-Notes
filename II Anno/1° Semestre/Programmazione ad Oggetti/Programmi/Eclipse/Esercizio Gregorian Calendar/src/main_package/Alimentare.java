package main_package;

public class Alimentare extends Prodotto{
	//Costruttore
	public Alimentare (int codice, String descrizione, String marca, double prezzo, int quantità,double peso, long scadenza) {
		super(codice,descrizione,marca,prezzo,quantità);
		this.peso=peso;
		this.scadenza=scadenza;
	}
	
	//Metodo èScaduto
	public boolean èScaduto() {
		if (time.getTimeInMillis()>scadenza)
			return true;
		return false;
	}
	
	//Attributi
	private double peso;
	private long scadenza;
}
