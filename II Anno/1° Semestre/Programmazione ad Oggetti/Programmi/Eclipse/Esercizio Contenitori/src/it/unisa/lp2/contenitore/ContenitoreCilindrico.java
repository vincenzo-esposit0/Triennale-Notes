package it.unisa.lp2.contenitore;

import java.math.*;

public class ContenitoreCilindrico extends Contenitore{
	//Costruttore
	public ContenitoreCilindrico(String nome,int codice,double prezzo,double altezza, double raggio) {
		super(nome,codice,prezzo,Math.PI*Math.pow(raggio, 2)*altezza);
		this.altezza=altezza;
		this.raggio=raggio;	
	}
	
	//Metodo toString
	public String toString() {
		return nome+" "+codice+" "+prezzo+" "+capienza+" "+altezza+" "+raggio;
	}
		
	//Metodo equals
	public boolean equals(Object y) {
		ContenitoreCilindrico x= (ContenitoreCilindrico) y;
		return ((nome.compareTo(x.nome)==0)&&(codice==x.codice)&&(prezzo==x.prezzo)&&(capienza==x.capienza)&&(altezza==x.altezza)&&(raggio==x.raggio));
	}
		
	//Metodo Clone
	public Object clone() {
		ContenitoreCilindrico cloned= (ContenitoreCilindrico) super.clone();
		cloned.raggio=this.raggio;
		cloned.altezza=this.altezza;
		return cloned;
	}
		
	//Attributi
	private double raggio;
	private double altezza;
}
