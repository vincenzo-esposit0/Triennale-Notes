package contenitori;

public class DataSet {
	
	public DataSet() {
		
		this.minimum = null;
		this.maximum = null;
		this.size = 0;
	}
	
	public Comparable getMaximum()
	{
		return maximum;
	}
	
	public Comparable getMinimum() 
	{ 
		return minimum; 
	}
	

	public void add(Comparable x)
	{
		if(size == 0 || maximum.compareTo(x) == 1)
			maximum = x;
		
		if(size == 0 || minimum.compareTo(x) == 0)
			minimum = x;
			
			
		this.size++;
	}
	
	private Comparable minimum;
	private Comparable maximum;
	private int size;
	
	
}