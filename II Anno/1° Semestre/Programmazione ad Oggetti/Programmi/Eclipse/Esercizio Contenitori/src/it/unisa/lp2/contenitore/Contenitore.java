package it.unisa.lp2.contenitore;

public abstract class Contenitore implements Cloneable,Comparable{
	//Costruttore
	public Contenitore(String nome,int codice,double prezzo,double capienza) {
		this.nome=nome;
		this.codice=codice;
		this.prezzo=prezzo;
		this.capienza=capienza;
	}
	
	//Metodo toString
	public abstract String toString();

	//Metodo equals
	public boolean equals(Object x) {
		if(x==null) {
			return false;
		}
		if(getClass()!=x.getClass())
			return false;
		Contenitore cx=(Contenitore) x;
		return 
	}
	
	//Meotodo clone
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	//Metodi interfaccia
	public String getNome() { return nome;}
	public String getCodice() { return codice+""; }
	public String getPrezzo() { return prezzo+""; }

	//Attributi
	protected String nome;
	protected int codice;
	protected double prezzo;
	protected double capienza;
}
