import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

public class Serializzazione {

	public static void main(String[] args) 
            throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
        //crea un alunno
        Alunno a1 = new Alunno("Pinco", "Pallino");
        //aggiunge due voti all'alunno
        Voto v;
        v = new Voto("Orale", 5.5f, "10/010/16");
        a1.aggiungiVoto(v);
        v = new Voto("Scritto", 7, "5/11/16");
        a1.aggiungiVoto(v);
        
        //crea un alunno
        Alunno a2 = new Alunno("Marco", "Giordano");
        //aggiunge due voti all'alunno
        v = new Voto("Orale", 6.5f, "10/9/16");
        a2.aggiungiVoto(v);
        v = new Voto("Scritto", 8, "8/9/16");
        a2.aggiungiVoto(v);
                
        //SCRIVE l'oggetto alunno in un FILE BIANARIO tramite la serializzazione
        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("alunno.txt"));
        fbinarioOut.writeObject(a1);
        fbinarioOut.writeObject(a2);//
        fbinarioOut.flush();
        fbinarioOut.close();
        
        //LEGGE l'oggetto alunno salvato nel file, tramite la deserializzazione
        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("alunno.txt"));
        
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("alunno.txt"));
        
        try
        {
        	while(fin.read()!=0) //Oppure fin!=null
        	{
            	Alunno x = (Alunno) fin.readObject();
            	//Visualizza l'oggetto sul monitor, sfruttando  (implicitamente) il suo metodo toString()
                System.out.println(x);
                //Scrive l'oggetto in file di testo, sfruttando  (implicitamente) il suo metodo toString()
                ftestoOut.println(x);
            }
        }catch(EOFException e) //Gestire l'eccezione di terminazione del file
        {
        	System.out.println("Lettura dal file input terminata!");
        }
        
        ftestoOut.close();
    }  
}
