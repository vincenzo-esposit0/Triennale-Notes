package default_package;

import it.unisa.prog2.money.*;
import java.util.*;

public class MoneyTest {
	public static void main(String[] args) {
		int x;
		Scanner input=new Scanner(System.in);
		Purse purse=new Purse();
		do {
			System.out.println("Menu: ");
			System.out.println("1) Aggiungi una moneta alla borsa. ");
			System.out.println("2) Stampa il totale della borsa ");
			System.out.print("Fai la tua scelta: ");
			x=Integer.parseInt(input.nextLine());
			switch (x) {
			case 1:
				System.out.print("Dammi il nome della moneta: ");
				String name=input.nextLine();
				System.out.print("Dammi il valore della moneta: ");
				String value=input.nextLine();
				purse.addCoin(new Coin(name,Double.parseDouble(value)));
				break;
			case 2:
				System.out.println("Il totale della borsa è: "+purse.getTotal());
				break;	
			}
		}while(x!=117);
	}
}
