import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Scrivere un programma che:
 * Prende in input il nome di un file e una parola chiave.
 * Da in output in un file tutte le righe che contengono la parola chiave.
 * @author XXX
 *
 */
public class TesterEsercizio1 {

	public static void main(String[] args) throws IOException {
		Scanner console=new Scanner(System.in);
		
		File file=new File("esercizio1Input.txt");//Prende da input il nome del file
		
		System.out.println("Inserisci la parola chiave");
		String parolaChiave=console.next();//Prende da input la parola chiave
		
		FileReader fileInput=new FileReader(file); //Per leggere caratteri
		Scanner in=new Scanner(fileInput); //Per leggere intere righe o parole al posto di singoli caratteri
		
		PrintWriter fileOutput=new PrintWriter("esercizio1Output.txt"); //Se il file passato come parametro del costruttore esiste, allora viene svuotato del suo contenuto
																//Se il file non esiste viene creato un file nuovo (vuoto) con il nome passato come parametro del costruttore
		
		String riga=null;
		String parole[];
		
		int count=0;
		while(in.hasNext())
		{
			riga=in.nextLine(); //Prendo la riga
			parole=riga.split(" "); //Scompongo ogni parola della riga
			for(String p:parole) //Controllo se la riga contiene una parola uguale alla parola chiave
			{
				String nuova=p.replaceAll("[^A-Za-z0-9]",""); //Sostituisce tutti i caratteri dalla parola tranne i caratteri alfanumerici
															  //Ad esempio se la parola chiave fosse "stai" e nella riga c'è una parola "stai?" il "?" non verrebbe considerato
				if(nuova.equals(parolaChiave))
				{
					fileOutput.write(riga+"\n");
					count++;
				}
			}
		}
		
		System.out.println("Sono state scritte "+count+" righe");
		in.close();
		fileOutput.close();
		console.close();
	}
}
