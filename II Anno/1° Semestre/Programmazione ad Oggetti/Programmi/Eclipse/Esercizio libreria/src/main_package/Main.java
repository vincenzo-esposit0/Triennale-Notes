package main_package;

import main_package.Libreria;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		System.out.print("Dammi il nome del file: ");
		String nfile=input.nextLine();
		Libreria lib=new Libreria(nfile);
		System.out.println("Nella libreria sono presenti i seguenti libri: ");
		lib.getLibri();
		System.out.println();
		lib.libriAutore("Camilleri Andrea");
		System.out.println();
		lib.stringTitolo("sogni");
		System.out.println();
		lib.libriAtMax();
		System.out.println();
		lib.libroFinished(15);
		System.out.println();
		lib.modCopie(30, "Fai bei sogni");
		System.out.println();
		System.out.println("Libreria aggiornata: ");
		lib.getLibri();
	}

}
