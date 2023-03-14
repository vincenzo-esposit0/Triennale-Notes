package main_package;

import java.io.File;
import java.util.*;
import main_package.Libro;

public class Libreria {
	
	//Costruttore
	public Libreria(String nomefile) throws Exception{
		libri=createList(nomefile);
	}
	private ArrayList<Libro> createList (String nomefile) throws Exception{
		File file =new File(nomefile);
		Scanner input=new Scanner(file);
		ArrayList<Libro> inlibri =new ArrayList<Libro>();
		String titolo, autore, editore, copie;
		while (input.hasNext()) {
			titolo=input.nextLine();
			autore=input.nextLine();
			editore=input.nextLine();
			copie=input.nextLine();
			inlibri.add(new Libro(titolo,autore,editore,Integer.parseInt(copie)));
		}
		return inlibri;
	}
	
	//Stampa i libri scritti da un autore dato
	public void libriAutore (String autore) {
		for(int i=0;i<libri.size();i++) {
			if (autore.compareTo(libri.get(i).getAutore())==0) {
				libri.get(i).getLibro();
			}
		}
	}
	
	//Stampa i libri il cui titolo contiene una determinata stringa nel titolo
	public void stringTitolo (String str) {
		for(int i=0;i<libri.size();i++) {
			if (libri.get(i).getTitolo().contains(str)) {
				libri.get(i).getLibro();
			}
		}
	}
	
	//Stampa il libro con il maggior numero di copie stoccate
	public void libriAtMax() {
		int max=0;
		Libro x=new Libro();
		for(int i=0;i<libri.size();i++) {
			if (libri.get(i).getCopie()>=max) {
				max=libri.get(i).getCopie();
				x=libri.get(i);
			}
		}
		x.getLibro();
	}
	
	//Crea un nuova lista con i libri di cui le copie sono sotto una soglia data
	public void libroFinished(int n) {
		ArrayList<Libro> redlibri=new ArrayList<Libro>();
		for(int i=0;i<libri.size();i++) {
			if (libri.get(i).getCopie()<n) {
				redlibri.add(libri.get(i));
			}
		}
		for (int i=0;i<redlibri.size();i++) {
			redlibri.get(i).getLibro();
		}
	}
	
	//Aggioena il numero di copie di un determinato libro
	public void modCopie(int n, String str) {
		for(int i=0;i<libri.size();i++) {
			if (str.compareTo(libri.get(i).getTitolo())==0) {
				libri.get(i).aggiungiCopie(n);;
			}
		}
	}
	
	//Stampa tutti i libri presenti nella libreria
	public void getLibri() {
		for (int i=0;i<libri.size();i++) {
			libri.get(i).getLibro();
		}
	}
	//Vairiabili di istanza
	private ArrayList <Libro> libri;
}
