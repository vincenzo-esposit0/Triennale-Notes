import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Deposito {

	private ArrayList<Aeromobile> deposito;
	
	public Deposito()
	{
		this.deposito = new ArrayList<Aeromobile>();
	}
	
	public void addAeromobile(Aeromobile a)
	{
		for(Aeromobile aer: deposito)
		{
			if(aer.equals(a))
			{
				throw new RuntimeException("Aeromobile già presente");
			}
			else
			{
				deposito.add(a);
			}
		}
	}
	
	public ArrayList<Aeromobile> getListaVeicoli()
	{
		return deposito;
	}
	
	public ArrayList<Aeromobile> CercaPerData(GregorianCalendar d){
		GregorianCalendar oggi = new GregorianCalendar();
		ArrayList<Aeromobile> cercati = null;
		
		for (Aeromobile aeromobile : deposito){
			if (aeromobile.isExpiredRevision(oggi) == true)
			{
				cercati.add(aeromobile);
			}
		}
		return cercati;
	}
	
	public void revisioneTutti()
	{
		for (Aeromobile aeromobile : deposito)
		{
			aeromobile.effettuaRevisione();
		}
	}
	
	
	
	
	
}
