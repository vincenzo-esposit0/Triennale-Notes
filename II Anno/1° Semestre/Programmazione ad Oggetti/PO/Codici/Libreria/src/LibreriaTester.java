import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class LibreriaTester 
{

	public static void main(String[] args) throws Exception 
	{
	 Libreria myLibreria=new Libreria();
	 File myFile=new File("libreria.txt");
     ArrayList<Libro> ricerca;
     Scanner scanner=null;
	 PrintStream printer=null;
	 
	 if(!myFile.exists())//se il file non esiste viene creato
		 printer=new PrintStream(myFile);
	 
	 scanner=new Scanner(myFile);//ora il file esiste e può essere istanziato un'oggetto di Scanner
	 
     if(!scanner.hasNext())//controllo se il file è vuoto
	 {
	 //assegno una serie di libri alla libreria
	 myLibreria.addLibro(new Libro("Gli arancini di Montalbano","Andrea Camilleri","Mondadori",50));
	 myLibreria.addLibro(new Libro("Una voce di notte","Andrea Camilleri","Sellerio Editore Palermo",14));
	 myLibreria.addLibro(new Libro("Giro di boa","Andrea Camilleri","Rizzoli",11));
	 myLibreria.addLibro(new Libro("Fai bei sogni","Massimo Gramellini","Longanesi",50));
	 myLibreria.addLibro(new Libro("Castelli di rabbia","Alessandro Baricco","Feltrinelli",20));
	 
	 //i dati dei libri vengono scritti su file
	 
	 if(printer==null)//se printer non contiene alcun riferimento viene istanziato un oggetto PrintStream
	   printer=new PrintStream(myFile);
	 
	 myLibreria.toFile(printer);
	 }else
		 myLibreria.fromFile(scanner);//Se non è vuoto carico i contenuto del file nella libreria
	 
	 System.out.println("TUTTI I LIBRI SCRITTI DA CAMILLERI:");
	 ricerca=myLibreria.searchByAutore("Andrea Camilleri");
	 for(Libro l:ricerca)
		 System.out.println("\n"+l.getTitolo()+"\n"+l.getAutore()+"\n"+l.getEditore()+"\n"+l.getNumeroCopie());
	 
	 System.out.println("\nI LIBRI CHE CONTENGONO LA PAROLA SOGNI NEL TITOLO:");
	 ricerca=myLibreria.searchByString("sogni");
     for(Libro l:ricerca)
    	 System.out.println("\n"+l.getTitolo()+"\n"+l.getAutore()+"\n"+l.getEditore()+"\n"+l.getNumeroCopie());
	 
     System.out.println("\nI LIBRI CON MASSIMO NUMERO DI COPIE:");
	 ricerca=myLibreria.searchCopieMax();
     for(Libro l:ricerca)
    	 System.out.println("\n"+l.getTitolo()+"\n"+l.getAutore()+"\n"+l.getEditore()+"\n"+l.getNumeroCopie());
	 
     System.out.println("\nI LIBRI CON MENO DI 15 COPIE:");
	 ricerca=myLibreria.getLibriSottoSoglia(15);
     for(Libro l:ricerca)
    	 System.out.println("\n"+l.getTitolo()+"\n"+l.getAutore()+"\n"+l.getEditore()+"\n"+l.getNumeroCopie());
	 
     myLibreria.modifyLibro(myFile,"FAI BEI SOGNI",30);
     System.out.println("\nSONO STATE AGGIUNTE 30 COPIE AL LIBRO FAI BEI SOGNI.");
     
	}

}
