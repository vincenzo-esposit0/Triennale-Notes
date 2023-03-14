package main_package;

import java.util.*;

public class Supermercato {
	//Costruttore
	public Supermercato() {
	}
	
	//Metodo daiTipoProdotto
	public String daiTipoProdotto(int i) {
		if(prodotti.get(i) instanceof Alimentare)
			return "Alimentare";
		else
			return "Elettronico";
	}
	
	//Metodo getMinimo
	public Prodotto getMinimo() {
		double min=prodotti.get(0).prezzo;
		Prodotto ppmin=prodotti.get(0);
		for(int i=0;i<prodotti.size();i++) {
			if(prodotti.get(i).prezzo<min) {
				min=prodotti.get(i).prezzo;
				ppmin=prodotti.get(i);
			}
		}
		return ppmin;
	}
	
	//Metodo getMassimo
	public Prodotto getMassimo() {
		double max=prodotti.get(0).prezzo;
		Prodotto ppmax=prodotti.get(0);
		for(int i=0;i<prodotti.size();i++) {
			if(prodotti.get(i).prezzo>max) {
				max=prodotti.get(i).prezzo;
				ppmax=prodotti.get(i);
			}
		}
		return ppmax;
	}
	
	//Metodo cerca
	public ArrayList<Prodotto> cerca(String marca){
		ArrayList<Prodotto> pmarca=new ArrayList<Prodotto>();
		for(int i=0;i<prodotti.size();i++) {
			if (prodotti.get(i).marca.compareTo(marca)==0)
				pmarca.add(prodotti.get(i));
		}
		return pmarca;
	}
	
	//Attributi
	private ArrayList<Prodotto> prodotti=new ArrayList<Prodotto>();
	
}
