
public class TesserinoPersonale extends Tesserino{
	public TesserinoPersonale(String facoltà, double sommaSpesa, boolean categoria,
			String codice, String nome, String cognome, boolean attivo)
	{
	
	super(codice, nome, cognome, attivo);
		this.facoltà=facoltà;
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
	
	public String getFacoltà()
	{
		return facoltà;
	}
	
	public double getSommaSpesa()
	{
		return sommaSpesa;
	}
	
	public void setFacoltà(String facoltà)
	{
		this.facoltà=facoltà;
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
		"facoltà" + facoltà +
		"sommaSpesa" + sommaSpesa +
		"categoria" + categoria;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject)) return false;
		TesserinoPersonale other = (TesserinoPersonale) otherObject;
		return (facoltà.equals(other.getFacoltà()) 
				&& sommaSpesa==(other.getSommaSpesa())
				&& categoria==(other.getCategoria()));
	}
	
	private String facoltà;
	private double sommaSpesa;
	private boolean categoria; // true = docente; false = amministrativo;
}
