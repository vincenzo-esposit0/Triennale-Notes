package main_package;

public class Insegnante extends Persona{
	public Insegnante (String nome, int anno, double stipendio) {
		this.nome=nome;
		this.anno=anno;
		this.stipendio=stipendio;
	}
	public String toString() {
		return nome+" "+anno+" "+stipendio;
	}
	//Attributi
	private double stipendio;
}
