package main_package;

public class Quiz implements Measurable{
	//Costruttore
	public Quiz(double punteggio,String votoquiz) {
		this.punteggio=punteggio;
		this.votoquiz=votoquiz;
		
	}
	
	//Metodi get
	public double getPunteggio() { return punteggio;}
	public String getVoto() { return votoquiz;}
	public double getMeasure() { return punteggio;}
	
	//Variabili d'ambiente
	private double punteggio;
	private String votoquiz;
}
