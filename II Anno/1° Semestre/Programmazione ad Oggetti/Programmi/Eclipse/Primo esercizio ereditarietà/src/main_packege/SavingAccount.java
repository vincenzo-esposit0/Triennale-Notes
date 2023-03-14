package main_packege;

public class SavingAccount extends BankAccount {
	//Costruttore
	public SavingAccount(String intestatario,double saldo,double interestRate,double minsaldo) {
		this.saldo=saldo;
		this.intestatario=intestatario;
		this.interestRate=interestRate;
		this.minsaldo=minsaldo;
	}
	//Setta gli interessi del conto
	public void setInterestrate(double interestRate) {
		this.interestRate=interestRate;
	}
	//metodi get
	public double getInterestRate() { return interestRate;}
	
	//Calcola gli interessi
	public double addInterest() {
		double interessi;
		if (saldo>minsaldo) {
			interessi=saldo*interestRate/100;
			saldo+=interessi;
			return interessi;		
		}else
			return 0;
	}
	
	//Preleva un tot dal conto
	public double prelievo(double tot) {
		if ((saldo-tot>=0)&&(saldo-tot>minsaldo)) {
			saldo-=tot;
			return saldo;
		}else
			return 0;
	}
	
	//Attributi
	private double interestRate;
	private double minsaldo;
}
