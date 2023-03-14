package main_package;

public class Studente {
	private double votoanalisi;
	private double votoprogrammazione;
	private double votoinglese;
	
	//costruttore
	public Studente(int a, int b , int c) {
		votoanalisi=a;
		votoprogrammazione=b;
		votoinglese=c;
	}
	
	//media esami
	public double Media() {
		return (votoanalisi+votoprogrammazione+votoinglese)/3;
	}
}
