package it.unisa.parco.GUI;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import it.unisa.parco.Gestore.Attivita;

public class TableAttivitaParcoModel extends AbstractTableModel{
	
	
public TableAttivitaParcoModel(ArrayList<Attivita> attivita){
		
		this.attivita=attivita;
		
	}
	
	  
	    public void setValueAt(Object value, int row, int column) { }
	    
	    
	    // Metodo "custom", non inerente a TableModel/AbstractTableModel
	    
	    public void aggiungiAttivita(Attivita a) {
	    	
	        attivita.add(a);

	        int row = attivita.size() - 1;

	        // IMPORTANTE, notifica l'aggiunta di una riga nel model
	        fireTableRowsInserted(row, row);
	    }
	 
	    
	    
	    
	    
	    
		  public Object getValueAt(int row, int column) {
		        Attivita a = attivita.get(row);

		        switch (column) {
		        
		        
		            case 0: return a;
		            case 1: return a.getNome();
		            case 2: return a.getOraInizio();
		            case 3: return a.getOraFine();
		            case 4: return a.getCosto();
		            
		            
		        }

		        return null;
		   }
	    
	    
	    
		 // ritorna il numero di righe
		 public int getRowCount() { 
			 
			 return attivita.size();
			 
		 }  
	 
	    public int getColumnCount() {
	    	
	        return 5;
	    }
	    
	    
	    
	 
	 
	 // ritorna il nome della colonna
	 public String getColumnName(int col) {
		 
	     switch (col) {
         	case 0: return "Object";
         	case 1: return "Nome";
         	case 2: return "Ora Inizio";
         	case 3: return "Ora Fine";
         	case 4: return "Costo";
     }

     return "";
		 
	 }
	 
	    public Class getColumnClass(int column) {
	    	
	        switch (column) {
	        
	            case 0: return Attivita.class;
	            case 1: return String.class; 
	            case 2: return String.class;
	            case 3: return String.class;
	            case 4: return double.class;
	        }

	        return Object.class;
	    }
	 
	  /*specifica se le celle sono editabili */
	  
	  
	  public boolean isCellEditable(int row, int col)
	  {
		  
		 return false;
		 
	  }
	  
	  
	 
	public String toString() {
		return super.toString() +"[attivita=" + attivita + "]";
	}



	ArrayList<Attivita> attivita=null;
	 

}
