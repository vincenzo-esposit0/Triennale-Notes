package it.unisa.lp2.contenitore;

public class DataSet{
	//Costruttore
    public DataSet(){
    	first=true;
    }
    
    //Metodi get
    public String getMaximum(){ return max; }
    public String getMinimum(){ return min; }
    
    //Aggiunge un valore 
    public void add( String x ){
        if (first) {
        	max=x;
        	min=x;
        	first=false;
        }    
        if(x.compareTo(min)<0){
            min = x;
        }
        if(x.compareTo(max)>0 ){
            max = x;
        }   
    }
      
   //Attributi
   private String max;
   private String min;
   private boolean first;
    
}