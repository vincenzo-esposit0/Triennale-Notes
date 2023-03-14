package it.unisa.prog2.money;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public static class Coin {
	//Costruttore
	public Coin(String iname, double ivalue) {
		assert ivalue>0;
		value=ivalue;
		name=iname;
	}
	//Metodo readfile
	static ArrayList<Coin> readFile(String filename) throws IOException{
		File file=new File (filename);
		Scanner input = new Scanner(file);
		ArrayList<Coin> monete =new ArrayList<Coin>();
		while(input.hasNext()) {
			read(input);
			String str=input.nextLine();
			String nome=str.substring(0, str.indexOf(" "));
			Double valore=Double.parseDouble(str.substring(str.indexOf(" "),str.length()));
			monete.add(new Coin(nome,valore));
		}
		return monete;
	}
	
	//Metodo read
	void read(Scanner in) throws IOException{
		String str=in.nextLine();
		if (!str.contains(" "))
			throw new IOException();		
	}
	
	//Metodi get
	public double getValue() { return value;}
	public String  getName() { return name;}
	
	//Attributi
	private double value;
	private String name;
}
