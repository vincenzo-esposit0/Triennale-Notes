
public class TesserinoPersonale extends Tesserino{
	public TesserinoPersonale(String facolt�, double sommaSpesa, boolean categoria,
			String codice, String nome, String cognome, boolean attivo)
	{
	
	super(codice, nome, cognome, attivo);
		this.facolt�=facolt�;
		this.sommaSpesa=sommaSpesa;
		this.categoria=categoria;
	}
	
	public double paga()
	{
		double importoDocente = 5.60;
		double importoAmministrativo = 4.00;
		if(categoria==true)
			{sommaSpesa = sommaSpesa+importoDocente;
			return sommaSpesa;}
		else
			{sommaSpesa = sommaSpesa+importoAmministrativo;
			return sommaSpesa;}
	}
	
	public void cambiaCategoria(TesserinoPersonale tp)
	{
		if(tp.categoria==false)
			tp.categoria=true;
		else
			tp.categoria=false;
	}
	
	public boolean getCategoria()
	{
		return categoria;
	}
	
	public String getFacolt�()
	{
		return facolt�;
	}
	
	public double getSommaSpesa()
	{
		return sommaSpesa;
	}
	
	public void setFacolt�(String facolt�)
	{
		this.facolt�=facolt�;
	}
	
	public void setSommaSpesa(double sommaSpesa)
	{
		this.sommaSpesa=sommaSpesa;
	}
	
	public void setCategoria(boolean categoria)
	{
		this.categoria=categoria;
	}
	
	public String toString()
	{
		return super.toString() +
		"facolt�" + facolt� +
		"sommaSpesa" + sommaSpesa +
		"categoria" + categoria;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject)) return false;
		TesserinoPersonale other = (TesserinoPersonale) otherObject;
		return (facolt�.equals(other.getFacolt�()) 
				&& sommaSpesa==(other.getSommaSpesa())
				&& categoria==(other.getCategoria()));
	}
	
	private String facolt�;
	private double sommaSpesa;
	private boolean categoria; // true = docente; false = amministrativo;
}
