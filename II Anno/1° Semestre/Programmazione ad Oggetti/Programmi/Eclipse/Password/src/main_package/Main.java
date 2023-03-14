package main_package;

import java.util.*;
import main_package.Password;

public class Main {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		Password pass=new Password();
		String password;
		do {
			System.out.print("Dammi la nuova password: ");
			password=input.nextLine();
		}while (!pass.passwordCeck(password));
		System.out.println("La password soddisfa i requisiti...");
	}
}
