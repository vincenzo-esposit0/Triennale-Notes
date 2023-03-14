package main_package;

public class TestDue implements Comparable{
	//Costruttore
	public TestDue(String parola) {
		this.parola=parola;
	}
	
	//Metodo dell'intefaccia
	public String getCompare() {
		return parola;
	}
	
	//Attributi
	private String parola;
}
