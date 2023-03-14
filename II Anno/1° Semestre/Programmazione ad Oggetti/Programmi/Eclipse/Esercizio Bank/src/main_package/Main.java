package main_package;

import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException {
		try {
		BankAccount ba=new BankAccount("Sonno",10);
		ba.versa(10);
		ba.preleva(30);
		}
		catch (IOException exception){
			System.out.println("Saldo inserito non valido");
		}
		catch (IllegalArgumentException exception) {
			System.out.println("Prova");
		}
		
	}
}
