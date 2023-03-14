import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Per scrivere file di testo
 * @author XXX
 *
 */
public class FileDiTesto {

	public static void main(String[] args) throws IOException{
		
		File f=new File("prova.txt");

		if(!f.exists())
		{
			f.createNewFile();
			
			System.out.println("File creato!");
			
			//Scrivere su un file
			PrintWriter write=new PrintWriter(f);
			write.println("Ciao a tutti");
			
			//Chiudere sempre il file dopo aver effettuato tutte le operazioni
			write.close();
		}
		else {
			System.out.println("File già esistente!");
			
			//Se il file già esiste si utilizza FileOutputStream per aggiungere righe
			FileOutputStream fos=new FileOutputStream("prova.txt",true);
			
			PrintWriter write=new PrintWriter(fos);
			
			write.append("Vi saluto");
		
		
			write.close();
		}
		
	}

}
