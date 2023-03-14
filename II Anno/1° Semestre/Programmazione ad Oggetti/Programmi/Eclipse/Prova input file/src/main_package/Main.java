package main_package;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		File nfile=new File ("libri.txt");
		Scanner in=new Scanner (nfile);
		String str=in.nextLine();
		int n=in.nextInt();
		n++;
		System.out.println("Prova: "+n+" "+str); 
		
	}

}
