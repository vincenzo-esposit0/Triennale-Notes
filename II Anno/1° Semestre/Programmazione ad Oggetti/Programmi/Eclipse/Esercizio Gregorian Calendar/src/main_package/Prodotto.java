package main_package;

import java.util.GregorianCalendar;

public abstract class Prodotto {
	//Costruttore
	public Prodotto(int codice, String descrizione, String marca, double prezzo, int quantit�) {
		this.codice=codice;
		this.descrizione=descrizione;
		this.marca=marca;
		this.prezzo=prezzo;
		this.quantit�=quantit�;
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
			if (p>quantit�)
				return false;
			quantit�-=p;
			return true;
		}
		
	//Attributo
	protected int codice;
	protected String descrizione;
	protected String marca;
	protected double prezzo;
	protected int quantit�;
	protected double pofferta;
	protected long tofferta;
	protected GregorianCalendar time=new GregorianCalendar();
	protected boolean inOfferta;
}
