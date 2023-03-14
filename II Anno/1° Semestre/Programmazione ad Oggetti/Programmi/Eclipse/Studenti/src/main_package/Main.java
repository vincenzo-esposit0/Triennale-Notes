package main_package;

import java.util.*;
import main_package.Studente;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("dammi i tre voti: ");
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		Studente stud=new Studente(a,b,c);
		System.out.println("La media è: "+stud.Media());
	}

}
