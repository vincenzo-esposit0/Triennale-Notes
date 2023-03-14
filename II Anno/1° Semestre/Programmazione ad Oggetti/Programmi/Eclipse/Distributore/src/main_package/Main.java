package main_package;

import java.util.*;
import main_package.Distributore;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Distributore dis=new Distributore(10,0,15);
		int x=1;
		while(x==1){
			System.out.print("Vuoi inserire un gettone [S/N]: ");
			String str=input.nextLine();
			if (str.equals("S")) {
				if (!dis.Acquisto())
					System.out.println("Lattine esaurite...");
			}
			else {
				System.out.print("Vuoi ricaricare il distributore [S/N]: ");
				str=input.nextLine();
				if (str.equals("S")) {
					System.out.print("Quante lattine vuoi caricare: ");
					int newl=input.nextInt();
					if (dis.Ricarica(newl))
						System.out.println("Ricarica avvenuta con successo...");
					else
						System.out.println("Le bottiglie eccedono il carico massimo del distributore...");
				}
				else
					System.out.println("Gettoni: "+dis.getgettoni()+" lattine: "+dis.getlattine());
			}	
		
		}
	}

}
