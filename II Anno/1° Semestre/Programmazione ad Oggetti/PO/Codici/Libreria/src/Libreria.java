import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria 
{
	private ArrayList<Libro> libreria;

	public Libreria()
	{
		this.libreria=new ArrayList<Libro>();
	}
	
	public void addLibro(Libro libro)
	{
		libreria.add(libro);
	}
	
	public Libro getLibro(int i)
	{
		return libreria.get(i);
	}
	
	//Scrittura dei dati contenuti in memoria nel file
	public void toFile(PrintStream printer)
	{
		Libro libro;
		
		for (int i=0; i<libreria.size();i++)
		{
			libro = libreria.get(i);
			printer.println(libro.getTitolo());
			printer.println(libro.getAutore());
			printer.println(libro.getEditore());
			printer.println(libro.getNumeroCopie());
			printer.println(""); //linea per indentare meglio il file
		}
	}
	
	public void fromFile(Scanner scanner)
	{
		String titolo, autore, editore, numeroCopie;
		this.libreria = new ArrayList<Libro>();
		
		while(scanner.hasNext())
		{
			titolo = scanner.nextLine();
			autore = scanner.nextLine();
			editore = scanner.nextLine();
			numeroCopie = scanner.nextLine();
			scanner.nextLine(); // eliminazione new line aggiunto in precedenza
			libreria.add(new Libro(titolo,autore,editore,Integer.parseInt(numeroCopie)));
		}
	}
	
	public Libro searchByTitolo(String titolo)
	{
		Libro libro = null;
		for (Libro l : libreria)
		{
			if(l.getTitolo().equalsIgnoreCase(titolo))
				libro = l;
		}
		
		return libro;
	}
	
	public ArrayList<Libro> searchByString(String string)
	{
		ArrayList<Libro> searched = new ArrayList<Libro>();
		
		for(Libro libro : libreria)
		{
			if(libro.getTitolo().contains(string))//ricerca autore nell'arrayList
				searched.add(libro);
		}
		
		return searched;
	}
	
	public ArrayList<Libro> searchByAutore(String autore)
	{
		ArrayList<Libro> searched = new ArrayList<Libro>();
		
		for(Libro libro : libreria)
		{
			if(libro.getAutore().equalsIgnoreCase(autore))//ricerca autore nell'arrayList
				searched.add(libro);
		}
		
		return searched;
	}
	
	public ArrayList<Libro> searchCopieMax()
	{
		ArrayList<Libro> searched = new ArrayList<Libro>();
		int max = this.copieMassime();
		
		for ( Libro libro : libreria)
		{
			if(libro.getNumeroCopie()==max)
				searched.add(libro);
		}
		
		return searched;
	}
	
	public int copieMassime()
	{
		int max=0;
		for(Libro libro : libreria)
		{
			if (libro.getNumeroCopie()>max)
				max=libro.getNumeroCopie();
		}
	return max;
	}
	
	public ArrayList<Libro> getLibriSottoSoglia(int copie)
	{
		ArrayList<Libro> searched = new ArrayList<Libro>();
		
		for(Libro libro:libreria)
		{
			if(libro.getNumeroCopie()<copie)
				searched.add(libro);
		}
	return searched;
	}
	
	public void modifyLibro(File file, String titolo, int copie) throws Exception
	{
		Libro libro = this.searchByTitolo(titolo);
		
		//verifica esistenza libro
		if(libro!=null)
		{
			libro.setNumeroCopie(libro.getNumeroCopie()+copie);
			this.toFile(new PrintStream(file));
		}
	}
	
}

	
