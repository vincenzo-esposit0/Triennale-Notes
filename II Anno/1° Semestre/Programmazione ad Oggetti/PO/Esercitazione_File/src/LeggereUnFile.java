import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class LeggereUnFile {

	public static void main(String[] args) throws IOException {
		FileReader f=new FileReader("prova.txt");
		//Scanner in=new Scanner(f);
		BufferedReader read=new BufferedReader(f);
		String[] x=new String[0];
		String parola="";
		while( (parola=read.readLine()) !=null )
		{
			System.out.println(parola); //in.next() legge una parola alla volta
		}
		
		f.close();
	}
}
