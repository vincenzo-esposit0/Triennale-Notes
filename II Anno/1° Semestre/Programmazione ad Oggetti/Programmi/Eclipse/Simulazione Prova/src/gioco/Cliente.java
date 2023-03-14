package gioco;

import java.util.*;

public class Cliente {
	//Costruttore
	public Cliente(String codfisc,double saldo) {
		this.saldo=saldo;
		this.codfisc=codfisc;
	}

	//Metodo acquista Ambata
	public boolean acquista(double valore,boolean tipo) {
		if (saldo-valore>=0) {
			if (tipo) {
				biglietti.add(new Ambata(valore));
				System.out.println("Acquistato biglietto Ambata");
				saldo-=valore;
				return true;
			}
			else {
				biglietti.add(new CartaAlta(valore));
				System.out.println("Acquistato biglietto CartaAlta");
				saldo-=valore;
				return true;
			}
		}else
			return false;	
	}
	
	//metodo gioca
	public void gioca() {
		for(int i=0;i<biglietti.size();i++) {
			if(biglietti.get(i).gioca()) {
				System.out.println("Vinto tot: "+biglietti.get(i).getVincità());
				saldo+=biglietti.get(i).getVincità();
			}else
				System.out.println("Perso");
		}
	}
	
	//Metodo toString
	public String toString() {
		return codfisc+" "+saldo;
	}
	//Attributi
	private String codfisc;
	private double saldo;
	private ArrayList<GiocoDazzardo> biglietti=new ArrayList<GiocoDazzardo>();
}
