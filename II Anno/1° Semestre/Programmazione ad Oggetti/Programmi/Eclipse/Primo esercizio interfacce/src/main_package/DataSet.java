package main_package;

public class DataSet{
	//Costruttore
    public DataSet(){
        sum = 0;
        count = 0;
    }
    //Metodi get
    public Measurable getMaximum(){ return maximum; }
    public Measurable getMinimum(){ return minimum; }
    
    //Aggiunge un valore 
    public void add( Measurable obj ){
        double value = obj.getMeasure();
        sum += value;
       
        if( count == 0 || maximum.getMeasure() < value ){
            maximum = obj;
        }
        if( count == 0 || minimum.getMeasure() > value ){
            minimum = obj;
        }   
        count++;
    }
   
    //Ritorna la media
    public double getAverage(){
        if( count == 0 )
            return 0;
        return sum/count;
    }
    
   //Attributi
    private double sum;
    private Measurable maximum;
    private Measurable minimum;
    private int count;
}