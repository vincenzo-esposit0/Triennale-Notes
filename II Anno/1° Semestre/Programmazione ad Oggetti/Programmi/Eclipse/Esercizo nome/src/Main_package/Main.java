package Main_package;

import Main_package.Name;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.print("Dammi il nome della persona: ");
		String nome=input.nextLine();
		System.out.println("Dammi il cognome della persona: ");
		String cognome=input.nextLine();
		System.out.println("Dammi il titolo della persona: ");
		String titolo=input.nextLine();
		Name n1=new Name(nome,cognome,titolo);
		System.out.println("Le iniziali sono: "+n1.getini());
		System.out.println("I dati sono: "+n1.getnome()+" "+n1.getcognome());
		System.out.println("I dati sono: "+n1.getcognome()+" "+n1.getnome());
		System.out.println("IL titolo della persona �: "+n1.gettitle());
	}

}
