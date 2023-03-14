package main_package;

public class Video extends Libro{
	//Costruttori
		public Video(String ntitolo, String nautore, String nproduttore, int ncopie) {
			titolo=ntitolo;
			autore=nautore;
			produttore=nproduttore;
			copie=ncopie;
		}
		public Video() {
			titolo="";
			autore="";
			editore="";
			copie=0;
		}
	public void getVideo() {
		System.out.println("Titolo: "+titolo);
		System.out.println("Scrittore: "+autore);
		System.out.println("Produttore: "+produttore);
		System.out.println("Copie disponibili: "+copie);
	}
	//Attributi
	private String produttore;
}
