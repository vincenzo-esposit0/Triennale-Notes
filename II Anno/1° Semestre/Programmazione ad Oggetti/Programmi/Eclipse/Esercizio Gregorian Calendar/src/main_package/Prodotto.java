package main_package;

import java.util.GregorianCalendar;

public abstract class Prodotto {
	//Costruttore
	public Prodotto(int codice, String descrizione, String marca, double prezzo, int quantità) {
		this.codice=codice;
		this.descrizione=descrizione;
		this.marca=marca;
		this.prezzo=prezzo;
		this.quantità=quantità;
		inOfferta=false;
		pofferta=0;
	}
	
	//Metodo mettiInOfferta
	public void mettiInOfferta(double p, GregorianCalendar g) {
		inOfferta=true;
		p=pofferta;
		tofferta=g.getTimeInMillis();
		prezzo-=prezzo/100*p;
	}
	
	//Metodo controllaOfferta
	public void controllaOfferta() {
		inOfferta=false;
		if (time.getTimeInMillis()>tofferta)
			prezzo+=prezzo/100*pofferta;
	}
	
	//Metodo acquista
		public boolean acquista(int p) {
			if (p>quantità)
				return false;
			quantità-=p;
			return true;
		}
		
	//Attributo
	protected int codice;
	protected String descrizione;
	protected String marca;
	protected double prezzo;
	protected int quantità;
	protected double pofferta;
	protected long tofferta;
	protected GregorianCalendar time=new GregorianCalendar();
	protected boolean inOfferta;
}
