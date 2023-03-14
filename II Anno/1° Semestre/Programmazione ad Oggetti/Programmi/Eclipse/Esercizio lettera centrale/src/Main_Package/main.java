package Main_Package;

import java.util.*;

public class main{
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Dammi la stringa");
		String s;
		do {
			s=input.nextLine();
		}while (s.length()<2);
		int n=s.length()/2;
		System.out.println("La lettera centrale della frase è: "+s.substring(n,n+1));
		System.out.print("La parola con le lettere invertite è: ");
		System.out.println(s.substring(s.length()-1).concat(s.substring(1,s.length()).concat(s.substring(0,1))));
		String ap=s.substring(s.length()/2);
		System.out.println("La parola invertita a metà è uguale a: "+ap.concat(s.substring(0,s.length()/2)));
		System.out.print("La prima lettera si ripete nelle posizioni: ");
		for(int i=1;i<s.length();i++) {
			System.out.print(s.substring(i,i+1));
			System.out.print(s.substring(0,1));
			System.out.print(i);
			if (s.substring(i,i+1)==s.substring(0,1)) {
				System.out.print(i);
			}
		}
		System.out.println();
		ap=s.toUpperCase();
		System.out.println("La stringa con il primo carattere grande è: "+ ap.substring(0,1).concat(s.substring(1)));		
	}
}
