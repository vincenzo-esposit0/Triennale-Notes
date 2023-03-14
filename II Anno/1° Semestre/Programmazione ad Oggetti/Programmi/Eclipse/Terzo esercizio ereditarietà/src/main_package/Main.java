package main_package;

import java.util.*;
import main_package.*;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		ArrayList<Lavoratore> lavoratori=new ArrayList<Lavoratore>();
		Random rand=new Random();
		System.out.print("Dammi il numero di lavoratori da inserire: ");
		int n=Integer.parseInt(input.nextLine());
		System.out.println();
		for(int i=0;i<n;i++) {
			if ((int)(Math.random()*2)==1) {
				System.out.println("Lavoratore con paga fissa: ");
				System.out.print("Dammi il nome: ");
				String nome=input.nextLine();
				System.out.print("Dammi la pagaoraria: ");
				double pagaoraria=Double.parseDouble(input.nextLine());
				lavoratori.add(new LavoratoreFisso(nome,pagaoraria));
				System.out.println();
			}else {
				System.out.println("Lavoratore con paga oraria: ");
				System.out.print("Dammi il nome: ");
				String nome=input.nextLine();
				System.out.print("Dammi la pagaoraria: ");
				double pagaoraria=Double.parseDouble(input.nextLine());
				System.out.print("Dammi il numero di ore: ");
				int ore=Integer.parseInt(input.nextLine());
				lavoratori.add(new LavoratoreOre(nome,pagaoraria,ore));
				System.out.println();
			}
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.println(i+": "+lavoratori.get(i).toString());
		}
	}

}
