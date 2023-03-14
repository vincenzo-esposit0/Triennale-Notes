import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubrica {
	//Costruttore
	public Rubrica(String n_file) throws FileNotFoundException {
		File file=new File(n_file);
		Scanner input=new Scanner(file);
		while(input.hasNext()) {
			String nome=input.nextLine();
			String cognome=input.nextLine();
			String struttura=input.nextLine();
			String telefono=input.nextLine();
			String corsi=input.nextLine();
			docenti.add(new Docente(nome,cognome,struttura,telefono,corsi));
		}
		
	}
	//Metodo ricercaGlobale
	public ArrayList<Docente> ricercaGlobale(String nome ,String cognome ,String struttura) {
		for(int i=0;i<docenti.size();i++) {
			if ((ricercaNome(docenti.get(i),nome))&&(ricercaCognome(docenti.get(i),cognome))&&(ricercaStruttura(docenti.get(i),struttura)))
				return docenti.get(i);
		}
		return null;
	}
	
	//Metodo di ricerca per nome
	public boolean ricercaNome(Docente dc,String x) {
		if (x.compareTo("")==0)
			return true;
		if ((dc.getNome().compareTo(x)==0)||(dc.getNome().substring(0,x.length()).compareTo(x)==0))
			return true;
		else
			return false;
	}
	
	//Metodo di ricerca per cognome
	public boolean ricercaCognome(Docente dc,String x) {
		if (x.compareTo("")==0)
			return true;
		if ((dc.getCognome().compareTo(x)==0)||(dc.getCognome().substring(0,x.length()).compareTo(x)==0))
			return true;
		else
			return false;
	}
	
	//Metodo di ricerca per struttura
	public boolean ricercaStruttura(Docente dc,String x) {
		if (x.compareTo("")==0)
			return true;
		if ((dc.getStruttura().compareTo(x)==0)||(dc.getStruttura().substring(0,x.length()).compareTo(x)==0))
			return true;
		else
			return false;
	}
	

	
	//Attributi
	private ArrayList<Docente> docenti=new ArrayList<Docente>();
	
}
