package money;

public class ContoCorrente {
	//Costruttori
	public ContoCorrente() {
		nconto=numeroconto;
		saldo=0;
	}
	public ContoCorrente(double isaldo) {
		nconto=numeroconto++;
		saldo=isaldo;
	}
	
	//Deposita una somma nel conto (importo>=0)
	public void deposita(double importo) {
		assert importo>=0;
		saldo+=importo;
	}
	//preleva una somma dal conto (importo <=saldo)
	public void preleva(double importo) {
		assert importo<=saldo;
		saldo-=importo;
	}
	//ritorna il saldo
	public double getSaldo() { return saldo;}
	//ritorna il numero del conto
	public int getNumeroConto() { return nconto;}
	
	
	//Attributi
	private static int numeroconto=1;
	private int nconto;
	private double saldo;
}