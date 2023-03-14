package main_package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String arg[]) throws IOException {
		Azienda az=new Azienda("file.txt");
		System.out.println();
		System.out.println("Maggiore di 1500:");
		ArrayList<Dipendente> d = az.dMSomma(1500);
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i).toString());
		}
		System.out.println();
		System.out.println("Gianni come nome o cognome:");
		ArrayList<Dipendente> c = az.dNome("Gianni");
		for(int i=0;i<c.size();i++) {
			System.out.println(c.get(i).toString());
		}
		System.out.println();
		System.out.println("Stipendio minimo: " +az.dMStipendio().toString());
		az.aStipendio(0.05);	
	}
}
