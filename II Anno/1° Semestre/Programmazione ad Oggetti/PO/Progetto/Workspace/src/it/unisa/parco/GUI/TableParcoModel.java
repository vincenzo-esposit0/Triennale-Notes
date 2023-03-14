package it.unisa.parco.GUI;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import it.unisa.parco.Gestore.Parco;

public class TableParcoModel extends AbstractTableModel{


	/**
	 * Costruisce un nuovo modello dei dati basandosi su un insieme di parchi.
	 * 
	 * @param parchi parchi che comprende il modello dei dati
	 */
	public TableParcoModel(ArrayList<Parco> parchi){
		
		this.parchi=parchi;
		
	}
	
	    
	    
    
	    /**
	     * Metodo "custom", non inerente a TableModel/AbstractTableModel.Permette di aggiungere un altro parco all'arraylist del modello dei dati
	     * Inoltre tramite il metodo fireTableRowsInserted notifica l'aggiunta di una riga nel model
	     * 
	     * @param p parco da inserire all'arraylist del modello dei dati
	     */	    
	    public void aggiungiParco(Parco p) {
	    	
	        parchi.add(p);
	        
	        int row = parchi.size() - 1;
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
		        Parco p = parchi.get(row);

		        switch (column) {
		            case 0: return p;
		            case 1: return p.getNome();
		            case 2: return p.getSede(); 
		        }

		        return null;
		    }
	    
	    
	    
		    
		  /**
		  * Ritorna il numero di righe. Numero righe= Dimensione dell'arraylist.
		  * 
		  * @return int numero di righe
		  */
		 public int getRowCount() { 
			 
			 return parchi.size();
			 
		 }  
	 
		 /**
		  * Ritorna il numero di colonne.
		  * 
		  * @return int numero di colonne
		  */
	    public int getColumnCount() {
	    	
	        return 3;
	    }
	    
	    
	    
	 
	 
		 
	    /**
	     * Questo metodo ritorna il nome della colonna.
	     * 
	     * @return String nome della colonna
	     */
	    
	    public String getColumnName(int col) {
		 
		     switch (col) {
	         	case 0: return "Object";
	         	case 1: return "Nome";
	         	case 2: return "Sede";
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
	        
	            case 0: return Parco.class;
	            case 1: return String.class;
	            case 2: return String.class;    
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
			return super.toString() +"[parchi=" + parchi + "]";
		}



	ArrayList<Parco> parchi=null;
	
}
