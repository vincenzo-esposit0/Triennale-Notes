package it.unisa.parco.GUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import it.unisa.parco.Gestore.Biglietto;
import it.unisa.parco.Gestore.Parco;

public class TableBigliettiParcoModel extends AbstractTableModel{

	public TableBigliettiParcoModel(ArrayList<Biglietto> biglietti){
		
		this.biglietti=biglietti;
		
	}
	
	  
	    public void setValueAt(Object value, int row, int column) { }
	    
	    
	    // Metodo "custom", non inerente a TableModel/AbstractTableModel
	    
	    public void aggiungiBiglietto(Biglietto b) {
	    	
	        biglietti.add(b);

	        int row = biglietti.size() - 1;

	        // IMPORTANTE, notifica l'aggiunta di una riga nel model
	        fireTableRowsInserted(row, row);
	    }
	 
	    
	    
	    
	    
	    
		  public Object getValueAt(int row, int column) {
		        Biglietto b = biglietti.get(row);

		        switch (column) {
		            case 0: return b;
		            case 1: return b.getCodice();
		            case 2: return b.getNome();
		            case 3: return b.getPrezzo();
		            case 4: return b.getDatAcquisto().get(Calendar.YEAR) +"-"+ b.getDatAcquisto().get(Calendar.MONTH)+"-"+ b.getDatAcquisto().get(Calendar.DAY_OF_MONTH);
		        }

		        return null;
		    }
	    
	    
	    
		 // ritorna il numero di righe
		 public int getRowCount() { 
			 
			 return biglietti.size();
			 
		 }  
	 
	    public int getColumnCount() {
	    	
	        return 5;
	    }
	    
	    
	    
	 
	 
	 // ritorna il nome della colonna
	 public String getColumnName(int col) {
		 
	     switch (col) {
         	case 0: return "Object";
         	case 1: return "Codice";
         	case 2: return "Nome";
         	case 3: return "Prezzo";
         	case 4:  return "Data Acquisto";
     }

     return "";
		 
	 }
	 
	    public Class getColumnClass(int column) {
	    	
	        switch (column) {
	        
	            case 0: return Biglietto.class;
	            case 1: return String.class;
	            case 2: return String.class; 
	            case 3: return double.class;
	            case 4: return GregorianCalendar.class;
	        }

	        return Object.class;
	    }
	 
	  /*specifica se le celle sono editabili */
	  
	  
	  public boolean isCellEditable(int row, int col)
	  {
		  
		 return false;
		 
	  }
	  
	  
	public String toString() {
		return super.toString() +"[biglietti=" + biglietti + "]";
	}



	ArrayList<Biglietto> biglietti=null;
	 
}