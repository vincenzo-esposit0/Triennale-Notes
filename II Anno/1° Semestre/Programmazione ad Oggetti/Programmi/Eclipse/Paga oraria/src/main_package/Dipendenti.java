package main_package;

import java.util.*;

public class Dipendenti {
	
	//attributi
	
	private String nome;
	private String cognome;
	private double tariffa;
	private int ore;
	private int ores;
	
	//cotruttore
	
	public Dipendenti (String innome,String incognome,double intariffa) {
		int inore;
		Scanner input=new Scanner(System.in);
		nome=innome;
		cognome=incognome;
		tariffa=intariffa;
		for (int i=0;i<=3;i++) {
			System.out.println("Dammi le ore della settimana: "+i+1);
			inore=input.nextInt();
			if (inore>=40) {
				ores+=inore-40;
				ore+=40;
			}else
				ore=inore;
		}
	}
	
	//restituisce il nome e cognome del dipendente
	
	public String getnoco() {
		return nome+" "+cognome;
	}
	
	//restituisce le ore di lavore
	
	public int getore() {
		return ore;
	}
	
	//restituisce le ore straordinarie
	public int getores() {
		return ores;
	}
	
	//calcola la paga
	
	public double pagatot() {
		double tot=0;
		return tot=(tariffa*ore)+(tariffa*1.5*ores);
	}
}
