
public class Libro {
	
	public Libro (String titolo, String autore, String editore, int numeroCopie)
	{
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.numeroCopie = numeroCopie;
	}
	
	public String getTitolo()
	{
		return titolo;
	}
	
	public String getAutore()
	{
		return autore;
	}
		
	public String getEditore()
	{
		return editore;
	}
	
	public int getNumeroCopie()
	{
		return numeroCopie;
	}
	
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}
	
	public void setAutore(String autore)
	{
		this.autore=autore;
	}
	
	public void setEditore(String editore)
	{
		this.editore=editore;
	}
	
	public void setNumeroCopie(int numeroCopie)
	{
		this.numeroCopie= numeroCopie;
	}
	
	private String titolo;
	private String autore;
	private String editore;
	private int numeroCopie;
}
