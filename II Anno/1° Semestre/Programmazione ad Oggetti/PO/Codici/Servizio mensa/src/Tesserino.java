
public abstract class Tesserino {
	public Tesserino(String codice, String nome, String cognome, boolean attivo){
		this.codice = codice ;
		this.nome = nome;
		this.cognome=cognome;
		this.attivo=attivo;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	public String getCodice()
	{
		return codice;
	}
	
	public boolean getAttivo()
	{
		return attivo;
	}
	
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	
	public void setCognome(String cognome)
	{
		this.cognome=cognome;
	}
	
	public void setCodice(String codice)
	{
		this.codice=codice;
	}
	
	public void attiva(boolean attivo)
	{
		if(attivo==true)
		{
			throw new RuntimeException();
		}
		else attivo = true;
	}
	
	public void disattiva(boolean attivo)
	{
		if(attivo==false)
		{
			throw new RuntimeException();
		}
		else attivo = false;
	}
	
	public abstract double paga();
	
	public String toString()
	{
		return "codice" + codice + "nome" + nome + "cognome" + cognome + "attivo" + attivo;
	}
	
	public boolean equals(Object obj){
		if (obj!=null) return false;
		
		if(!(obj instanceof Tesserino)) return false;
		
		Tesserino t = (Tesserino) obj;
		return (this.codice == t.codice &&
				this.nome==t.nome &&
				this.cognome==t.cognome &&
				this.attivo== t.attivo);
	}
	
	private String codice;
	private String nome;
	private String cognome;
	private boolean attivo;
}
