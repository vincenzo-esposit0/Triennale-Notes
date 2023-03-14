package main_package;

public class Country implements Comparable{
	//Costruttore
	public Country (String nome,int superficie) {
		this.nome=nome;
		this.superficie=superficie;
	}
	
	//Metodo dell'intefaccia
	public String getCompare() {
		return Integer.toString(superficie);
	}
	
	//Ritorna il nome
	public String getNome() {return nome;}
	
	//Attributi
	private String nome;
	private int superficie;
}
