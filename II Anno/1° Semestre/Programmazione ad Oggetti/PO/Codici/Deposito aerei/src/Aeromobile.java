import java.util.GregorianCalendar;

public class Aeromobile {
	
	/** Costruttore senza parametri che imposta la data dell’ultima revisione alla data odierna, la
	data del prossimo volo a null e il numero dei passeggeri a zero.**/
	
	public Aeromobile(){
		dataRevisione = new GregorianCalendar();
		dataVolo = null;
		passPren = 0;
	}
	
	/** Uno che imposta la data dell’ultima revisione (si controlli che la data sia sempre
	antecedente alla data odierna), la data del prossimo volo (si controlli che la data sia
	seguente alla data odierna) e il numero dei passeggeri prenotati.**/
	
	public Aeromobile(GregorianCalendar dataRevisione,GregorianCalendar dataVolo, int passPren){
		GregorianCalendar oggi = new GregorianCalendar();
		if(dataRevisione.before(oggi)){
			this.dataRevisione = dataRevisione;
		}
		
		if(dataVolo.before(oggi)){
			this.dataVolo = dataVolo;
		}
		
		this.passPren = passPren;
	}
	
	public GregorianCalendar getDataRevisione(){
		return dataRevisione;
	}
	
	public GregorianCalendar getDataVolo(){
		return dataVolo;
	}
	
	public int getPassPren(){
		return passPren;
	}
	
	public void setDataRevisione(GregorianCalendar dataRevisione){
		this.dataRevisione=dataRevisione;
	}
	
	public void setDataVolo(GregorianCalendar dataVolo){
		this.dataVolo=dataVolo;
	}
	
	public void setPassPren(int passPren){
		this.passPren = passPren;
	}
	
	public boolean isExpiredRevision(GregorianCalendar dataRevisione){
		GregorianCalendar oggi = new GregorianCalendar();
		if(dataRevisione.getWeeksInWeekYear()<oggi.getWeeksInWeekYear()){
			return true;
		}
		else 
			return false;
	}
	
	public void effettuaRevisione(){
		this.dataRevisione = new GregorianCalendar();
	}
	
	public String toString()
	{
		return "Data revisione" + dataRevisione + " dataVolo" + dataVolo + " Passegeri prenotati" + passPren;
	}
	
	
	public boolean equals(Object obj){
		if(obj!=null) return false;
		
		if(!(obj instanceof Aeromobile)) return false;
		
		Aeromobile a  = (Aeromobile) obj;
		
		return ( this.dataRevisione == a.dataRevisione &&
				this.dataVolo == a.dataVolo &&
				this.passPren == a.passPren);
	}
	
	private GregorianCalendar dataRevisione;
	private GregorianCalendar dataVolo;
	private int passPren;
}
