package main_package;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("Dammi il nome del file: ");
		String str="file.txt";
		System.out.println("Dammi la parola chiave: ");
		String kstr="pizza";
		File file=new File(str);
		System.out.println();
		try {
			Scanner fin=new Scanner(file);
			while (fin.hasNextLine()) {
				String line=fin.nextLine();
				String [] parole=line.split(" ");
				for(int i=0;i<parole.length;i++) {
					if (parole[i].compareTo(kstr)==0)
						System.out.println(line);
				}
			}
		}catch (IOException exception) {
			System.out.println("Errore nell'apertura del file...");
		}
		
	}

}
