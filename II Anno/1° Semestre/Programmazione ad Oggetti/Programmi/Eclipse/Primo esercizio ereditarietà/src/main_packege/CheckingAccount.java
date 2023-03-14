package main_packege;

public class CheckingAccount extends BankAccount{
	//Costruttore
		public CheckingAccount(String intestatario,double saldo) {
			this.saldo=saldo;
			this.intestatario=intestatario;
			numerotransazioni=0;
		}
	//Prelievo
		public double prelievo(double tot) {
			if (saldo-tot>=0) {
				saldo-=tot;
				numerotransazioni++;
				return saldo;
			}else
				return 0;
		}
	
	//Deposita
		public void dopista (double tot) {
			saldo+=tot;
			numerotransazioni++;
		}
		
	//Ritorna il numero di transazioni
		public int numerotransazioni() { return numerotransazioni;}
		
	//Attributi
	private int numerotransazioni;
}
