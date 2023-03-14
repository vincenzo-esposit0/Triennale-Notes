package main_package;

import java.io.IOException;


public class BankAccount {
	//Costruttore
	public BankAccount(String nomesocio, double saldo) throws IOException {
		if (saldo<=0)
			throw new IOException();
		this.nomesocio=nomesocio;
		this.saldo=saldo;
	}
	//Metodo versa
	public void versa(double x) {
		if (x<=0)
			throw new IllegalArgumentException("Errore nell'inserimento del saldo da versare");
		saldo+=x;
	}
	
	//Metodo preleva
	public void preleva(double x) {
		if (x>saldo)
			throw new IllegalArgumentException("Saldo insufficiente");
		saldo-=x;
	}
	
	//Metodi get
	public double getSaldo() { return saldo;}
	public String getNomeSocio() { return nomesocio;}
	
	//Metodi set
	public void setSaldo(double newsaldo) { saldo=newsaldo;}
	
	//Attributi
	private String nomesocio;
	private double saldo;
}
