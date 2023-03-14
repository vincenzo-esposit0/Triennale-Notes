package main_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Azienda {
	//Costruttore
	public Azienda(String nomefile) throws FileNotFoundException {
		dipendenti =new ArrayList<Dipendente>();
		file = new File(nomefile);
		input= new Scanner(file);
		while (input.hasNext()) {
			String cognome=input.nextLine();
			String nome=input.nextLine();
			String cfiscale=input.nextLine();
			int stipendio=Integer.parseInt(input.nextLine());
			dipendenti.add(new Dipendente(cognome,nome,cfiscale,stipendio));
		}
	}
	
	//Dipendenti che guadagnano più di una certa somma
	public ArrayList<Dipendente> dMSomma (int stipendio){
		ArrayList<Dipendente> dipm= new ArrayList<Dipendente>();
		for(int i=0;i<dipendenti.size();i++) {
			if (dipendenti.get(i).getStipendio()>=stipendio)
				dipm.add(dipendenti.get(i));
		}
		return dipm;
	}
	
	//Dipendeti con un determinato nome cognome
	public ArrayList<Dipendente> dNome (String txt){
		ArrayList<Dipendente> dipm= new ArrayList<Dipendente>();
		for(int i=0;i<dipendenti.size();i++) {
			if ((dipendenti.get(i).getNome().compareTo(txt)==0)||(dipendenti.get(i).getCognome().compareTo(txt)==0))
				dipm.add(dipendenti.get(i));
		}
		return dipm;
	}
	
	//Dipendeti con stipendio minimo
	public Dipendente dMStipendio() {
		Dipendente min=dipendenti.get(0);
		for(int i=1;i<dipendenti.size();i++) {
			if ((dipendenti.get(i).getStipendio()<min.getStipendio()))
				min.setStipendio(dipendenti.get(i).getStipendio());
		}
		return min;
	}
	
	//Aggiorna dipendenti stipendio
	public void aStipendio(double per) throws IOException {
		PrintStream out = new PrintStream(file);
		for(int i=0;i<dipendenti.size();i++) {
			out.println(dipendenti.get(i).getCognome());
			out.println(dipendenti.get(i).getNome());
			out.println(dipendenti.get(i).getCfiscale());
			out.println(dipendenti.get(i).getStipendio()-dipendenti.get(i).getStipendio()*per);				
		}
	}
	
	//Attributi
	private ArrayList<Dipendente> dipendenti;
	private Scanner input;
	private File file;
	
}
