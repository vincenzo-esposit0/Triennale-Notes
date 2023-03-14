package it.unisa.parco.Gestore;
import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Exception.NoPromoException;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class Parco {
	
	
	public Parco(String codice)	{
		this.codice=codice;
		this.agenzie= new ArrayList<Agenzia>();
		tel=new ArrayList<String>();
		attivita=new ArrayList<Attivita>();
		bigliettivenduti=new ArrayList<Biglietto>();
		promozioni = new ArrayList<Promozione>();
	}
	
	
	/**
	 * Costruisce un parco basandosi sul nome, la sede, il codice e il num di biglietti in vendita
	 * 
	 * @param nome nome del parco
	 * @param sede nome della sede
	 * @param codice codice del parco
	 * @param numbigliettivendita numero di biglietti in vendita in quel parco
	 */
	public Parco(String codice, String nome, String sede, int numbigliettivendita){
		this.nome=nome;
		this.sede=sede;
		this.codice=codice;
		
		this.agenzie= new ArrayList<Agenzia>();
		tel=new ArrayList<String>();
		attivita=new ArrayList<Attivita>();
		bigliettivenduti=new ArrayList<Biglietto>();
		promozioni = new ArrayList<Promozione>();
		this.numbigliettivendita=numbigliettivendita;
	}
	
	/**
	 * Questo metodo restituisce le promozioni in un determinato intervallo di tempo. Se non è stata trovata nessuna promozione lancia un 
	 * ecccezione del tipo NoPromoException.
	 * 
	 * @param datainizio intervallo
	 * @param datafine intervallo
	 * @exception NoPromoException viene lanciata nel momento in cui non sono state trovate nessuna promo in quell' intervallo di tempo
	 * @return ArrayList lista delle promozioni in una determinata data
	 */
	public ArrayList<Promozione> showPromoByData(JDateChooser datainizio, JDateChooser datafine) throws NoPromoException
	{

			   Calendar datainiziocal = Calendar.getInstance();
			   datainiziocal.setTime(datainizio.getDate());
			   datainiziocal.set(Calendar.MILLISECOND, 0);
			   datainiziocal.set(Calendar.SECOND, 0);
			   datainiziocal.set(Calendar.MINUTE, 0);
			   datainiziocal.set(Calendar.HOUR_OF_DAY, 0);
	        
			   Calendar datafinecal = Calendar.getInstance();
			   datafinecal.setTime(datainizio.getDate());
			   datafinecal.set(Calendar.MILLISECOND, 0);
			   datafinecal.set(Calendar.SECOND, 0);
			   datafinecal.set(Calendar.MINUTE, 0);
			   datafinecal.set(Calendar.HOUR_OF_DAY, 0);
	        
	        
		ArrayList<Promozione> promobydata=new ArrayList<Promozione>();
		
			for(Promozione p:this.getPromozioni()){		
				
				if((p.getDataScadenza().getTime().after(datainizio.getDate()) && p.getDataInizio().getTime().before(datafine.getDate())) || 
					
					p.getDataScadenza().compareTo(datainiziocal)==0 || p.getDataInizio().compareTo(datafinecal)==0){
					promobydata.add(p);
				} 
				
			}
			
			if (promobydata.size()==0){
				
				throw new NoPromoException("Non è stata trovata nessuna promozione in questo intervallo!");		
			}
		
			
			return promobydata;
	}
	
	/**
	 * Questo metodo restituisce le promozioni attive relative ad una determinata attivita ordinandole cronologicamente. Se non vengono trovate promozioni
	 * allora viene lanciata un eccezione del tipo NoPromoException.
	 * 
	 * @exception NoPromoException viene lancia nel momento in cui non sono state trovate promozioni per quella determinata attività.
	 * @param attivita attività selezionata per controlla le promozioni ad esso relative
	 * @return ArrayList lista delle promozioni relative all'attività selezionata
	 */
	public ArrayList<Promozione> showPromoCronologico(Attivita attivita) throws NoPromoException
	{

		int posmin;
		ArrayList<Promozione> promobycron=new ArrayList<Promozione>(attivita.getPromozioni());
		Promozione promotemp;
			
		for(int i=0;i<promobycron.size();i++){
			posmin=i;
				
			for(int j=i+1;j<promobycron.size();j++){
					
					if((promobycron.get(j).getDataScadenza().before(promobycron.get(posmin).getDataScadenza()))){
						posmin=j;
					}
			}		
				
			promotemp=promobycron.get(i);
			promobycron.set(i, promobycron.get(posmin));
			promobycron.set(posmin, promotemp);
		}
		
		if(promobycron.size()==0){
			
			throw new NoPromoException("Nessuna promozione trovata per questa attività!");
		}
		
		return promobycron;
	}
	
	
	/**
	 * Questo metodo restituisce le promozioni attive relative ad una determinata attivita ordinandole cronologicamente
	 * 
	 * @param attivita attività selezionata per trovare le relative promozioni
	 * @return ArrayList lista delle promozione relative all'attività selezionata
	 */
	public ArrayList<Promozione> showPromoLessicografico(Attivita attivita) throws NoPromoException
	{
		int posmin;
		ArrayList<Promozione> promobyless=new ArrayList<Promozione>(attivita.getPromozioni());
		Promozione promotemp;
			
		for(int i=0;i<promobyless.size();i++){
			posmin=i;
				
			for(int j=i+1;j<promobyless.size();j++){
					
					if((promobyless.get(j).getCodice().compareTo(promobyless.get(posmin).getCodice()))<0){
						
						posmin=j;
					
					}
			}		
				
			promotemp=promobyless.get(i);
			promobyless.set(i, promobyless.get(posmin));
			promobyless.set(posmin, promotemp);
		}
		
		if(promobyless.size()==0){
			
			throw new NoPromoException("Nessuna promozione trovata per questa attività!");
		}
		
		return promobyless;
	}
	
	
	
	
	/**
	 * Questo metodo consente la vendita di un biglietto
	 * 
	 * @param biglietto che viene venduto al cliente
	 * @see Biglietto
	 */
	public void vendiBiglietto(Biglietto biglietto)
	{
		
		this.setNumBigliettiVendita(-1);
		this.addBigliettoVenduto(biglietto);
	}
	
	/**
	 * Questo metodo setta il numero di biglietti in vendita in un dato parco
	 * 
	 * @param n numero di biglietti da settare 
	 */
	public void setNumBigliettiVendita(int n){
		
		this.numbigliettivendita=numbigliettivendita + n;
	}
	
	/**
	 * Questo medoto permette l'aggiunta di un numero telefonico alla lista dei numeri relativi al parco
	 *
	 * @param tel numero telefonico da aggiungere alla lista dei numeri del parco
	 */
	
	public void addTel(String tel)
	{
		this.tel.add(tel);
	}
	
	/**
	 * Aggiunge agenzia convenzionata al parco
	 *
	 * @param agenzia convenzionata al parco
	 * @see Agenzia
	 */
	
	public void addAgenzia(Agenzia agenzia){
		
		this.agenzie.add(agenzia);
	}
	
	
	/**
	 * Questo metodo permette di aggiungere una nuova attività relativa al parco
	 * 
	 * @param a attivita da aggiungere alla lista delle attivita
	 */
	public void addAttivita(Attivita a)
	{
		attivita.add(a);
	}

	/**
	 * Questo metodo aggiunge un biglietto ai biglietti venduti dal parco
	 * 
	 * @param biglietto biglietto da aggiungere alla lista dei biglietti venduti
	 * @see Biglietto
	 */
	public void addBigliettoVenduto(Biglietto biglietto)
	{
		this.bigliettivenduti.add(biglietto);
	}
	
	/**
	 * Questo metodo permette di aggiungere una promozione al parco
	 * 
	 * @param promozione promozione da aggiungere alla lista delle promozioni
	 * @see Promozione
	 */
	public void addPromozione(Promozione promozione)
	{
		this.promozioni.add(promozione);
	}
	
	/**
	 * Questo metodo setta il nome del parco
	 * 
	 * @param nome nome del parco
	 */
	public void setNome(String nome){
		
		this.nome=nome;
	}
	
	/**
	 * Questo metodo setta la sede del parco
	 * 
	 * @param sede sede del parco
	 */
	public void setSede(String sede){
		
		this.sede=sede;
	}
	
	
	/**
	 * Questo metodo ritorna il nome del parco
	 * 
	 * @return nome del parco
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Questo metodo restituisce la sede
	 * 
	 * @return sede del parco
	 */
	public String getSede()
	{
		return sede;
	}
	
	
	/**
	 * Questo metodo restituisce i numeri telefonici relativi al parco
	 * 
	 * @return numero di telefono 
	 */
	public ArrayList<String> getTel()
	{
		return tel;
	}
	
	/**
	 * Questo metodo restituisce un array con le attività relative al parco
	 * 
	 * @return ArrayList
	 * @see Attivita
	 */
	public ArrayList<Attivita> getAttivita(){
		
		return attivita;
	}
	
	/**
	 * Questo metodo restituisce i relativi biglietti venduti dal parco
	 * 
	 * @return biglietti venduti
	 * @see Biglietto
	 */
	public ArrayList<Biglietto> getBigliettiVenduti()
	{
		return bigliettivenduti;
	}
	
	/**
	 * Questo metodo restituisce le promozioni
	 * 
	 * @return promozioni del parco
	 * @see Promozione
	 */
	public ArrayList<Promozione> getPromozioni()
	{
		return promozioni;
	}
	
	/**
	 * Questo metodo mostra il numero di biglietti disponibili
	 * 
	 * @return numero di biglietti in vendita
	 */
	public int getNumBigliettiVendita(){
		
		return numbigliettivendita;
	}
	
	/**
	 * Questo metodo ritorna le agenzie convenzionate
	 * 
	 * @return ArrayList
	 * @see Agenzia
	 */
	public ArrayList<Agenzia> getAgenzie(){
		
		return agenzie;
	}
	
	/**
	 * Questo metodo ritorna il codice del parco
	 * 
	 * @return codice del parco
	 */
	public String getCodice(){
		
		return codice;
	}
	
	/**
	 * Questo metodo ritorna l'incasso mensile
	 * @return incasso mensile
	 */
	public double getIncassoMensile(){
		
		double incassosettimanale=0;
		GregorianCalendar g= new GregorianCalendar();
		GregorianCalendar datactualstart= new GregorianCalendar(g.get(Calendar.YEAR),g.get(Calendar.MONTH),01);
		GregorianCalendar datactualend= new GregorianCalendar(g.get(Calendar.YEAR),g.get(Calendar.MONTH),31);
		
		for(Biglietto b:this.getBigliettiVenduti()){
			
			// datactualstart<=data<=datactualend
			
			if((b.getDatAcquisto().after(datactualstart)) && (b.getDatAcquisto().before(datactualend)) || (b.getDatAcquisto().equals(datactualstart))
				|| (b.getDatAcquisto().equals(datactualend)))
			{
				incassosettimanale=incassosettimanale + b.getPrezzo();
			}			
		}
		
		return incassosettimanale;
	}
	
	/**
	 * Questo metodo ritorna l'incasso settimanale
	 * @return incasso settimanale
	 */
	public double getIncassoSettimanale(){
		
		GregorianCalendar g= new GregorianCalendar();
		GregorianCalendar datactual= new GregorianCalendar(g.get(Calendar.YEAR),g.get(Calendar.MONTH),g.get(Calendar.DAY_OF_MONTH));
		GregorianCalendar datactualmeno7= new GregorianCalendar(g.get(Calendar.YEAR),g.get(Calendar.MONTH), g.get(Calendar.DAY_OF_MONTH)-7);
		
		double incassos=0;

		
			for(Biglietto b:this.getBigliettiVenduti()){
				if(b.getDatAcquisto().equals(datactual) || (b.getDatAcquisto().before(datactual) && b.getDatAcquisto().after(datactualmeno7))){
				
					incassos= incassos + b.getPrezzo();
				}
		
			}
		
			return incassos;
	
		
	}
	
	/**
	 * Questo metodo ritorna l'incasso giornaliero
	 * @return incasso giornaliero
	 */
	public double getIncassoGiornaliero(){
		
		
		
		GregorianCalendar g= new GregorianCalendar();
		GregorianCalendar datactual= new GregorianCalendar(g.get(Calendar.YEAR),g.get(Calendar.MONTH),g.get(Calendar.DAY_OF_MONTH));
		
		
		double incassog=0;

		
		for(Biglietto b:this.getBigliettiVenduti()){
			if(b.getDatAcquisto().equals(datactual)){
				
				incassog= incassog + b.getPrezzo();
			}
		
		}
		
		return incassog;
	}
	
	public String toString(){
		
		return getClass().getName() +"[Nome" + nome + "Codice" + codice + "Sede" + sede + "Tel" + tel + "Attivita" + attivita + "Biglietti venduti" + bigliettivenduti + "Promozioni" + promozioni 
				+ "Agenzia" + agenzie + "Numero biglietti in vendita " + numbigliettivendita+"]";
	}
	
	
	public boolean equals(Object object){
		
		if(object==null){
			
			return false;
		}
		
		if(getClass()!=object.getClass()){
			
			return false;
		}
		
		Parco other= (Parco) object;
		return nome.equals(other.getNome()) && codice.equals(other.getCodice()) && sede.equals(other.getSede()) && tel.equals(other.getTel()) && attivita.equals(other.getAttivita()) && bigliettivenduti.equals(other.getBigliettiVenduti()) && 
				promozioni.equals(other.getPromozioni()) && agenzie.equals(other.getAgenzie()) && numbigliettivendita==other.getNumBigliettiVendita();
		
		
	}
	
	private String nome;
	private String codice;
	private String sede;
	private ArrayList<String> tel;
	private ArrayList<Attivita> attivita;
	private ArrayList<Biglietto> bigliettivenduti;
	private ArrayList<Promozione> promozioni;
	private ArrayList<Agenzia> agenzie;
	private int numbigliettivendita;
		
}
