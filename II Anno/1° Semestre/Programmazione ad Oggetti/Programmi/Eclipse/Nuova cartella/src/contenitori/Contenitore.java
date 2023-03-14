package contenitori;

public class Contenitore implements Cloneable, Comparable{
	
	public Contenitore(String nome, String codice, double prezzo, double capienza)
	{
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
		this.capienza = capienza;
	}
	
	public void setNome(String nome) {
		this.nome = nome;		
	}
	
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public void setCapienza(double capienza) {
		this.capienza = capienza;		
	}
	
	public String getName()
	{
		return this.nome;
	}
	
	public String getCodice()
	{
		return this.codice;
	}
	
	public double getPrezzo() {
		return this.prezzo;
	}
	
	public double getCapienza()
	{
		return this.capienza;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[Nome: " + this.nome + "]" +
				"[Codice: " + this.codice + "]" +
				"[Prezzo: " + this.prezzo + "]" +
				"[Capienza: " + this.capienza + "]";
	}
	
	@Override
	public boolean equals(Object otherObject){
		if (otherObject == null) 
			return false;
		
		if(getClass() != otherObject.getClass())
			return false;
		
		Contenitore c1 = (Contenitore) otherObject;
		return this.nome.equals(c1.getName()) && this.codice.equals(c1.getCodice()) &&
					this.capienza == c1.getCapienza() && this.prezzo == c1.getPrezzo();
		
	}
	
	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}
	
	public int compareTo(Object o) 
	{
		if(o instanceof Contenitore)
		{
			Contenitore c1 = (Contenitore) o;
			
			if(c1.getName().compareTo(this.nome) > 1 && c1.getCodice().compareTo(this.codice) > 1)
				return 1;//Maggiore
			
			if(c1.getName().compareTo(this.nome) < 1 && c1.getCodice().compareTo(this.codice) < 1)
				return 0;//Minore
			
		}
		return -1;
	}
	
	
	private String nome;
	private String codice;
	private double prezzo;
	private double capienza;

}
