package main_package;

import main_package.Dipendenti;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Dammi il nome del dipendente: ");
		String nome=input.nextLine();
		System.out.println("Dammi il cognome del dipendente: ");
		String cognome=input.nextLine();
		System.out.println("Dammi la tariffa oraria del dipendente: ");
		double tariffa=input.nextDouble();
		Dipendenti d1=new Dipendenti(nome,cognome,tariffa);
		System.out.println("il dipendente "+d1.getnoco()+" ha lavorato nelle ultime 4 settimane");
		System.out.println(d1.getore()+" ore normali e "+d1.getores()+" ore straordinarie per un guadagno di "+d1.pagatot());
		if (d1.getores()>30)
			System.out.println("Chist fa scif fatic tropp");
	}
}
