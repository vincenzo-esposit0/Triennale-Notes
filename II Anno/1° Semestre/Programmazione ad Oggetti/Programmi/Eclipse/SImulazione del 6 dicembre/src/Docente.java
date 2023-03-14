
public class Docente {
	//Costruttore
	public Docente(String nome, String cognome, String telefono ,String struttura, String corsi) {
		this.nome=nome;
		this.cognome=cognome;
		this.struttura=struttura;
		this.telefono=telefono;
		this.corsi=corsi;
	}
	//Metodi get
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	public String getStruttura() { return struttura; }
	public String getTelefono() { return telefono; }
	public String getCorsi() { return corsi; }
	
	//metodo toString
	public String toString() {
		return nome+", "+cognome+", "+struttura+", "+telefono+", "+corsi;
	}
	
	//Attributi
	private String nome;
	private String cognome;
	private String struttura;
	private String telefono;
	private String corsi;
}
