package main_package;

public class Episodio {
	//Costruttore
	public Episodio(String titolo,String nnp) {
		this.titolo=titolo;
		this.trama="";
		this.nnp=nnp;
	}
	//Metodo tostring
	public String toString() {
		return titolo+" "+trama+" "+nnp;
	}
	//Meotodo eguals
	public boolean eguals(Episodio x) {
		if((titolo.compareTo(x.titolo)==0)&&(nnp==x.nnp))
			return true;
		else
			return false;
	}
	//Metodo set
	public void setNnp(String n) { nnp=n;}
	//Metodo getnnp
	public String getNnp() { return nnp;}
	//Attributi
	public String titolo;
	public String trama;
	public String nnp;
}
