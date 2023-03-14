import java.util.GregorianCalendar;

public class Elicottero extends Aeromobile{

	public Elicottero(String destinazione, String identificativo,
			GregorianCalendar dataRevisione,GregorianCalendar dataVolo, int passPren){
		
		super(dataRevisione, dataVolo, passPren);
		
		this.destinazione=destinazione;
		this.identificativo=identificativo;
	}
	
	public String getDestinazione(){
		return destinazione;
	}
	
	public String getIdentificativo(){
		return identificativo;
	}
	
	public void setDestinazione(String d){
		this.destinazione = d;
	}
	
	public void setIdentificativo(String i){
		this.identificativo = i;
	}
	
	public String toString()
	{
		return super.toString() + " Destinazione " + destinazione
				+ " identificativo " + identificativo;
	}
	
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject)) return false;
		Elicottero other = (Elicottero) otherObject;
		return(
				destinazione.equals(other.getDestinazione())&&
				identificativo.equals(other.getIdentificativo()));	
	}

	private String destinazione;
	private String identificativo;
}

