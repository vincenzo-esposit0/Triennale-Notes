package main_package;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		String[] str = new String[8];
		Scanner input=new Scanner(System.in);
		String z;
		for (int i=0;i<8;i++) {
			System.out.print("Dammi la stringa "+i+" : ");
			str[i]=input.nextLine();
		}
		for(int j=0;j<7;j++)
			for(int i=j+1;i<8;i++) {
				if (str[j].compareTo(str[i])>0) {
					z=str[j];
					str[j]=str[i];
					str[i]=z;
				}
			}
		System.out.println("Le parole vengono ordinate in questo modo: ");
		for (int i=0;i<8;i++)
			System.out.println(str[i]);
	}	
}
