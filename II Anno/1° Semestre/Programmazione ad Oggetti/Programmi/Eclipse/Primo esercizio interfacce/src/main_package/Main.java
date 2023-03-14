package main_package;

import java.util.*;
import main_package.DataSet;
import main_package.Quiz;

public class Main {
	public static void main(String arg[]) {
		Scanner input=new Scanner(System.in);
		DataSet dataset=new DataSet();
		ArrayList<Quiz> compiti=new ArrayList<Quiz>();
		System.out.print("Dammi il numero di quiz da leggere: ");
		int n=Integer.parseInt(input.nextLine());
		for(int i=0;i<n;i++) {
			System.out.print("Dammi il punteggio del compito "+i+" : ");
			int punteggio=Integer.parseInt(input.nextLine());
			System.out.print("Dammi il voro in lettere del compito "+i+" : ");
			String voto=input.nextLine();
			compiti.add(new Quiz(punteggio,voto));
		}
		for (int i=0;i<n;i++) {
			dataset.add(compiti.get(i));
		}
		System.out.println("La media è: "+dataset.getAverage());
		int i=0;
		while (compiti.get(i).getPunteggio()!=dataset.getMaximum().getMeasure()) { i++;}
			System.out.print("Il punteggio massimo è "+dataset.getMaximum().getMeasure());
			System.out.println(" con voto "+compiti.get(i).getVoto()+".");
		
	}
}
