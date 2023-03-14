package main_package;

public class LavoratoreOre extends Lavoratore{
	//Costruttore
	public LavoratoreOre(String nome,double pagaoraria,int ore) {
		super(nome,pagaoraria);
		this.ore=ore;	
	}
	
	//Calcola la paga settimanale
	public double pagaSet() {
		if (ore>=40)
			return ((40*pagaoraria)+((ore-40)*pagaoraria*1.5));
		else
			return ore*pagaoraria;
	}
	
	//Metodo toString
	public String toString() {
		return nome+" "+ore+" "+pagaoraria+" "+this.pagaSet();
	}
	
	//Attributi
	private int ore;
}
