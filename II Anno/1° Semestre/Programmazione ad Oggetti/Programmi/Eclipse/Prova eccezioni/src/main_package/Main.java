package main_package;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Dammi il valore: ");
		int x=input.nextInt();
		try {
			if(x==0) {
				throw new ProvaException();
			}
		}catch(ProvaException exception) {
			x++;
		}
		System.out.println(x);
	}
}
