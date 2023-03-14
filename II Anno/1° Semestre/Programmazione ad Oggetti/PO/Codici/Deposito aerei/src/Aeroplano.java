import java.util.GregorianCalendar;

public class Aeroplano extends Aeromobile{

	public Aeroplano(String modello, String codiceVolo, String[] rotta,
			GregorianCalendar dataRevisione,GregorianCalendar dataVolo, int passPren){
		
		super(dataRevisione, dataVolo, passPren);
		
		this.modello = modello;
		this.codiceVolo = codiceVolo;
		
	}
	
	public String getModello(){
		return modello;
	}
	
	public String getCodiceVolo(){
		return codiceVolo;
	}
	
	public String[] getRotta(){
		return rotta;
	}
	
	
	public void setModello(String m)
	{
		this.modello = m;
	}
	
	public void setCodiceVolo(String c){
		this.codiceVolo=c;
	}
	
	public void setRotta(String[] r){
		this.rotta = r;
	}
	
	
	public String toString(){
		return 
		super.toString() + "Modello " + modello 
		+ " codice volo " + codiceVolo 
		+ " Rotta " + rotta;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject)) return false;
		Aeroplano other = (Aeroplano) otherObject;
		return(
				modello.equals(other.getModello())&&
				codiceVolo.equals(other.getCodiceVolo())&&
				rotta.equals(other.getRotta()));
	}
	
	
	private String modello;
	private String codiceVolo;
	private String[] rotta;	
}
