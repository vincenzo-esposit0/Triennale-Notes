package it.unisa.parco.GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import it.unisa.Agenzia.Agenzia;
import it.unisa.parco.Gestore.Attivita;

public class TableAgenzieParcoModel extends AbstractTableModel{
	
	
public TableAgenzieParcoModel(ArrayList<Agenzia> agenzie){
		
		this.agenzie=agenzie;
		
	}
	
	  
	    public void setValueAt(Object value, int row, int column) { }
	    
	    
	    // Metodo "custom", non inerente a TableModel/AbstractTableModel
	    
	    public void aggiungiAgenzia(Agenzia a) {
	    	
	    	agenzie.add(a);

	        int row = agenzie.size() - 1;

	        // IMPORTANTE, notifica l'aggiunta di una riga nel model
	        fireTableRowsInserted(row, row);
	    }
	    
	 
	    
	    
	    
	    
	    
		  public Object getValueAt(int row, int column) {
		        Agenzia a = agenzie.get(row);

		        switch (column) {
		        
		        
		            case 0: return a;
		            case 1: return a.getPIva();
		            case 2: return a.getNome();
		            case 3: return a.getIndirizzo();
		            case 4: return a.getTel();
		            case 5: return a.getIncasso();
		            
		        }

		        return null;
		   }
	    
	    
	    
		 // ritorna il numero di righe
		 public int getRowCount() { 
			 
			 return agenzie.size();
			 
		 }  
	 
	    public int getColumnCount() {
	    	
	        return 6;
	    }
	    
	    
	    
	 
	 
	 // ritorna il nome della colonna
	 public String getColumnName(int col) {
		 
	     switch (col) {
         	case 0: return "Object";
         	case 1: return "Codice";
         	case 2: return "Nome";
         	case 3: return "Indirizzo";
         	case 4: return "Tel";
         	case 5: return "Incasso";
     }

     return "";
		 
	 }
	 
	    public Class getColumnClass(int column) {
	    	
	        switch (column) {
	        
	            case 0: return Agenzia.class;
	            case 1: return String.class; 
	            case 2: return String.class;
	            case 3: return String.class;
	            case 4: return String.class;
	            case 5: return double.class;
	        }

	        return Object.class;
	    }
	 
	  /*specifica se le celle sono editabili */
	  
	  
	  public boolean isCellEditable(int row, int col)
	  {
		  
		 return false;
		 
	  }
	  
	  

	public String toString() {
		return super.toString() +"[agenzie=" + agenzie + "]";
	}



	ArrayList<Agenzia> agenzie=null;
	 

}

