package main_package;


import main_package.*;

public class Main {
	public static void main(String[] args) {
		Studente st1=new Studente("pippo",1999,"matematica");
		Insegnante d1=new Insegnante("pippo",1999,1200);
		System.out.println("Studente: "+st1.toString());
		System.out.println("Insegnante: "+d1.toString());
	}
}
