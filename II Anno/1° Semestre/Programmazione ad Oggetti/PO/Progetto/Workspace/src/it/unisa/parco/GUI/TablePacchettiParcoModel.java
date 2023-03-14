package it.unisa.parco.GUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import it.unisa.Agenzia.Pacchetto;
import it.unisa.parco.Gestore.Biglietto;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.Promozione;

public class TablePacchettiParcoModel extends AbstractTableModel{

	/**
	 * Costruisce un nuovo modello dei dati basandosi su un insieme di pacchetti.
	 * 
	 * @param pacchetti pacchetti che comprende il modello dei dati
	 */
	public TablePacchettiParcoModel(ArrayList<Pacchetto> pacchetti){
		
		this.pacchetti=pacchetti;
		
	}
	
	public TablePacchettiParcoModel(){
		
		this.pacchetti=new ArrayList<Pacchetto>();
		
	}
	
	  
	    public void setValueAt(Object value, int row, int column) { }
	    
		/**
		 * Metodo non inerente a TableModel/AbastractTableModel. Questo metodo permette di pulire le informazioni contenute nel modello dei dati
		 * 
		 */
		
		public void removeAllRows(){
			
			while(pacchetti.size()>0){
				
				pacchetti.remove(pacchetti.size()-1);
				
				fireTableRowsDeleted(pacchetti.size()-1,pacchetti.size()-1);
			}
		
			
		}
	    
	    
	    
	    /**
	     * Metodo "custom", non inerente a TableModel/AbstractTableModel.Permette di aggiungere un altro pacchetto all'arraylist del modello dei dati
	     * Inoltre tramite il metodo fireTableRowsInserted notifica l'aggiunta di una riga nel model
	     * 
	     * @param p pacchetto da inserire all'arraylist del modello dei dati
	     */
	    public void aggiunPacchetto(Pacchetto p) {
	    	
	        pacchetti.add(p);

	        int row = pacchetti.size() - 1;
	        
	        // IMPORTANTE, notifica l'aggiunta di una riga nel model
	        fireTableRowsInserted(row, row);
	    }
	 
	 
	    
	    
	    
	    
	    /**
	     * Questo metodo ritorna il contenuto di una cella.
	     * 
	     * @param row riga
	     * @param column colonna
	     */
		  public Object getValueAt(int row, int column) {
		        Pacchetto p = pacchetti.get(row);

		        switch (column) {
		            case 0: return p;
		            case 1: return p.getCodice();
		            case 2: return p.getNome();
		            case 3: return p.getDescrizione();
		            case 4: return p.getPrezzo(); 
		            case 5: return p.getNumBiglietti();
		        }

		        return null;
		    }
	    
	    
			 /**
			  * Ritorna il numero di righe. Numero righe= Dimensione dell'arraylist.
			  * 
			  * @return int numero di righe
			  */
		 public int getRowCount() { 
			 
			 return pacchetti.size();
			 
		 }  
		 
		 /**
		  * Ritorna il numero di colonne.
		  * 
		  * @return int numero di colonne
		  */
	    public int getColumnCount() {
	    	
	        return 6;
	    }
	    
	    
	    
	 
	 
	    /**
	     * Questo metodo ritorna il nome della colonna.
	     * 
	     * @return String nome della colonna
	     */
	 public String getColumnName(int col) {
		 
	     switch (col) {
         	case 0: return "Object";
         	case 1: return "Codice";
         	case 2: return "Nome";
         	case 3: return "Descrizione";
         	case 4:  return "Prezzo";
         	case 5: return "Biglietti Inclusi";
     }

     return "";
		 
	 }
	 	/**
	 	 * Questo metodo ritorna il tipo dei valori di una determinata colonna.
	 	 * 
	 	 * @return Class classe di una determinata colonna
	 	 */
	    public Class getColumnClass(int column) {
	    	
	        switch (column) {
	        
	            case 0: return Pacchetto.class;
	            case 1: return String.class;
	            case 2: return String.class; 
	            case 3: return String.class;
	            case 4: return Double.class;
	            case 5: return Integer.class;
	        }

	        return Object.class;
	    }
	 
	  
		  /**
		   * Questo metodo specifica se le celle sono editabili.
		   * 
		   * @return boolean true se è editabile, altrimenti false
		   */
	  public boolean isCellEditable(int row, int col)
	  {
		  
		 return false;
		 
	  }
	  
	  
	 
	
		public String toString() {
			return super.toString() +"[pacchetti=" + pacchetti + "]";
		}



	ArrayList<Pacchetto> pacchetti=null;
	 
}