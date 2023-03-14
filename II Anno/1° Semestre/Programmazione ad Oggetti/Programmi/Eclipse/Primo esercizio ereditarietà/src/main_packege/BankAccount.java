package main_packege;

public class BankAccount {
	
	//Deposita un tot sul conto
	public void Deposit(double tot) { saldo+=tot;}
	
	//Metodi get
	public double getSaldo() { return saldo;}
	public String getIntestatario() { return intestatario;}
	
	//Metodi set
	public void setSaldo(double saldo) { this.saldo=saldo;}
	public void setIntestatario(String intestatario) { this.intestatario=intestatario;}
	
	//Attributi
	protected double saldo;
	protected String intestatario; 
}
