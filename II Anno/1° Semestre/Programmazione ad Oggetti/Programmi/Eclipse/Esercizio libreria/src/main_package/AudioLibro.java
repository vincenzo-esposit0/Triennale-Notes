package main_package;

public class AudioLibro extends Libro{
	//Costruttori
	public AudioLibro(String ntitolo, String nautore, String neditore, int ncopie,double durata,String formato) {
		titolo=ntitolo;
		autore=nautore;
		editore=neditore;
		copie=ncopie;
		this.durata=durata;
		this.formato=formato;
	}
	public AudioLibro() {
		titolo="";
		autore="";
		editore="";
		copie=0;
		durata=0;
		formato="";
	}
	//Metodi get
	public double getDurata() { return durata;}
	public String getFormato() { return formato;}
	public void getAudioLibro() {
		System.out.println("Titolo: "+titolo);
		System.out.println("Scrittore: "+autore);
		System.out.println("Produttore: "+editore);
		System.out.println("Copie disponibili: "+copie);
		System.out.println("Durata: "+durata);
		System.out.println("Formato: "+formato);
	}
	//Attributi
	private double durata;
	private String formato;
}
