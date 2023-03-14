package main_package;

public class Serratura {
	
	public Serratura(String incodice) {
		codice=incodice;
	}
	
	public void setPosition(String x) {
		inputcodice+=x;
	}
	
	public void unlock() {
		if (codice.equals(inputcodice))
			copen=true;
		else
			copen=false;
		inputcodice="";
	}
	
	public boolean isOpen() {
		if (copen)
			return true;
		else
			return false;
	}
	
	public void newComb(String x) {
		if (this.isOpen()) {
			codice=x;
			System.out.println("Il nuovo codice è stato settato ed è:" +this.getCodice()+".");
		}
		else
			System.out.println("La cassaforte è chiusa non puoi settare il codice !");		
	}
	
	public void lock() {
		copen=false;
	}
	
	public String getInputCodice() {
		return inputcodice;
	}
	
	public String getCodice() {
		return codice;
	}
	
	private String codice;
	private String inputcodice="";
	private boolean copen=true;
}
