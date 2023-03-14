package main_package;

public class Libro {
	
	//Costruttori
	public Libro(String ntitolo, String nautore, String neditore, int ncopie) {
		titolo=ntitolo;
		autore=nautore;
		editore=neditore;
		copie=ncopie;
	}
	public Libro() {
		titolo="";
		autore="";
		editore="";
		copie=0;
	}
	
	//metodi get
	public String getTitolo() { return titolo;}
	public String getAutore() { return autore;}
	public String getediotore() { return editore;}
	public int getCopie() { return copie;}
	public void getLibro() {
		System.out.println("Titolo: "+titolo);
		System.out.println("Scrittore: "+autore);
		System.out.println("Editore: "+editore);
		System.out.println("Copie disponibili: "+copie);
	}
	
	//metodi set
	public void aggiungiCopie(int n) { copie+=n; } 
	

	//Attributi
	protected String titolo;
	protected String autore;
	protected String editore;
	protected int copie;
}
