import java.util.GregorianCalendar;

public class TesserinoStudente extends Tesserino {

	public TesserinoStudente(String matricola, GregorianCalendar scadenza, double saldo, int fascia, boolean bonus,
			String codice, String nome, String cognome, boolean attivo){
		
		super(codice, nome, cognome,attivo);
		
		this.matricola=matricola;
		this.scadenza= scadenza;
		this.saldo=saldo;
		this.fascia=fascia;
		this.bonus=bonus;
	}
	
	public double calcolaPrezzo()
	{
		int fasciaA = 1;
		double prezzoA = 3.00;
		double prezzoB = 2.00;
		double prezzoBonus = 1.00;
		
		
		if (bonus==false)
		{
			if(fascia==fasciaA)
				return prezzoA;
			else return prezzoB;
		}
		else
			return prezzoBonus;
	}
	
	public boolean isBonus(TesserinoStudente ts)
	{
		if(ts.bonus==true)
			return true;
		else 
			return false;
	}
	
	public double paga()
	{
		GregorianCalendar cal = new GregorianCalendar();
		if (scadenza.before(cal))
		{
			throw new TesserinoScadutoException("Tesserino scaduto");
		}
		else 
			if (saldo<calcolaPrezzo())
				throw new SaldoInsufficienteException("Saldo insufficiente");
			else
				return saldo = saldo - calcolaPrezzo();
	}
	
	public void versa(double x)
	{
		if(x<0)
			throw new RuntimeException("Saldo negativo");
		else
			saldo = saldo + x;
	}
	
	public String getMatricola()
	{
		return matricola;
	}
	
	public GregorianCalendar getScadenza()
	{
		return scadenza;
	}
	
	public double getSaldo()
	{
		return saldo;
	}
	
	public int getFascia()
	{
		return fascia;
	}
	
	public boolean getBonus()
	{
		return bonus;
	}
	
	public void setMatricola(String matricola)
	{
		this.matricola=matricola;
	}
	
	public void setScadenza(GregorianCalendar scadenza)
	{
		this.scadenza=scadenza;
	}
	
	public void setSaldo(double saldo)
	{
		this.saldo=saldo;
	}
	
	public void setFascia(int fascia)
	{
		this.fascia=fascia;
	}
	
	public void setBonus(boolean bonus)
	{
		this.bonus=bonus;
	}
	
	public String toString()
	{
		return 
		super.toString() 
		+ "matricola" + matricola						 
		+ "scadenza" + scadenza					 
		+ "saldo" + saldo						 
		+ "fascia" + fascia						 
		+ "bonus" + bonus;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject)) return false;
		TesserinoStudente other = (TesserinoStudente) otherObject;
		return (matricola.equals(other.getMatricola()) 
				&& scadenza.equals(other.getScadenza())
				&& saldo==(other.getSaldo())
				&& fascia==(other.getFascia())
				&& bonus==(other.getBonus()));
				
	}
	
	private String matricola;
	private GregorianCalendar scadenza;
	private double saldo;
	private int fascia;
	private boolean bonus;
	
}
