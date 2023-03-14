package it.unisa.lp2.contenitore;

import java.util.*;


public class ElencoContenitori{
	//Costruttore
	public ElencoContenitori() {	
	}
	
	//Metodo add
	public void add(Contenitore x) {
		contenitori.add(x);
	}
	
	//Metodo getContenitore
	public Contenitore getContenitore(int x) {
		return contenitori.get(x);
	}
	
	//Attributi
	protected ArrayList<Contenitore> contenitori=new ArrayList<Contenitore>();
}
