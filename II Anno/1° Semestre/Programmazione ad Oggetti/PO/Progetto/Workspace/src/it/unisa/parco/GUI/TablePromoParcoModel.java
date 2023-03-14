package it.unisa.parco.GUI;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import it.unisa.parco.Gestore.Promozione;

public class TablePromoParcoModel extends AbstractTableModel{

	public TablePromoParcoModel(ArrayList<Promozione> promozioni){
		
		this.promozioni=promozioni;
		
	}
	
	
	public TablePromoParcoModel(){
		
		this.promozioni=new ArrayList<Promozione>();
		
	}
	
	public void removeAllRows(){
		
		while(promozioni.size()>0){
			
			promozioni.remove(promozioni.size()-1);
			
			fireTableRowsDeleted(promozioni.size()-1,promozioni.size()-1);
		}
	
		
	}

	    
	    // Metodo "custom", non inerente a TableModel/AbstractTableModel
	    
	    public void aggiunPromo(Promozione p) {
	    	
	        promozioni.add(p);

	        int row = promozioni.size() - 1;
	        
	        // IMPORTANTE, notifica l'aggiunta di una riga nel model
	        fireTableRowsInserted(row, row);
	    }
	 
	    
	    
	    
	    
	    
		  public Object getValueAt(int row, int column) {
		        Promozione p = promozioni.get(row);

		        switch (column) {
		            case 0: return p;
		            case 1: return p.getCodice();
		            case 2: return p.getNome();
		            case 3: return p.getDescrizione();
		            case 4: return p.getSconto();
		            case 5: return p.getDataInizio().get(Calendar.YEAR) +"-"+ p.getDataInizio().get(Calendar.MONTH)+"-"+ p.getDataInizio().get(Calendar.DAY_OF_MONTH);
		            case 6: return p.getDataScadenza().get(Calendar.YEAR) + "-"+ p.getDataScadenza().get(Calendar.MONTH)+"-"+ p.getDataScadenza().get(Calendar.DAY_OF_MONTH);
		        }

		        return null;
		    }
	    
	    
	    
		 // ritorna il numero di righe
		 public int getRowCount() { 
			 
			 return promozioni.size();
			 
		 }  
	 
	    public int getColumnCount() {
	    	
	        return 7;
	    }
	    
	    
	    
	 
	 
	 // ritorna il nome della colonna
	 public String getColumnName(int col) {
		 
	     switch (col) {
         	case 0: return "Object";
         	case 1: return "Codice";
         	case 2: return "Nome";
         	case 3: return "Descrizione";
         	case 4: return "Sconto";
         	case 5: return "Data Inizio";
         	case 6: return "Data Scadenza";
     }

     return "";
		 
	 }
	 
	    public Class getColumnClass(int column) {
	    	
	        switch (column) {
	        
	            case 0: return Promozione.class;
	            case 1: return String.class;
	            case 2: return String.class;   
	            case 3: return String.class;
	        	case 4: return int.class;
	         	case 5: return GregorianCalendar.class;
	         	case 6: return GregorianCalendar.class;
	        }

	        return Object.class;
	    }
	 
	  /*specifica se le celle sono editabili */
	  
	  
	  public boolean isCellEditable(int row, int col)
	  {
		  
		 return false;
		 
	  }
	  
	  
	 
	
	public String toString() {
		return super.toString() +"[promozioni=" + promozioni + "]";
	}



	private ArrayList<Promozione> promozioni=null;
	
}