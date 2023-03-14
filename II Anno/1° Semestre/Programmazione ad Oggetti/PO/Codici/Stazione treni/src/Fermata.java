public class Fermata {

	public Fermata(String nomeFermata, String orario)
	{
		this.nomeFermata=nomeFermata;
		this.orario=orario;
	}
	
	public String getNomeFermata()
	{
		return nomeFermata;
	}
	
	public String getOrario()
	{
		return orario;
	}
	
	public String toString()
	{
		return getNomeFermata() + " " + getOrario();
	}
	
	private String nomeFermata;
	private String orario;
}
