package main_package;

import java.util.*;
import main_package.*;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Dammi l'anno:  ");
		int an=input.nextInt();
		Year anno=new Year(an);
		int me;
		do {
			System.out.print("Dammi il mese:  ");
			me=input.nextInt();
		}while ((me<0)||(me>12));
		Month mese=new Month(me);
		if (anno.isLeapYear()) {
			System.out.println("l'anno "+anno.getYear()+" è bisestile.");
			if (me==2)
				System.out.println("Il mese è "+mese.getMonth()+" formato da "+(mese.getDays()+1)+" giorni.");
			else
				System.out.println("Il mese è "+mese.getMonth()+" formato da "+mese.getDays()+" giorni.");
		}
		else {
			System.out.println("l'anno "+anno.getYear()+" non è bisestile.");
			System.out.println("Il mese è "+mese.getMonth()+" formato da "+mese.getDays()+" giorni.");
		}
	}
}
