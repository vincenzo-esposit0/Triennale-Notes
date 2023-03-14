package it.unisa.lp2.contenitore;

public class ContenitoreCubico extends Contenitore{
	//Costruttore
	public ContenitoreCubico(String nome,int codice,double prezzo,double altezza, double alato) {
		super(nome,codice,prezzo,alato*alato*altezza);
		this.altezza=altezza;
		this.alato=alato;	
	}
		
	//Metodo toString
	public String toString() {
		return nome+" "+codice+" "+prezzo+" "+capienza+" "+altezza+" "+alato;
	}
			
	//Metodo equals
	public boolean equals(Object y) {
		ContenitoreCubico x= (ContenitoreCubico) y;
		return ((nome.compareTo(x.nome)==0)&&(codice==x.codice)&&(prezzo==x.prezzo)&&(capienza==x.capienza)&&(altezza==x.altezza)&&(alato==x.alato));
	}
	
	//Metodo Clone
	public Object clone() {
		ContenitoreCubico cloned= (ContenitoreCubico) super.clone();
		cloned.alato=this.alato;
		cloned.altezza=this.altezza;
		return cloned;
	}
						
	//Attributi
	private double alato;
	private double altezza;
}
