import java.util.ArrayList;

public class ServizioMensa {

	private ArrayList<Tesserino> serviziomensa;
	
	public ServizioMensa()
	{
		this.serviziomensa = new  ArrayList<Tesserino>();
	}
	
	public void addTesserino(Tesserino ts)
	{
		serviziomensa.add(ts);
	}
	
	public boolean usaTesserino(String codice)
	{
		for (Tesserino ts : serviziomensa)
		{
			if (ts.getCodice().equalsIgnoreCase(codice))
			{
				ts.paga();
				cassa = cassa+ts.paga();
				return true;
			}
		}
		return false;
	}
	
	public double calcolaTotale()
	{
		return cassa;
	}
	
	public ArrayList<Tesserino> getLista()
	{
		return serviziomensa;
	}
	
	private double cassa;
}
