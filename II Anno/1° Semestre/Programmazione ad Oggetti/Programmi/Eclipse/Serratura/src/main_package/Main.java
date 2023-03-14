package main_package;

import java.util.*;
import main_package.Serratura;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String ip;
		String incombinazione;
		do {
			System.out.print("Dammi la combinazione iniziale della cassaforte: ");
			incombinazione=input.nextLine();
		}while(incombinazione.length()!=3);
		incombinazione=incombinazione.toUpperCase();
		Serratura sr=new Serratura(incombinazione);
		System.out.println("La combinazione in cui è stata settata la serratura è: "+sr.getCodice()+".");
		System.out.print("Attualmente la serratura è ");
		if (sr.isOpen())
			System.out.println("aperta.");
		else
			System.out.println("chiusa.");
		System.out.println("Chiudo la serratura...");
		sr.lock();	
		while(!incombinazione.equals("117")){
			System.out.println();
			System.out.println("Cosa vuoi fare: ");
			System.out.println("1) Inserire il codice della serratura. ");
			System.out.println("2) Provare ad aprire la cassaforte. ");
			System.out.println("3) Verificare che la serratura è aperta.  ");
			System.out.println("4) Chiudere la serratura. ");
			System.out.println("5) Settare una nuova combinazione. ");
			System.out.print("Fai la tua scelta: ");
			System.out.println();
			int x=input.nextInt();
			switch (x) {
			case 1:
				System.out.print("Dammi il codice: ");
				do {	
					ip=input.nextLine();
				}while(ip.length()!=3);
				ip=ip.toUpperCase();
				sr.setPosition(ip);
				System.out.println("Il codice inserito è: "+sr.getInputCodice()+".");
				System.out.println("Provo ad aprire la serratura...");
				sr.unlock();
				if (sr.isOpen())
					System.out.println("La serratura è stata aperta");
				else
					System.out.println("La serratura è rimasta chiusa");
				break;
			case 2:
				System.out.println("Provo ad aprire la serratura...");
				sr.unlock();
				break;
			case 3:
				if (sr.isOpen())
					System.out.println("La serratura è aperta");
				else
					System.out.println("La serratura è chiusa");
				break;
			case 4:
				System.out.println("Chiudo la serratura...");
				sr.lock();
				break;
			case 5:
				System.out.print("Dammi la nuova combinazione: ");
				do {
					incombinazione=input.nextLine();
				}while(incombinazione.length()!=3);
				incombinazione=incombinazione.toUpperCase();
				sr.newComb(incombinazione);
				break;
			}
		}	
	}
}
