package main_package;

public class LavoratoreFisso extends Lavoratore {
	//Costruttore
	public LavoratoreFisso(String nome,double pagaoraria) {
		super(nome,pagaoraria);
	}
	
	//Calcola la paga settimana
	public double pagaSet() {
		return 40*pagaoraria;
	}
	
	//Metodo toString
	public String toString() {
		return nome+" "+pagaoraria+" "+this.pagaSet();
	}
}
