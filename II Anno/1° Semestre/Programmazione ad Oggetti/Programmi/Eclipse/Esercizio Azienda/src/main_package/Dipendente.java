package main_package;

public class Dipendente {
	//Costruttore
	public Dipendente(String cognome,String nome,String cfiscale,double stipendio) {
		this.cognome=cognome;
		this.nome=nome;
		this.cfiscale=cfiscale;
		this.stipendio=stipendio;
	}
	
	//Metodi get
	public String getCognome() { return cognome;}
	public String getNome() { return nome;}
	public String getCfiscale() { return cfiscale;}
	public double getStipendio() { return stipendio;}
	
	//Metodi set
	public void setStipendio(double stipendio) { this.stipendio=stipendio; }
	
	//Metodo toString
	public String toString() {
		return cognome+" "+nome+" "+cfiscale+" "+stipendio;
	}
	
	//Attributi
	private String cognome;
	private String nome;
	private String cfiscale;
	private double stipendio;
}
