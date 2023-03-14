package main_package;

public class Studente extends Persona {
	public Studente (String nome, int anno, String spec) {
		this.nome=nome;
		this.anno=anno;
		this.spec=spec;
	}
	//Metodo toString
	public String toString() {
		return nome+" "+anno+" "+spec;
	}
	//Attributi
	private String spec;
}
