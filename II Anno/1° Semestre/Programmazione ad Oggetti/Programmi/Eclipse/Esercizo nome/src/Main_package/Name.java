package Main_package;

public class Name {
	
	private String nome;
	private String cognome;
	private String titolo;
	
	public Name(String inome,String incognome, String intitolo) {
		nome=inome;
		cognome=incognome;
		titolo=intitolo;
	}
	
	public String getini() {
		String ini;
		return ini=nome.substring(0,1)+cognome.substring(0,1);
	}
	
	public String getnome() {
		return nome;
	}
	
	public String getcognome() {
		return cognome;
	}
	
	public String gettitle() {
		return titolo;
	}
	
	public void settitle(String ntitolo) {
		titolo=ntitolo;
	}
}
