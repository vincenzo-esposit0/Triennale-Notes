package main_package;

public class Elettronico extends Prodotto{
	//Costruttore
	public Elettronico (int codice, String descrizione, String marca, double prezzo, int quantità,int garanziabase, double prezzoannualegaranzia) {
		super(codice,descrizione,marca,prezzo,quantità);
		this.garanziabase=garanziabase;
		this.prezzoannualegaranzia=prezzoannualegaranzia;
	}
	
	//Metodo calcolaCostoGaranzia
	public double calcolaCostoGaranzia(int a) {
		if (a<garanziabase)
			return 0;
		else
			return (a-garanziabase)*prezzoannualegaranzia;
	}
	
	//Attributi 
	private int garanziabase;
	private double prezzoannualegaranzia;
}

