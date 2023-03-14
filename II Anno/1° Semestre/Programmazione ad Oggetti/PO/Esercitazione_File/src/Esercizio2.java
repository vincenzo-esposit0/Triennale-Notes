import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Scrivere un programma capace di cifrare e decifrare file di testo. 
 * La cifratura avviene aggiungendo un intero k ad ogni byte del file. 
 * Il programma dovrà chiedere all’utente di inserire:
 * 1) il nome del file di input
 * 2) il nome del file di output
 * 3) la chiave di cifratura k,
 * - effettuerà la cifratura del file di input salvando il risultato nel file di output.
 * - La decifratura corrisponde a cifrare con -k.
 * @author XXX
 *
 */
public class Esercizio2 {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		Scanner console=new Scanner(System.in);
		
		System.out.println("Inserisci il nome del file input");
		String input=console.next();
		System.out.println("Inserisci il nome del file output");
		String output=console.next();
		System.out.println("Inserisci la chiave di cifratura come un intero");
		int chiave=console.nextInt();
		
		FileInputStream fin=new FileInputStream(new File(input));
		FileOutputStream fout=new FileOutputStream(new File(output));
		
		
		int singloByte;
        while ((singloByte = fin.read()) != -1) {
            fout.write(singloByte+=chiave);
        }
		
		FileReader fr=new FileReader(output);
		Scanner fileScanner=new Scanner(fr);
		
		while(fileScanner.hasNext())
		{
			System.out.println(fileScanner.next());
		}
		
		fin.close();
		fout.close();
		console.close();
	}
}
